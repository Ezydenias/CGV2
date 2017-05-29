package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import shaders.GPUBirdCalcShader;

/**
 * Created by Ezydenias on 5/29/2017.
 */

public class GPUBirdCalcRenderer {

    private GPUBirdCalcShader shader;

    public GPUBirdCalcRenderer(GPUBirdCalcShader shader) {
        this.shader = shader;
        shader.start();
        shader.stop();
    }

    public void render(){

    }

    public void prepareBird(double cohDistance, double sepDistance, double aliDistance){
        GL30.glBindVertexArray(1);
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL20.glEnableVertexAttribArray(2);
        GL20.glEnableVertexAttribArray(3);

        shader.loadUniforms(cohDistance,sepDistance,aliDistance);
    }


    public void unbindTexturedModel(){
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL20.glDisableVertexAttribArray(2);
        GL20.glDisableVertexAttribArray(3);
        GL30.glBindVertexArray(0);
    }

}
