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
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import textures.ModelTexture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezydenias on 5/22/2017.
 */

public class MainGameLoop {

    public static final int PLANES = 5;
    public static final int BIRDS = 100;

    public static void main(String[] args) {


        DisplayManager.createDisplay();
        Loader loader = new Loader();
        MasterRenderer renderer = new MasterRenderer();
        List<Entity> allBirds = new ArrayList<Entity>();
        List<Entity> allPlanes = new ArrayList<Entity>();
        final Flock schwarm = new Flock();


        double[] vertices = {
                -0.5, 0.5, 0,
                -0.5, -0.5, 0,
                0.5, -0.5, 0,
                0.5, 0.5, 0,
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2
        };

        double[] textureCoords = {
                0, 0,
                0, 1,
                1, 1,
                1, 0
        };

        double[] normals = {
                -1, -1, 0,
                -1, -1, 0,
                -1, -1, 0,
                -1, -1, 0
        };


        Light light = new Light(new Vektor3D(3, 0, -20), new Vektor3D(1, 1, 1));
        Light light2 = new Light(new Vektor3D(-7, 0, 0), new Vektor3D(1, 1, 1));

        RawModel model = loader.loadToVAO(vertices, textureCoords, normals, indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("picture"));
        TexturedModel texturedModel = new TexturedModel(model, texture);

        RawModel barn = OBJLoader.loadObjModel("stall", loader);
        ModelTexture barnTex = new ModelTexture(loader.loadTexture("stallTexture"));
        TexturedModel barnModel = new TexturedModel(barn, barnTex);

        RawModel bird = OBJLoader.loadObjModel("bird",loader);
        ModelTexture birdTex = new ModelTexture(loader.loadTexture("white"));
        birdTex.setShineDamper(20);
        birdTex.setReflectivity(30);
        birdTex.setToon(70);
        birdTex.setOutlinecolor(0, 0, 0);
        TexturedModel birdModel = new TexturedModel(bird,birdTex);


        RawModel plane= OBJLoader.loadObjModel("plane",loader);
        ModelTexture planeTex = new ModelTexture(loader.loadTexture("black"));
        planeTex.setShineDamper(20);
        planeTex.setReflectivity(30);
        planeTex.setToon(70);
        planeTex.setOutlinecolor(1, 1, 1);
        TexturedModel planeModel = new TexturedModel(plane,planeTex);


        RawModel dragon = OBJLoader.loadObjModel("dragon", loader);
        ModelTexture dragonTex = new ModelTexture(loader.loadTexture("white"));
        dragonTex.setShineDamper(20);
        dragonTex.setReflectivity(30);
        dragonTex.setToon(70);
        dragonTex.setOutlinecolor(0, 0, 0);
        TexturedModel dragonModel = new TexturedModel(dragon, dragonTex);

        Entity entity = new Entity(texturedModel, new Vektor3D(0, 0, -300), 0, 0, 0, 1000);
        Entity barnEntity = new Entity(barnModel, new Vektor3D(), 0, 0, 0, 1);
        Entity dragonEntity = new Entity(dragonModel, new Vektor3D(0, 0, -15), 0, 0, 0, 1);


//        for (int i = 0; i < 2; i++)
//            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1), new Vektor3D((Math.random() * 300), (Math.random() * 300), (Math.random() * 300))));
        for (int i = 0; i < BIRDS; i++) {
            schwarm.addBird(new Bird(new Vektor3D((Math.random() * 300) - 150, (Math.random() * 300) - 150, (Math.random() * 300) - 150), new Vektor3D((Math.random() * 300) - 150, (Math.random() * 300) - 150, -(Math.random() * 100) - 50)));
        }
        for (int i = 0; i < PLANES; i++) {
            schwarm.addBird(new Plane(new Vektor3D((Math.random() * 1), (Math.random() * 1), (Math.random() * 1)), new Vektor3D((Math.random() * 400) - 200, (Math.random() * 400) - 200, (Math.random() * 300) - 150)));
        }

        for (Aktor birdy : schwarm.Aktor) {
            if (birdy.getClass() == Bird.class) {
                allBirds.add(new Entity(birdModel, birdy.getPosition(), birdy.rotation, 1));
            }
        }

        for (Aktor plany : schwarm.Aktor) {
            if (plany.getClass() == Plane.class) {
                allBirds.add(new Entity(planeModel, plany.getPosition(), plany.rotation, 3));
                allPlanes.add(new Entity(barnModel, plany.getPosition(), plany.rotation, 1));
            }
        }

        Camera camera = new Camera();


        Thread schwarmthread = new Thread(new Runnable() {
            public void run() {
                while (!Display.isCloseRequested()) {
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

        while (!Display.isCloseRequested()) {


            camera.move();

            //schwarm.run();


            int i = 0;
            int j = 0;
            for (Aktor birdy : schwarm.Aktor) {
                if (birdy.getClass() == Bird.class) {
                    try {
                        allBirds.get(i).setPosition(birdy.getPosition());
                        allBirds.get(i).setRotation(birdy.getRotation());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("doesn't exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (birdy instanceof  Plane) {
                    try {
                        allBirds.get(i).setPosition(birdy.getPosition());
                        birdy.setRotation();
                        allBirds.get(i).setRotation(birdy.getRotation());
                        allPlanes.get(j).setPosition((LineareAlgebra.add(birdy.getPosition(),LineareAlgebra.mult(birdy.getVelocity(),10))));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("doesn't exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j++;
                }
                i++;
            }



            for (Entity birds : allBirds) {


                renderer.processEntity(birds);
            }

            for (Entity birds : allPlanes) {


                renderer.processEntity(birds);
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

            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }

        renderer.cleanUp();
        loader.cleanUp();
        schwarmthread.stop();
        DisplayManager.closeDisplay();
    }


}
