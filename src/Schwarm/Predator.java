package Schwarm;

import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 * Need to implement killing birds and their behavior, not for the resea<rch paper trough
 */

public class Predator extends Aktor {

    private boolean isAlive;        //can only be killed by ManMadeObjects or by crashing into other predators

    public Predator(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.isAlive = true;
    }

    public void act(ArrayList<Aktor> stuff) {

    }

    public void act() {
        if (isAlive != true) {
            return;
        }
    }

    public void reAnimate() {
        if (isAlive != true) {
            isAlive = true;
            //set new position here
        }
    }
}
