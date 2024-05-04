import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CheckoutD extends JPanel {
    Commands cmd = new Commands();
    private JLabel checkoutid;
    private JLabel studentid;
    private JLabel copyid;
    private JLabel checkoutdate;
    private JLabel returndate;
    private JTextField checkoutidtf;
    private JTextField studentidtf;
    private JTextField copyidtf;
    private JTextField checkoutdatetf;
    private JTextField returndatetf;
    private JButton Checkout;

    public CheckoutD() {
        // construct components
        checkoutid = new JLabel("checkout id");
        studentid = new JLabel("student id");
        copyid = new JLabel("copy id");
        checkoutdate = new JLabel("checkout date");
        returndate = new JLabel("return date");
        checkoutidtf = new JTextField(5);
        studentidtf = new JTextField(5);
        copyidtf = new JTextField(5);
        checkoutdatetf = new JTextField(5);
        returndatetf = new JTextField(5);
        Checkout = new JButton("CHECKOUT");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(636, 336));
        setLayout(null);

        // add components
        add(checkoutid);
        add(studentid);
        add(copyid);
        add(checkoutdate);
        add(returndate);
        add(checkoutidtf);
        add(studentidtf);
        add(copyidtf);
        add(checkoutdatetf);
        add(returndatetf);
        add(Checkout);

        // set font for labels
        checkoutid.setFont(timesNewRoman);
        studentid.setFont(timesNewRoman);
        copyid.setFont(timesNewRoman);
        checkoutdate.setFont(timesNewRoman);
        returndate.setFont(timesNewRoman);

        // set font for text fields
        checkoutidtf.setFont(timesNewRoman);
        studentidtf.setFont(timesNewRoman);
        copyidtf.setFont(timesNewRoman);
        checkoutdatetf.setFont(timesNewRoman);
        returndatetf.setFont(timesNewRoman);

        // set font for button
        Checkout.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        checkoutid.setBounds(60, 50, 100, 25);
        studentid.setBounds(60, 100, 100, 25);
        copyid.setBounds(60, 150, 100, 25);
        checkoutdate.setBounds(60, 200, 100, 25);
        returndate.setBounds(60, 250, 100, 25);
        checkoutidtf.setBounds(260, 50, 100, 25);
        studentidtf.setBounds(260, 100, 100, 25);
        copyidtf.setBounds(260, 150, 100, 25);
        checkoutdatetf.setBounds(260, 200, 100, 25);
        returndatetf.setBounds(260, 250, 100, 25);
        Checkout.setBounds(450, 150, 100, 25);

        Checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from text fields
                String checkoutId = getCheckoutId();
                String studentId = getStudentId();
                String copyId = getCopyId();
                String checkoutDate = getCheckoutDate();
                String returnDate = getReturnDate();

                // Perform checkout operation
                boolean checkoutSuccessful = cmd.checkoutBook(checkoutId, studentId, copyId, checkoutDate, returnDate);

                if (checkoutSuccessful) {
                    JOptionPane.showMessageDialog(null, "Checkout done.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error.");
                }
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }

    public JButton getCheckoutButton() {
        return Checkout;
    }

    public String getCheckoutId() {
        return checkoutidtf.getText();
    }

    public String getStudentId() {
        return studentidtf.getText();
    }

    public String getCopyId() {
        return copyidtf.getText();
    }

    public String getCheckoutDate() {
        return checkoutdatetf.getText();
    }

    public String getReturnDate() {
        return returndatetf.getText();
    }
}
