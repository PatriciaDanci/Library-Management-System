import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class HoldD extends JPanel
{
    Commands cmd = new Commands();
    private JLabel holdid;
    private JLabel studentid;
    private JLabel copyid;
    private JLabel holddate;
    private JTextField holdidtf;
    private JTextField studentidtf;
    private JTextField copyidtf;
    private JTextField holddatetf;
    private JButton Hold;

    public HoldD()
    {
        //construct components
        holdid = new JLabel ("hold id");
        studentid = new JLabel ("student id");
        copyid = new JLabel ("copy id");
        holddate = new JLabel ("hold date");
        holdidtf = new JTextField (5);
        studentidtf = new JTextField (5);
        copyidtf = new JTextField (5);
        holddatetf = new JTextField (5);
        Hold = new JButton ("HOLD");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        //adjust size and set layout
        setPreferredSize (new Dimension (450, 500));
        setLayout (null);

        //add components
        add (holdid);
        add (studentid);
        add (copyid);
        add (holddate);
        add (holdidtf);
        add (studentidtf);
        add (copyidtf);
        add (holddatetf);
        add (Hold);

        // set font for labels and button
        holdid.setFont(timesNewRoman);
        studentid.setFont(timesNewRoman);
        copyid.setFont(timesNewRoman);
        holddate.setFont(timesNewRoman);
        Hold.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        holdid.setBounds (60, 50, 100, 25);
        studentid.setBounds (60, 100, 100, 25);
        copyid.setBounds (60, 150, 100, 25);
        holddate.setBounds (60, 200, 100, 25);
        holdidtf.setBounds (260, 50, 100, 25);
        studentidtf.setBounds (260, 100, 100, 25);
        copyidtf.setBounds (260, 150, 100, 25);
        holddatetf.setBounds (260, 200, 100, 25);
        Hold.setBounds (160, 350, 100, 25);

        Hold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String holdId = holdidtf.getText();
                String studentId = studentidtf.getText();
                String copyId = copyidtf.getText();
                String holdDate = holddatetf.getText();

                boolean holdSuccessful = cmd.holdBook(holdId, studentId, copyId, holdDate);

                if (holdSuccessful) {
                    JOptionPane.showMessageDialog(null, " Book placed on hold");
                } else {
                    JOptionPane.showMessageDialog(null, "Error placing the book on hold");
                }
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }
}
