package shaders;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/29/2017.
 * Not Fully Implemented thus not in final releases yet
 */

public class GPUBirdCalcShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/shaders/vertexShaderGPUBirdCalc.glsl";
    private static final String FRAGMENT_FILE = "src/shaders/fragmentShaderGPUBirdCalc.glsl";

    private int location_cohDistance;
    private int location_sepDistance;
    private int location_aliDistance;
    private int location_otherPosition;
    private int location_otherVelocity;
    private int location_ownPosition;
    private int location_ownVelocity;

    public GPUBirdCalcShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        location_cohDistance = super.getUniformLocation("cohDistance");
        location_sepDistance = super.getUniformLocation("sepDistance");
        location_aliDistance = super.getUniformLocation("aliDistance");

        location_otherPosition = super.getUniformLocation("otherPosition");
        location_otherVelocity = super.getUniformLocation("otherVelocity");
        location_ownPosition = super.getUniformLocation("ownPosition");
        location_ownVelocity = super.getUniformLocation("ownVelocity");
    }

    public void loadUniforms(double cohDistance, double sepDistance, double aliDistance) {
        super.loadDouble(location_aliDistance, aliDistance);
        super.loadDouble(location_cohDistance, cohDistance);
        super.loadDouble(location_sepDistance, sepDistance);
    }

    public void loadVektors(Vektor3D otherPosition, Vektor3D otherVelocity, Vektor3D ownPosition, Vektor3D ownVelocity) {
        super.loadVector(location_otherPosition, otherPosition);
        super.loadVector(location_otherVelocity, otherVelocity);
        super.loadVector(location_ownPosition, ownPosition);
        super.loadVector(location_ownVelocity, ownVelocity);
    }

    @Override
    protected void bindAttributes() {
//        super.bindAttribute(0, "otherPosition");
//        super.bindAttribute(1, "otherVelocity");
//        super.bindAttribute(2, "ownPosition");
//        super.bindAttribute(3, "ownVelocity");
    }

}