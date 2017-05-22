package Schwarm;

/**
 * Created by Ezydenias on 5/8/2017.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

import Vektor.LineareAlgebra;
import Vektor.Vektor3D;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.beans.FeatureDescriptor;

public class SchwarmTest {

    //public Flock schwarm;

    public static void main(String[] args) {
        Flock schwarm = initschwarm();
        initDisplay();
        initGL();
        gameloop(schwarm);
        cleanUp();

    }

    private static void cleanUp() {
        Display.destroy();
    }

    private static void initGL() {

        glDisable(GL_TEXTURE_2D);
        glShadeModel(GL_SMOOTH);
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glClearDepth(1.0);
        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(
                100.0f,
                (float) Display.getWidth() / (float) Display.getHeight(),
                0.1f,
                100.0f);

        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);


    }

    private static void gameloop(Flock schwarm) {
        glTranslatef(0f, 0.0f, -20f);

        while (!Display.isCloseRequested()) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);




            schwarm.run();



            for (Aktor birdy : schwarm.Aktor) {
                glLoadIdentity();





                if (birdy.getClass() == Plane.class) {
                    setRotation(birdy);
                    glTranslated((birdy.getPosition().x) / 100, (birdy.getPosition().y) / 100, ((birdy.getPosition().z) / 100) - 40);
                    //glRotated(90,0,0,1);
                    glRotated(birdy.rotation.x, 1.0, 0.0, 0.0);
                    glRotated(birdy.rotation.y, 0.0, 1.0, 0.0);
                    glRotated(birdy.rotation.z, 0.0, 0.0, 1.0);
                    glScaled(0.2, 0.2, 0.2);
                    glPushMatrix();
                    glBegin(GL_QUADS);
                    planeModell();
                    glEnd();

                    glPopMatrix();
                }

                if (birdy.getClass() == Bird.class) {
                    //glRotated(45, 1.0, 0.0, 1.0);
                    glTranslated(-2,-2,-10);
                    glTranslated((birdy.getPosition().x) / 100, (birdy.getPosition().y) / 100, ((birdy.getPosition().z) / 100));
                    //glRotated(90,0,0,1);
                   // glRotated(birdy.rotation.x, 1.0, 0.0, 0.0);
                   // glRotated(birdy.rotation.y, 0.0, 1.0, 0.0);
                   // glRotated(birdy.rotation.z, 0.0, 0.0, 1.0);
                    glScaled(0.1, 0.1, 0.1);
                    glPushMatrix();
                    glBegin(GL_QUADS);
                    cube();
                    glEnd();

                    glPopMatrix();
                }
//                glLoadIdentity();
//                glTranslated((birdy.getPosition().x+birdy.velocity.x*100) / 100, (birdy.getPosition().y-birdy.velocity.y*100) / 100, ((birdy.getPosition().z-birdy.velocity.z*100) / 100)-40);
//                glScaled(0.1, 0.1, 0.1);
//                glPushMatrix();
//                glBegin(GL_QUADS);
//                cube();
//                glEnd();
//
//                glPopMatrix();


            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            glLoadIdentity();
//            glTranslatef(0.0f, 2.0f, -20f);
//            glPushMatrix();
//            glBegin(GL_QUADS);
//            cube();
//            glEnd();//happens first
//
//            glPopMatrix();
//happens first

            //glPopMatrix();


//            }
//            glEnd();



            Display.update();
            Display.sync(60);
        }
    }

    private static void setRotation(Aktor birdy) {
        Vektor3D rotation = new Vektor3D();
        Vektor3D equirotation = new Vektor3D();
        Vektor3D tempone = new Vektor3D(0, 1, 0);
        Vektor3D temptwo = new Vektor3D(birdy.getVelocity());
        try {
            temptwo.mult(0, 1, 1);
            rotation.x = LineareAlgebra.angleDegree(tempone, temptwo);
            tempone.setPosition(0, 0, 1);
            temptwo.setPosition(birdy.getVelocity());
            temptwo.mult(1, 0, 1);
            rotation.y = LineareAlgebra.angleDegree(tempone, temptwo);
            tempone.setPosition(0, 1, 0);
            temptwo.setPosition(birdy.getVelocity());
            temptwo.mult(1, 1, 0);
            rotation.z = LineareAlgebra.angleDegree(tempone, temptwo);

            temptwo.setPosition(birdy.getVelocity());

            equirotation.x = 180 - rotation.x;
            equirotation.y = 180 - rotation.y;
            equirotation.z = 180 - rotation.z;
            if (temptwo.z < 0) {
                rotation.x = 360 - rotation.x;
            }
            if (temptwo.x < 0) {
                rotation.y = 360 - rotation.y;

            }
            if (temptwo.x < 0) {
                rotation.z = 360 -rotation.z;

            }
//            equirotation.x = rotation.x - 360;
//            equirotation.y = rotation.y - 360;
//            equirotation.z = rotation.z - 360;

        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        int i =0;
//        if (Math.abs(birdy.rotation.x - rotation.x) > Math.abs(birdy.rotation.x - equirotation.x)) {
//            i++;
//        }
//        if (Math.abs(birdy.rotation.y - rotation.y) > Math.abs(birdy.rotation.y - equirotation.y)) {
//            i++;
//        }
//        if (Math.abs(birdy.rotation.z - rotation.z) > Math.abs(birdy.rotation.z - equirotation.z)) {
//            i++;
//        }
//
//        if(i>=2){
//            birdy.rotation.setPosition(equirotation);
//        } else {
//            birdy.rotation.setPosition(rotation);
//        }

        birdy.rotation.setPosition(rotation);

        System.out.println("LAAAOOOOK AT MEEEE!!!!! X:" + rotation.x);
        System.out.println("LAAAOOOOK AT MEEEE!!!!! Y:" + rotation.y);
        System.out.println("LAAAOOOOK AT MEEEE!!!!! Z:" + rotation.z);


        birdy.rotation.setPosition(rotation);
    }


    private static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(2000, 2000));
            Display.setTitle("test");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }

    }

    public static Flock initschwarm() {
        Flock schwarm = new Flock();

//        for (int i = 0; i < 2; i++)
//            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1), new Vektor3D((Math.random() * 300), (Math.random() * 300), (Math.random() * 300))));
        for (int i = 0;i<50;i++)
            schwarm.addBird(new Bird(new Vektor3D((Math.random() * 1), (Math.random() * 1), (Math.random() * 1)), new Vektor3D((Math.random() * 1000), (Math.random() * 1000), (Math.random() * 300))));

        return schwarm;


    }

    public static void cube() {

        glColor3f(1.0f, 1.0f, 0.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(1.0f, 1.0f, -1.0f);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(1.0f, 1.0f, 1.0f);
        glColor3f(1.0f, 0.5f, 0.0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(1.0f, -1.0f, -1.0f);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glColor3f(1.0f, 1.0f, 0.0f);
        glVertex3f(1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(1.0f, 1.0f, -1.0f);
        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 1.0f, 1.0f);
        glVertex3f(-1.0f, 1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, -1.0f);
        glVertex3f(-1.0f, -1.0f, 1.0f);
        glColor3f(1.0f, 0.0f, 1.0f);
        glVertex3f(1.0f, 1.0f, -1.0f);
        glVertex3f(1.0f, 1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, 1.0f);
        glVertex3f(1.0f, -1.0f, -1.0f);
    }

    public static void planeModell() {

        glColor3f(1.0f, 1.0f, 0.0f);
        glVertex3f(-3.0f, 0.0f, -1.0f);
        glVertex3f(-3.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 0.0f, -1.0f);
        glColor3f(1.0f, 1.0f, 0.0f);
        glVertex3f(3.0f, 0.0f, -1.0f);
        glVertex3f(3.0f, 0.0f, 1.0f);
        glVertex3f(1.0f, 0.0f, 1.0f);
        glVertex3f(1.0f, 0.0f, -1.0f);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(-1.0f, 0.0f, -1.0f);
        glVertex3f(-1.0f, 0.0f, 1.0f);
        glVertex3f(0.0f, 1.0f, 1.0f);
        glVertex3f(0.0f, 1.0f, -1.0f);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(1.0f, 0.0f, -1.0f);
        glVertex3f(1.0f, 0.0f, 1.0f);
        glVertex3f(0.0f, 1.0f, 1.0f);
        glVertex3f(0.0f, 1.0f, -1.0f);
        glColor3f(1.0f, 0.0f, 1.0f);
        glVertex3f(-1.0f, 0.0f, 1.0f);
        glVertex3f(-0.2f, 0.0f, 2.0f);
        glVertex3f(0.0f, 0.0f, 2.0f);
        glVertex3f(0.0f, 1.0f, 1.0f);
        glColor3f(1.0f, 0.0f, 1.0f);
        glVertex3f(1.0f, 0.0f, 1.0f);
        glVertex3f(0.2f, 0.0f, 2.0f);
        glVertex3f(0.0f, 0.0f, 2.0f);
        glVertex3f(0.0f, 1.0f, 1.0f);
    }
}

