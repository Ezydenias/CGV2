package Schwarm;

import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */


public abstract class ManMadeObjects extends Aktor {

    //are imortal but only fly in random patterns or single diretions

    public ManMadeObjects(Vektor3D velocity, Vektor3D position) {
        super(velocity, position);
    }

    public abstract void act(ArrayList<Aktor> stuff);


}
