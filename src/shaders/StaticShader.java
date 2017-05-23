package shaders;

import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Ezydenias on 5/22/2017.
 */

public class StaticShader extends ShaderProgram{

    private static final String VERTEX_FILE="src/shaders/vertexShader";
    private static final String FRAGMENT_FILE="src/shaders/fragmentShader";

    private int location_transformationMatrix;
    private int location_projectionMatrix;

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix =  super.getUniformLocation("transformationMatrix");
        location_transformationMatrix=super.getUniformLocation("projectionMatrix");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0,"position");
        super.bindAttribute(1,"textureCoordinate");
    }

    public void loadTransformationMatrix(Matrix4f matrix ){
        super.loadMatrix(location_transformationMatrix,matrix);
    }

    public void loadProjectionMatrix(Matrix4f projection){
        super.loadMatrix(location_projectionMatrix,projection);
    }
}
