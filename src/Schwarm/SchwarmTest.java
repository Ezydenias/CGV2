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
                45.0f,
                (float) Display.getWidth() / (float) Display.getHeight(),
                0.1f,
                100.0f);

        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);


//        glShadeModel(GL_SMOOTH);
//        glClearDepth(1.0);
//        glEnable(GL_DEPTH_TEST);
//        glEnable(GL_DEPTH_TEST);
//        glDepthFunc(GL_LEQUAL);
//        glLoadIdentity();
//        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
//
//        glFrustum(-1, 1, -1, 1, 3, 100);
//
//        glMatrixMode(GL_PROJECTION);
//       // glLoadIdentity(); // Resets any previous projection matrices
//        glOrtho(0, 1280, 1024, 0, 100, -100);
//        //glViewport(0,0,1280,1024);
//        glMatrixMode(GL_MODELVIEW);
//        glClearColor(0, 0, 256, 0);
//        //glDisable(GL_DEPTH_TEST);
//        //glDisable(GL_TEXTURE_2D );
    }

    private static void gameloop(Flock schwarm) {
        glTranslatef(0f, 0.0f, -20f);

        //glScalef(4, 4, 4);
        while (!Display.isCloseRequested()) {
            //glDrawBuffer(0);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            //glLoadIdentity();
            //glTranslatef(0f,0.0f,-0.7f);
//            glRotatef(0.5f, 20.0f, 20.0f, 20.0f);
//            glColor3f(0.5f, 0.5f, 1.0f);
//            glBegin(GL_QUADS);
//            {

            schwarm.run();
            for (Aktor birdy : schwarm.Aktor) {
                glLoadIdentity();
                setRotation(birdy);


                glTranslated((birdy.getPosition().x) / 100, (birdy.getPosition().y) / 100, (((birdy.getPosition().y) / 100) - 20));
                glScaled(0.25, 0.25, 0.25);
                glRotated(birdy.rotation.x, 1.0, 0.0, 0.0);
                glRotated(birdy.rotation.y, 0.0, 1.0, 0.0);
                glRotated(birdy.rotation.z, 0.0, 0.0, 1.0);
                glPushMatrix();
                glBegin(GL_QUADS);
                cube();
                glEnd();

                glPopMatrix();


            }

            try {
                Thread.sleep(50);
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

            glPopMatrix();


//            }
//            glEnd();

            Display.update();
            Display.sync(60);
        }
    }

    private static void setRotation(Aktor birdy) {
        Vektor3D rotation = new Vektor3D();
        Vektor3D equirotation = new Vektor3D();
        Vektor3D tempone = new Vektor3D(0, 1, 1);
        Vektor3D temptwo = new Vektor3D(birdy.getVelocity());
        try {
            temptwo.mult(0, 1, 1);
            rotation.x = LineareAlgebra.angleDegree(tempone, temptwo);
            tempone.setPosition(1, 0, 1);
            temptwo.setPosition(birdy.getVelocity());
            temptwo.mult(1, 0, 1);
            rotation.y = LineareAlgebra.angleDegree(tempone, temptwo);
            tempone.setPosition(1, 1, 0);
            temptwo.setPosition(birdy.getVelocity());
            temptwo.mult(1, 1, 0);
            rotation.z = LineareAlgebra.angleDegree(tempone, temptwo);

            temptwo.setPosition(birdy.getVelocity());
            if (temptwo.x < 0) {
                rotation.x *= -1;
                equirotation.x = -180 - rotation.x;
            } else {
                equirotation.x = 180 - rotation.x;
            }
            if (temptwo.y < 0) {
                rotation.y *= -1;
                equirotation.y = -180 - rotation.y;
            } else {
                equirotation.y = 180 - rotation.y;
            }
            if (temptwo.z < 0) {
                rotation.z *= -1;
                equirotation.z = -180 - rotation.z;
            } else {
                equirotation.z = 180 - rotation.z;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Math.abs(birdy.rotation.x - rotation.x) > Math.abs(birdy.rotation.x - equirotation.x)) {
            rotation.x = equirotation.x;
        }
        if (Math.abs(birdy.rotation.y - rotation.y) > Math.abs(birdy.rotation.y - equirotation.y)) {
            rotation.y = equirotation.y;
        }
        if (Math.abs(birdy.rotation.z - rotation.z) > Math.abs(birdy.rotation.z - equirotation.z)) {
            rotation.z = equirotation.z;
        }

        System.out.println("LAAAOOOOK AT MEEEE!!!!! X:" + rotation.x);
        System.out.println("LAAAOOOOK AT MEEEE!!!!! Y:" + rotation.y);
        System.out.println("LAAAOOOOK AT MEEEE!!!!! Z:" + rotation.z);


        birdy.rotation.setPosition(rotation);
    }


    private static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(1000, 1000));
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

        for (int i = 0; i < 5; i++)
            schwarm.addBird(new Plane(new Vektor3D(1, 1, 1), new Vektor3D((Math.random() * 300), (Math.random() * 300), (Math.random() * 300))));

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
}

