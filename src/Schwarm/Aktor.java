package Schwarm;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class Aktor {

    protected Vektor3D velocity;
    protected Vektor3D position;
    boolean alive;

    public Aktor(Vektor3D velocity,Vektor3D position){
        this.velocity=velocity;
        this.position=position;
        this.alive=true;
    }

    public Vektor3D getVelocity() {
        return velocity;
    }

    public Vektor3D getPosition() {
        return position;
    }

    public void act()
    {

        
    }



}
