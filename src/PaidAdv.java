import javax.swing.*;
import java.awt.*;
import javax.swing.SpringLayout;
import java.sql.*;


public class PaidAdv {
    public   JPanel jPanelPaidAdv;
    public  JFrame jFramePaidAdv;

    static JTextField textYear= new JTextField("0", 5);
    static JTextField textMonth= new JTextField("0", 5);

    public  JTextField getTextYear() { return textYear; }

    public  void setTextYear(JTextField textYear) { PaidAdv.textYear = textYear; }

    public  JTextField getTextMonth() { return textMonth;   }

    public  void setTextMonth(JTextField textMonth) { PaidAdv.textMonth = textMonth;   }

    public static JFrame getFramePaidAdv() {
        PaidAdv paidAdv = new PaidAdv();
        paidAdv.jFramePaidAdv = new JFrame();
        paidAdv.jFramePaidAdv.setVisible(true);
        paidAdv.jFramePaidAdv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        paidAdv.jFramePaidAdv.setBounds(dimension.width/2 - 250, dimension.height/2 - 150, 500, 400);
        paidAdv.jPanelPaidAdv= getPanelPaidDdv();

        paidAdv.jFramePaidAdv.add(paidAdv.jPanelPaidAdv);






        return paidAdv.jFramePaidAdv;
    }

    static  JPanel getPanelPaidDdv() {

        DbConnection.setStrNamestat(DbConnection.getData("SELECT namestat FROM adddep.stat", "namestat" ));
        DbConnection.setStrIssues(DbConnection.getData("SELECT nameissues FROM adddep.issues", "nameissues" ));


        String[] workers  =DbConnection.getStrnamestat();

        String[] media  = DbConnection.getStrIssues();



        JLabel jLabelWorker = new JLabel("Працівники");
        JList jListWorker = new JList(workers);
        jListWorker.setSelectedIndex(2);

        JLabel jLabelMedia = new JLabel("Медіа");
        JList jListMedia = new JList(media);
        jListMedia.setSelectedIndex(2);



        JLabel jLabelMonth = new JLabel("Місяць");


        JLabel jLabelYear = new JLabel("Рік");



        JTextArea firmName = new JTextArea(5, 12);
        firmName.setFont(new Font("Dialog", Font.PLAIN, 14));
        firmName.setTabSize(10);

        firmName.setLineWrap(true);
        firmName.setWrapStyleWord(true);

        JPanel jPanelPaidAdv  = new JPanel();

        SpringLayout layout = new SpringLayout();
        jPanelPaidAdv.setLayout(layout);

        jPanelPaidAdv.add(jLabelMedia);
        jPanelPaidAdv.add(jListMedia);
        jPanelPaidAdv.add(jLabelWorker);
        jPanelPaidAdv.add(jListWorker);
        JScrollPane jScrollPaneFirm = new JScrollPane(firmName);
        jPanelPaidAdv.add(jScrollPaneFirm);


        jPanelPaidAdv.add(jLabelMonth);
        jPanelPaidAdv.add(textMonth);
        jPanelPaidAdv.add(jLabelYear);
        jPanelPaidAdv.add(textYear);


        layout.putConstraint(SpringLayout.WEST, jLabelWorker, 10, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jLabelWorker, 10, SpringLayout.NORTH, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.WEST, jListWorker, 10, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jListWorker, 10, SpringLayout.SOUTH, jLabelWorker);

        layout.putConstraint(SpringLayout.WEST, jLabelMedia, 10, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jLabelWorker, 10, SpringLayout.NORTH, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.WEST, jListWorker, 10, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jListWorker, 10, SpringLayout.SOUTH, jLabelWorker);

        layout.putConstraint(SpringLayout.WEST, jLabelMonth, 140, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jLabelMonth, 10, SpringLayout.NORTH, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.WEST, textMonth, 200, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, textMonth, 10, SpringLayout.NORTH, jPanelPaidAdv);

        layout.putConstraint(SpringLayout.WEST, jLabelYear, 140, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jLabelYear, 10, SpringLayout.SOUTH, jLabelMonth);
        layout.putConstraint(SpringLayout.WEST, textYear, 200, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, textYear, 10, SpringLayout.SOUTH, textMonth);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneFirm, 140, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneFirm, 50, SpringLayout.SOUTH, jLabelYear);


        layout.putConstraint(SpringLayout.WEST, jLabelMedia, 300, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jLabelMedia, 10, SpringLayout.NORTH, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.WEST, jListMedia, 300, SpringLayout.WEST, jPanelPaidAdv);
        layout.putConstraint(SpringLayout.NORTH, jListMedia, 10, SpringLayout.SOUTH, jLabelMedia);


        return jPanelPaidAdv;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
