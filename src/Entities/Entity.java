package Entities;

import Vektor.Vektor3D;
import models.TexturedModel;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class Entity {

    private TexturedModel model;
    private Vektor3D position;
    private double rotX,rotY,rotZ;
    private double scale;
    private int rotationMode = 1;

    public Entity(TexturedModel model, Vektor3D position, double rotX, double rotY, double rotZ, double scale) {
        this.model = model;
        this.position = position;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.scale = scale;
    }

    public Entity(TexturedModel texturedModel, Vektor3D position, Vektor3D rotation, double scale) {
        this(texturedModel,position,rotation.x,rotation.y,rotation.z,scale);
    }

    public void increasePosition(double dx, double dy, double dz){
        try {
            this.position.add(dx,dy,dz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increasePosition(Vektor3D location){
        try {
            this.position.add(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void increaseRotation(double dx, double dy, double dz){
        this.rotX+=dx;
        this.rotY+=dy;
        this.rotZ+=dz;
    }

    public void increaseRotation(Vektor3D rotation){
        increaseRotation(rotation.x, rotation.y, rotation.z);
    }

    public TexturedModel getModel() {
        return model;
    }

    public void setModel(TexturedModel model) {
        this.model = model;
    }

    public Vektor3D getPosition() {
        return position;
    }

    public void setPosition(Vektor3D position) {
        this.position = position;
    }

    public void setRotation(Vektor3D rotation){
        this.rotX=rotation.x;
        this.rotY=rotation.y;
        this.rotZ=rotation.z;
    }

    public double getRotX() {
        return rotX;
    }

    public void setRotX(double rotX) {
        this.rotX = rotX;
    }

    public double getRotY() {
        return rotY;
    }

    public void setRotY(double rotY) {
        this.rotY = rotY;
    }

    public double getRotZ() {
        return rotZ;
    }

    public void setRotZ(double rotZ) {
        this.rotZ = rotZ;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public int getRotationMode() {
        return rotationMode;
    }

    public void setRotationMode(int mode){
        rotationMode=mode;
    }
}
