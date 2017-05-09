package Schwarm;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class Predator extends Aktor {

    private boolean isAlive;        //can only be killed by ManMadeObjects or by crashing into other predators

    public Predator(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.isAlive=true;
    }

    public void act() {
        if(isAlive!=true){
            return;
        }
    }

    public void reAnimate(){
        if(isAlive!=true){
            isAlive=true;
            //set new position here
        }
    }
}
