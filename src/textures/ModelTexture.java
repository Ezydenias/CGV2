package textures;

import Vektor.Vektor3D;

/**
 * Created by Ezydenias on 5/22/2017.
 */
public class ModelTexture {

    private int textureID;

    private float shineDamper=1;
    private float reflectivity=0;
    private float toon=0;
    private Vektor3D outlinecolor;

    public ModelTexture(int id){
        this.textureID=id;
        outlinecolor=new Vektor3D();
    }

    public int getID(){
        return this.textureID;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }

    public float getToon() {
        return toon;
    }

    public void setToon(float toon) {
        this.toon = toon;
    }

    public Vektor3D getOutlinecolor() {
        return outlinecolor;
    }

    public void setOutlinecolor(Vektor3D outlinecolor) {
        this.outlinecolor = outlinecolor;
    }

    public void setOutlinecolor(double r, double g, double b) {
        this.outlinecolor.x=r;
        this.outlinecolor.y=g;
        this.outlinecolor.z=b;
    }
}
