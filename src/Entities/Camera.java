package Entities;

import Vektor.Vektor3D;
import org.lwjgl.input.Keyboard;

/**
 * Created by Ezydenias on 5/23/2017.
 */

public class Camera {

    private Vektor3D position = new Vektor3D(0,300,500);
    private Vektor3D rotation = new Vektor3D(30,0,0);

    public Camera() {
    }

    public void move(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.z-=0.1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x+=0.1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x-=0.1;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.z+=0.1;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD8)){
            position.y+=0.03;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD6)){
            rotation.y+=0.5;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD4)){
            rotation.y-=0.5;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_NUMPAD2)){
            position.y-=0.03;
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

}
