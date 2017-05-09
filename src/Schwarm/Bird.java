package Schwarm;

import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class Bird extends Aktor{

    private boolean isAlive;        //die from everything

    public Bird(Vektor3D velocity, Vektor3D position)
    {
        super(velocity, position);
        this.isAlive=true;
    }

    public void act(ArrayList<Aktor> stuff) {

    }

    public void act(){
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
