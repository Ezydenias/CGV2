package Schwarm;

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

    public Aktor(Vektor3D velocity,Vektor3D position){
        this.velocity=velocity;
        this.position=position;
        this.rotation=new Vektor3D();
        this.number=0;

        this.alive=true;
    }

    public Vektor3D getVelocity() {
        return velocity;
    }


    public Vektor3D getPosition() {
        return position;
    }

    public abstract void act(ArrayList<Aktor> stuff);


}
