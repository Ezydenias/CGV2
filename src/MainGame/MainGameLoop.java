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
        final Flock schwarm = new Flock();

        Light light = new Light(new Vektor3D(3, 0, -20), new Vektor3D(1, 1, 1));
        Light light2 = new Light(new Vektor3D(-7, 0, 0), new Vektor3D(1, 1, 1));
        Camera camera = new Camera();

        RawModel bird = OBJLoader.loadObjModel("bird", loader);
        ModelTexture birdTex = new ModelTexture(loader.loadTexture("white"));
        birdTex.setShineDamper(20);
        birdTex.setReflectivity(30);
        birdTex.setToon(70);
        birdTex.setOutlinecolor(0, 0, 0);
        TexturedModel birdModel = new TexturedModel(bird, birdTex);

        RawModel plane = OBJLoader.loadObjModel("plane", loader);
        ModelTexture planeTex = new ModelTexture(loader.loadTexture("black"));
        planeTex.setShineDamper(20);
        planeTex.setReflectivity(30);
        planeTex.setToon(70);
        planeTex.setOutlinecolor(1, 1, 1);
        TexturedModel planeModel = new TexturedModel(plane, planeTex);


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
                allBirds.add(new Entity(planeModel, plany.getPosition(), plany.rotation, 1));
            }
        }

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

        while (!Display.isCloseRequested()) {

            camera.move();

            int i = 0;
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
                if (birdy instanceof Plane) {
                    try {
                        allBirds.get(i).setPosition(birdy.getPosition());
                        birdy.setRotation();
                        allBirds.get(i).setRotation(birdy.getRotation());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("doesn't exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }

            for (Entity birds : allBirds) {


                renderer.processEntity(birds);
            }
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
