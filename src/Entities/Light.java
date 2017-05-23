package Entities;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/23/2017.
 */
public class Light {

    private Vektor3D position;
    private Vektor3D color;

    public Light(Vektor3D position, Vektor3D color) {
        this.position = position;
        this.color = color;
    }

    public Vektor3D getPosition() {
        return position;
    }

    public void setPosition(Vektor3D position) {
        this.position = position;
    }

    public Vektor3D getColor() {
        return color;
    }

    public void setColor(Vektor3D color) {
        this.color = color;
    }
}
