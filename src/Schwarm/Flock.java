package Schwarm;

import Vektor.Vektor3D;

import java.util.ArrayList;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class Flock {

    ArrayList<Bird> birds;

    public Flock() {
        birds = new ArrayList<Bird>();
    }

    void addBird(Bird birdy) {
        birds.add(birdy);
    }

    void run() {
        for (Bird birdy : birds) {
            birdy.run(birds);
        }
    }

}
