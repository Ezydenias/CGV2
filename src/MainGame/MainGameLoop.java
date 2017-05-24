package MainGame;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Schwarm.Aktor;
import Schwarm.Bird;
import Schwarm.Flock;
import Schwarm.Plane;
import Vektor.LineareAlgebra;
import Vektor.Vektor3D;
import com.sun.org.apache.xpath.internal.operations.Mod;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.*;
import models.RawModel;
import shaders.StaticShader;
import textures.ModelTexture;

import javax.management.openmbean.ArrayType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezydenias on 5/22/2017.
 */
public class MainGameLoop {

    public static void main(String[] args){


        DisplayManager.createDisplay();
        Loader loader = new Loader();
        MasterRenderer renderer = new MasterRenderer();
        List<Entity> allBirds= new ArrayList<Entity>();
        List<Entity> allPlanes=new ArrayList<Entity>();
        final Flock schwarm = new Flock();


        double[] vertices = {
                -0.5,0.5,0,
                -0.5,-0.5,0,
                0.5,-0.5,0,
                0.5,0.5,0,
        };

        int[] indices = {
                0,1,3,
                3,1,2
        };

        double[] textureCoords = {
                0, 0,
                0, 1,
                1, 1,
                1,0
        };

        double[] normals = {
                -1,-1,0,
                -1,-1,0,
                -1,-1,0,
                -1,-1,0
        };




        Light light = new Light(new Vektor3D(3,0,-20), new Vektor3D(1,1,1));
        Light light2 = new Light(new Vektor3D(-7,0,0), new Vektor3D(1,1,1));

        RawModel model = loader.loadToVAO(vertices,textureCoords,normals,indices);
        ModelTexture texture=new ModelTexture(loader.loadTexture("picture"));
        TexturedModel texturedModel=new TexturedModel(model,texture);

        RawModel barn = OBJLoader.loadObjModel("stall",loader);
        ModelTexture barnTex = new ModelTexture(loader.loadTexture("stallTexture"));
        TexturedModel barnModel = new TexturedModel(barn,barnTex);

        RawModel dragon = OBJLoader.loadObjModel("dragon",loader);
        ModelTexture dragonTex = new ModelTexture(loader.loadTexture("white"));
        dragonTex.setShineDamper(20);
        dragonTex.setReflectivity(30);
        dragonTex.setToon(70);
        dragonTex.setOutlinecolor(0,0,0);
        TexturedModel dragonModel = new TexturedModel(dragon,dragonTex);

        Entity entity = new Entity(texturedModel,new Vektor3D(0,0,-3),0,0,0,1);
        Entity barnEntity = new Entity(barnModel,new Vektor3D(),0,0,0,1);
        Entity dragonEntity = new Entity(dragonModel,new Vektor3D(0,0,-15),0,0,0,1);



//        for (int i = 0; i < 2; i++)
//            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1), new Vektor3D((Math.random() * 300), (Math.random() * 300), (Math.random() * 300))));
        for (int i = 0;i<300;i++) {
            schwarm.addBird(new Bird(new Vektor3D((Math.random() * 300)-150, (Math.random() * 300)-150, (Math.random() * 300)-150), new Vektor3D((Math.random() * 300)-150, (Math.random() * 300)-150, -(Math.random() * 100)-50)));
        }
        for (int i = 0;i<5;i++){
            schwarm.addBird(new Plane(new Vektor3D((Math.random() * 1), (Math.random() * 1), (Math.random() * 1)), new Vektor3D((Math.random() * 400)-200, (Math.random() * 400)-200, (Math.random() * 300)-150)));
        }

        for (Aktor birdy : schwarm.Aktor) {
            if (birdy.getClass() == Bird.class) {
                allBirds.add(new Entity(barnModel,birdy.getPosition(),birdy.rotation,1));
            }
        }

        for (Aktor plany:schwarm.Aktor){
            if(plany.getClass()==Plane.class){
                allBirds.add(new Entity(dragonModel,plany.getPosition(),plany.rotation,1));
            }
        }

        Camera camera = new Camera();


        Thread schwarmthread = new Thread(new Runnable() {
            public void run() {
                while(!Display.isCloseRequested()) {
                    schwarm.run();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        schwarmthread.start();


        //schwarmthread.run();

        while(!Display.isCloseRequested()){

            entity.increasePosition(0,0,0);
            entity.increaseRotation(0,-1,0);
            barnEntity.increaseRotation(0,1,0);
            dragonEntity.increaseRotation(0,1,0);
            camera.move();

            //schwarm.run();


            int i = 0;

            for (Aktor birdy : schwarm.Aktor) {
                if (birdy.getClass() == Bird.class) {
                    try {
                        allBirds.get(i).setPosition(birdy.getPosition());
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("doesn't exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }

            for (Aktor birdy : schwarm.Aktor) {
                if (birdy.getClass() == Plane.class) {
                    try {
                        allBirds.get(i).setPosition(birdy.getPosition());
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("doesn't exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }


            for (Entity bird : allBirds){


                renderer.processEntity(bird);
            }

//            for (Aktor birdy : schwarm.Aktor) {
//                if (birdy.getClass() == Bird.class) {
//
//                    renderer.processEntity(entity);
//            }
//
//            }



            renderer.processEntity(dragonEntity);

            renderer.addLights(light2);

            renderer.render(light,camera);
            DisplayManager.updateDisplay();
        }

        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }



}
