package Schwarm;

/**
 * Created by Ezydenias on 5/8/2017.
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.beans.FeatureDescriptor;

public class SchwarmTest {

    public static void main(String[] args) {
        new SchwarmTest();
    }

    public SchwarmTest(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.setTitle("test");
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        while ((!Display.isCloseRequested())){
            Display.update();
            Display.sync(60);
        }

        Display.destroy();
        System.exit(0);
    }
}
