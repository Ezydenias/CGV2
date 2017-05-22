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
            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1),new Vektor3D((Math.random() * 300), (Math.random() * 300), (Math.random() * 300))));

        for (int i=0;i<3000;i++) {
            schwarm.run();
            for (Aktor birdy : schwarm.Aktor) {
                verlauf.add(new Vektor3D(birdy.getPosition()));


            }
        }


    }




    public void paint (Graphics g) {
        int x=0, y=0, i=0;
        for (Vektor3D lauf : this.verlauf) {
            i++;
            switch (i){
                case 0:
                    g.setColor(Color.green);
                    break;
                case 1:
                    g.setColor(Color.orange);
                    break;
                case 2:
                   g.setColor(Color.red);
                   break;
                case 3:
                    g.setColor(Color.blue);
                    break;
               case 5:
                    i=0;
                    g.setColor(Color.black);
                    break;
            }

            x=(int)lauf.x;
            y=(int)lauf.y;
            g.drawLine(x+1000,y+1000,x+1001,y+1001);

        }
    }
}
