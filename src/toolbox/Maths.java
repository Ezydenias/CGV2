package toolbox;

import Vektor.Vektor3D;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class Maths {

    public static Matrix4f createTransformationMatrix(Vektor3D translation, double rx, double ry, double rz, double scale){
        Vector3f translationtemp = new Vector3f((float)translation.x,(float)translation.y,(float)translation.z);
        float scaletemp = (float)scale;
        return (createTransformationMatrix(translationtemp,rx,ry,rz,scaletemp));
    }

    public static Matrix4f createTransformationMatrix(Vektor3D translation, Vektor3D rotation, double scale){
        Vector3f translationtemp = new Vector3f((float)translation.x,(float)translation.y,(float)translation.z);
        float scaletemp = (float)scale;
        return (createTransformationMatrix(translationtemp,rotation.x,rotation.y,rotation.z,scaletemp));

    }


    public static Matrix4f createTransformationMatrix(Vector3f translation, double rx, double ry, double rz, float scale){

        Matrix4f matrix = new Matrix4f();
        matrix.setIdentity();
        Matrix4f.translate(translation,matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0),matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0),matrix,matrix);
        Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1),matrix,matrix);
        Matrix4f.scale(new Vector3f(scale,scale,scale),matrix,matrix);
        return matrix;
    }
}
