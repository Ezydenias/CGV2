package Entities;

import Vektor.Vektor3D;
import org.lwjgl.input.Keyboard;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class Camera {

    private Vektor3D position = new Vektor3D(0,0,200);
    private Vektor3D rotation = new Vektor3D(10,0,30);
    private Vektor3D positionOffset = new Vektor3D();

    public Vektor3D getRotationOffset() {
        return rotationOffset;
    }

    public void setRotationOffset(Vektor3D rotationOffset) {
        this.rotationOffset = rotationOffset;
    }

    private Vektor3D rotationOffset = new Vektor3D();

    public Vektor3D getPositionOffset() {
        return positionOffset;
    }

    public void setPositionOffset(Vektor3D positionOffset) {
        this.positionOffset = positionOffset;
    }

    public Camera() {
    }

    public void move(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            positionOffset.z-=2;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            positionOffset.x+=2;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            positionOffset.x-=2;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            positionOffset.z+=2;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            positionOffset.y+=2;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            positionOffset.y-=2;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)){
            rotationOffset.x-=0.5;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){
            rotationOffset.y+=0.5;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){
            rotationOffset.y-=0.5;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){
            rotationOffset.x+=0.5;
        }
    }

    public Vektor3D getPosition() {
        return position;
    }

    public Vektor3D getRotation() {
        return rotation;
    }

    public double getPitch() {
        return rotation.x;
    }

    public double getYaw() {
        return rotation.y;
    }

    public double getRoll() {
        return rotation.z;
    }

    public void resetPositionOffset() {
        try {
            position.add(positionOffset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        positionOffset.setPosition(0,0,0);
    }

    public void resetRotationOffset() {
        try {
            rotation.add(rotationOffset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rotationOffset.setPosition(0,0,0);
    }
}
