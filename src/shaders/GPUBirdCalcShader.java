package shaders;

/**
 * Created by Ezydenias on 5/29/2017.
 */

public class GPUBirdCalcShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/shaders/vertexShaderGPUBirdCalc.glsl";
    private static final String FRAGMENT_FILE = "src/shaders/fragmentShaderGPUBirdCalc.glsl";

    private int location_cohDistance;
    private int location_sepDistance;
    private int location_aliDistance;

    public GPUBirdCalcShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        location_cohDistance = super.getUniformLocation("cohDistance");
        location_sepDistance = super.getUniformLocation("sepDistance");
        location_aliDistance = super.getUniformLocation("aliDistance");
    }

    public void loadUniforms(double cohDistance, double sepDistance, double aliDistance) {
        super.loadDouble(location_aliDistance, aliDistance);
        super.loadDouble(location_cohDistance, cohDistance);
        super.loadDouble(location_sepDistance, sepDistance);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "otherPosition");
        super.bindAttribute(1, "otherVelocity");
        super.bindAttribute(2, "ownPosition");
        super.bindAttribute(3, "ownVelocity");
    }

}