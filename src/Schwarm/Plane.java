package Schwarm;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/9/2017.
 */


public class Plane extends ManMadeObjects{

    private Projectile one;         //cann have two Missles
    private Projectile two;         //planes try to kill each other

    private boolean isAlive;

    public Plane(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
        this.isAlive=true;
    }

    public void reAnimate(){
        if(isAlive!=true){
            isAlive=true;
            //set new position here
        }
    }
}
