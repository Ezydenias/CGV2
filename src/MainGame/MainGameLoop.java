package MainGame;

import com.sun.org.apache.xpath.internal.operations.Mod;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
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
        Renderer renderer= new Renderer();
        StaticShader shader = new StaticShader();

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

        RawModel model = loader.loadToVAO(vertices,textureCoords,indices);
        ModelTexture texture=new ModelTexture(loader.loadTexture("picture"));
        TexturedModel texturedModel=new TexturedModel(model,texture);

        while(!Display.isCloseRequested()){
            renderer.prepare();
            shader.start();
            renderer.render(texturedModel);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
