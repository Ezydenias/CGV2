package MainGame;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Vektor.Vektor3D;
import com.sun.org.apache.xpath.internal.operations.Mod;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

/**
 * Created by Ezydenias on 5/22/2017.
 */
public class MainGameLoop {

    public static void main(String[] args){


        DisplayManager.createDisplay();
        Loader loader = new Loader();
        StaticShader shader = new StaticShader();
        Renderer renderer= new Renderer(shader);

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
                1,1,0,
                1,1,0,
                1,1,0,
                1,1,0
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
        TexturedModel dragonModel = new TexturedModel(dragon,dragonTex);

        Entity entity = new Entity(texturedModel,new Vektor3D(0,0,-3),0,0,0,1);
        Entity barnEntity = new Entity(barnModel,new Vektor3D(),0,0,0,1);
        Entity dragonEntity = new Entity(dragonModel,new Vektor3D(0,0,-15),0,0,0,1);

        Camera camera = new Camera();

        while(!Display.isCloseRequested()){

            entity.increasePosition(0,0,0);
            entity.increaseRotation(0,-1,0);
            barnEntity.increaseRotation(0,1,0);
            dragonEntity.increaseRotation(0,1,0);
            camera.move();
            renderer.prepare();
            shader.start();
            shader.loadLight(light);
            shader.loadLight(light2);
            shader.loadViewMatrix(camera);
            renderer.render(entity,shader);
            renderer.render(dragonEntity,shader);
            //renderer.render(barnEntity,shader);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
