import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Welcome {



    static JFrame getFrameWelcome() {
        JFrame jFrame = new JFrame();

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 300);
        JMenuBar jMenuWelcome = new JMenuBar();
        JMenu jMenuInput = new JMenu("Введення даних");


        jMenuInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame jFrameDateIssue = InputDateIssue.getFrameDateIssue();
                jFrameDateIssue.revalidate();
            }
        });


        JMenu jMenuBase = new JMenu("База даних");
        jMenuWelcome.add(jMenuInput);
        jMenuWelcome.add(jMenuBase);
        jFrame.setJMenuBar(jMenuWelcome);

        return jFrame;
    }

    static  JPanel getPanel() {
        JPanel jPanelWelcome  = new JPanel();

        return jPanelWelcome;
    }

}
