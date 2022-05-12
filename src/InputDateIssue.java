import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpringLayout;

public class InputDateIssue {



    static JFrame getFrameDateIssue() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 250, 300);
        JPanel jPanel = getPanelDateIssue();

        jFrame.add(jPanel);






        return jFrame;
    }

    static  JPanel getPanelDateIssue() {

       DbConnection.setStrIssues(DbConnection.getData("SELECT nameissues FROM adddep.issues", "nameissues" ));

        String[] issues  = DbConnection.getStrIssues();



        JTextField textMonthInput = new JTextField(5);
        JLabel jLabelMonth = new JLabel("Введіть місяць");
        JTextField textYearInput= new JTextField(5);
        JLabel jLabelYear = new JLabel("Введіть рік");


        JPanel jPanelDateIssue  = new JPanel();
        SpringLayout layout = new SpringLayout();
        jPanelDateIssue.setLayout(layout);

        JLabel jLabelIssues = new JLabel("Оберіть медіа");
        JList jListMedia = new JList(issues);


        jPanelDateIssue.add(jLabelMonth);
        jPanelDateIssue.add(textMonthInput);
        jPanelDateIssue.add(jLabelYear);
        jPanelDateIssue.add(textYearInput);
        jPanelDateIssue.add(jLabelIssues);
        jPanelDateIssue.add(jListMedia);


        layout.putConstraint(SpringLayout.WEST, jLabelMonth, 10, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, jLabelMonth, 10, SpringLayout.NORTH, jPanelDateIssue);
        layout.putConstraint(SpringLayout.WEST, textMonthInput, 120, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, textMonthInput, 10, SpringLayout.NORTH, jPanelDateIssue);

        layout.putConstraint(SpringLayout.WEST, jLabelYear, 10, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, jLabelYear, 10, SpringLayout.SOUTH, jLabelMonth);
        layout.putConstraint(SpringLayout.WEST, textYearInput, 120, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, textYearInput, 10, SpringLayout.SOUTH, textMonthInput);

        layout.putConstraint(SpringLayout.WEST, jLabelIssues, 10, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, jLabelIssues, 10, SpringLayout.SOUTH, textYearInput);
        layout.putConstraint(SpringLayout.WEST, jListMedia, 10, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, jListMedia, 10, SpringLayout.SOUTH, jLabelIssues);




        JButton jButtonDateIssueOk = new JButton("Ввести дані");
        jPanelDateIssue.add(jButtonDateIssueOk);

        jButtonDateIssueOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaidAdv paidAdv = new PaidAdv();
                paidAdv.setTextMonth(textMonthInput);
                paidAdv.setTextYear(textYearInput);



                JFrame jFramePaidAdv = PaidAdv.getFramePaidAdv();




                jFramePaidAdv.revalidate();
            }
        });

        layout.putConstraint(SpringLayout.WEST, jButtonDateIssueOk, 10, SpringLayout.WEST, jPanelDateIssue);
        layout.putConstraint(SpringLayout.NORTH, jButtonDateIssueOk, 10, SpringLayout.SOUTH, jListMedia);











        return jPanelDateIssue;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
