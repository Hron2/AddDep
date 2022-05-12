import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class AddMain {

    static JFrame jFrameWelcome = Welcome.getFrameWelcome();
    static JPanel jPanelWelcome = new JPanel();



    public static void main(String[] args) throws Exception {
        jFrameWelcome.revalidate();

        jFrameWelcome.add(jPanelWelcome);

    }
}
