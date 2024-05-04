import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReturnD extends JPanel {

    Commands cmd = new Commands();
    private JLabel checkoutid;
    private JTextField checkoutidtf;
    private JButton Return;
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String mysqluser = "root";
    private static final String mysqlpassword = "172901120103";

    public ReturnD() {
        // construct components
        checkoutid = new JLabel("checkout id");
        checkoutidtf = new JTextField(5);
        Return = new JButton("RETURN");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(404, 441));
        setLayout(null);

        // add components
        add(checkoutid);
        add(checkoutidtf);
        add(Return);

        // set font for labels and button
        checkoutid.setFont(timesNewRoman);
        Return.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        checkoutid.setBounds(155, 60, 100, 25);
        checkoutidtf.setBounds(140, 160, 100, 25);
        Return.setBounds(140, 300, 100, 25);

        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from text field
                String checkoutId = checkoutidtf.getText();

                // Establish the connection
                try (Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword)) {
                    // Check if the book is on hold
                    if (cmd.isBookOnHold(connection, checkoutId)) {
                        // Book is on hold, perform necessary actions
                        boolean returnSuccessful = cmd.returnBook(checkoutId);
                        int holdingStudentId = cmd.getHoldingStudentId(checkoutId);
                        JOptionPane.showMessageDialog(null, "Book is on hold by Student with ID: " + holdingStudentId);
                        cmd.decrementHoldStatus(checkoutId);
                    } else {
                        // Book is not on hold, continue with the return process
                        boolean returnSuccessful = cmd.returnBook(checkoutId);

                        if (returnSuccessful) {
                            JOptionPane.showMessageDialog(null, "Book returned successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error returning book.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error connecting to the database.");
                }
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }

}
