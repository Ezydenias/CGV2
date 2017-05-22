package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Ezydenias on 5/22/2017.
 */
public class DisplayManager {

    private static final int WIDTH = 2000;
    private static final int HEIGHT = 2000;
    private static final int FPS_CAP=120;

    public static void createDisplay(){

        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("FlyingFuck");
            Display.create(new PixelFormat(),attribs);
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }

        GL11.glViewport(0,0, WIDTH,HEIGHT);

    }

    public static void updateDisplay(){
        Display.sync(120);
        Display.update();
    }

    public static void closeDisplay(){
        Display.destroy();
    }

}
