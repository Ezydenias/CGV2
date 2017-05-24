package Schwarm;

import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class Flock {

    public ArrayList<Aktor> Aktor;

    public Flock() {
        Aktor = new ArrayList<Aktor>();
    }

    public void addBird(Aktor birdy) {
        Aktor.add(birdy);
    }

    public void run() {
        int i = 0;
        for (Aktor birdy : Aktor) {
            birdy.number=i;
            birdy.act(Aktor);
            i++;
        }
    }



}
