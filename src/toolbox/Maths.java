package toolbox;

import Entities.Camera;
import Vektor.Vektor3D;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class Maths {

    public static Matrix4f createTransformationMatrix(Vektor3D translation, double rx, double ry, double rz, double scale, int mode){
        Vector3f translationtemp = new Vector3f((float)translation.x,(float)translation.y,(float)translation.z);
        float scaletemp = (float)scale;
        return (createTransformationMatrix(translationtemp,rx,ry,rz,scaletemp,mode));
    }

    public static Matrix4f createTransformationMatrix(Vektor3D translation, Vektor3D rotation, double scale,int mode){
        Vector3f translationtemp = new Vector3f((float)translation.x,(float)translation.y,(float)translation.z);
        float scaletemp = (float)scale;
        return (createTransformationMatrix(translationtemp,rotation.x,rotation.y,rotation.z,scaletemp,mode));

    }


    public static Matrix4f createTransformationMatrix(Vector3f translation, double rx, double ry, double rz, float scale, int mode){

        Matrix4f matrix = new Matrix4f();
        matrix.setIdentity();
        if(mode!=2)Matrix4f.translate(translation,matrix,matrix);
//        Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0),matrix,matrix);
//        Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0),matrix,matrix);
//        Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1),matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1),matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0),matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0),matrix,matrix);
//        Matrix4f.rotate((float) ((rx*2*3.14)/360), new Vector3f(1,0,0),matrix,matrix);
//        Matrix4f.rotate((float) ((ry*2*3.14)/360), new Vector3f(0,1,0),matrix,matrix);
//        Matrix4f.rotate((float) ((rz*2*3.14)/360), new Vector3f(0,0,1),matrix,matrix);
        if(mode==2)Matrix4f.translate(translation,matrix,matrix);
        Matrix4f.scale(new Vector3f(scale,scale,scale),matrix,matrix);
        return matrix;
    }

    public static Matrix4f createViewMatrix(Camera camera) {
        Matrix4f viewMatrix = new Matrix4f();
        viewMatrix.setIdentity();
        Vektor3D cameraPos = camera.getPosition();
        Vektor3D cameraPosOffset = camera.getPositionOffset();
        Vector3f negativeCameraPos = new Vector3f((float)(-cameraPos.x),(float)(-cameraPos.y),(float)(-cameraPos.z));
        Vector3f negativeCameraPosoffset = new Vector3f((float)(-cameraPosOffset.x),(float)(-cameraPosOffset.y),(float)(-cameraPosOffset.z));
        Matrix4f.translate(negativeCameraPos, viewMatrix, viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1, 0, 0), viewMatrix,   viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getRoll()), new Vector3f(0, 0, 1), viewMatrix, viewMatrix);
        Matrix4f.translate(negativeCameraPosoffset, viewMatrix, viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getRotationOffset().x), new Vector3f(1, 0, 0), viewMatrix,   viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getRotationOffset().y), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
        Matrix4f.rotate((float) Math.toRadians(camera.getRotationOffset().z), new Vector3f(0, 0, 1), viewMatrix, viewMatrix);
        camera.resetRotationOffset();
        camera.resetPositionOffset();
        return viewMatrix;
    }


}
