package Schwarm;

import Vektor.LineareAlgebra;
import Vektor.Vektor2D;
import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */

public abstract class Aktor {

    protected Vektor3D velocity;
    protected Vektor3D position;

    public Vektor3D rotation;
    protected double Speed;
    public int number;
    boolean alive;
    boolean leftrigjt;
    int iteration = 0;

    public Aktor(Vektor3D velocity, Vektor3D position) {
        this.velocity = velocity;
        this.position = position;
        this.rotation = new Vektor3D();
        this.number = 0;
        this.alive = true;
    }

    public Vektor3D getRotation() {
        return rotation;
    }

    public Vektor3D getVelocity() {
        return velocity;
    }

    public Vektor3D getPosition() {
        return position;
    }

    public abstract void act(ArrayList<Aktor> stuff);

    public void setRotation() {
        Vektor3D rotation = new Vektor3D();
        Vektor3D equirotation = new Vektor3D();
        Vektor3D tempone = new Vektor3D();
        Vektor3D temptwo = new Vektor3D();
        try {
            tempone.setPosition(0, 1, 0);
            temptwo.setPosition(velocity);
            temptwo.mult(1, 1, 0);
            rotation.z = LineareAlgebra.angleDegree(tempone, temptwo);
            tempone.setPosition(velocity);
            temptwo.setPosition(velocity);
            tempone.mult(1, 1, 0);
            rotation.x = LineareAlgebra.angleDegree(tempone, temptwo);
            temptwo.setPosition(velocity);

            if (temptwo.z > 0) {
                rotation.x = 360 - rotation.x;
            }
            if (temptwo.x > 0) {
                rotation.z = 360 - rotation.z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (iteration > 5) {
            iteration = 0;
            if (this.rotation.x < rotation.x) {
                rotation.y += 1;
                leftrigjt = true;
            } else if (this.rotation.x > rotation.x) {
                rotation.y -= 1;
                leftrigjt = false;
            }
        } else {
            iteration++;
            if (leftrigjt == true) {
                rotation.y += 1;
            } else {
                rotation.y -= 1;
            }
        }
        this.rotation = rotation;
    }

}
