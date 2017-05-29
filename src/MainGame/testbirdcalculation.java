package MainGame;

import renderEngine.DisplayManager;
import renderEngine.GPUBirdCalcRenderer;
import renderEngine.Renderer;
import shaders.GPUBirdCalcShader;
import org.lwjgl.opengl.Display;

/**
 * Created by Ezydenias on 5/29/2017.
 */

public class testbirdcalculation {

    public static void main(String[] args) {

        DisplayManager.closeDisplay();

        GPUBirdCalcShader BirdShader = new GPUBirdCalcShader();
        GPUBirdCalcRenderer BirdRenderer = new GPUBirdCalcRenderer(BirdShader);


        BirdRenderer.prepareBird(10,10,10);

        DisplayManager.updateDisplay();
        BirdRenderer.unbindTexturedModel();
        DisplayManager.closeDisplay();
    }


}
