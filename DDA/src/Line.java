
import java.io.File;
import java.util.Scanner;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Line implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile

        Line l = new Line();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);

        final JFrame frame = new JFrame("straight Line");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL2.GL_POINTS);//static field

        try {
            Scanner sc = new Scanner(new File("input.txt"));

            while (sc.hasNext()) {
                Double x1 = Double.parseDouble(sc.next());
                Double y1 = Double.parseDouble(sc.next());
                Double x2 = Double.parseDouble(sc.next());
                Double y2 = Double.parseDouble(sc.next());
                double m = (y2 - y1) / (x2 - x1);
                if (-1 < m && m <= 1) {
                    while (x1 < x2) {
                        x1 = x1 + .00001;
                        y1 = y1 + m * .00001;

                        gl.glVertex2d(x1, y1);
                    }
                } else {

                    while (y1 < y2) {
                        y1 = y1 + .00001;
                        x1 = x1 + (.00001 / m);
                        gl.glVertex2d(x1, y1);

                    }
                }
            }
//            gl.glColor3f(0f, 1f, 0f);
//            gl.glVertex3f(x1, y1, 1);
//            gl.glVertex3f(x2, y2, 1);
//            gl.glEnd();
        } catch (Exception E) {
            System.err.println(E);
        }

        gl.glEnd();

    }

    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    public void init(GLAutoDrawable drawable) {
        // method body
        //4. drive the display() in a loop
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
    //end of main
}//end of classimport javax.media.opengl.GL2;
