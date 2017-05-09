package Schwarm;

import Vektor.Vektor3D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.awt.Graphics.*;

/**
 * Created by Ezydenias on 5/9/2017.
 */
public class planetest extends JPanel {

    public int x;
    public int y;
    static ArrayList<Vektor3D> verlauf;


    public static void main(String[] args){


        verlauf=new ArrayList<Vektor3D>();
        JFrame F = new JFrame();
        F.setVisible(true);
        F.add(new planetest());
        F.setSize(3000,3000);


    }

    planetest(){
        Flock schwarm = new Flock();

        for (int i = 0; i<5;i++)
            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1),new Vektor3D((Math.random() * 1001), (Math.random() * 1001), (Math.random() * 1001))));

        for (int i=0;i<10000;i++) {
            schwarm.run();
            for (Aktor birdy : schwarm.Aktor) {
                verlauf.add(new Vektor3D(birdy.getPosition()));


            }
        }


    }




    public void paint (Graphics g) {
        int x=0, y=0;
        for (Vektor3D lauf : this.verlauf) {
            x=(int)lauf.x;
            y=(int)lauf.y;
            g.drawLine(x,y,x+1,y+1);

        }
    }
}
