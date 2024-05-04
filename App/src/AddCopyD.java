import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddCopyD extends JPanel {
    Commands cmd = new Commands();
    private JLabel copyid;
    private JLabel bookid;
    private JLabel status;
    private JTextField copyidtf;
    private JTextField bookidtf;
    private JTextField statustf;
    private JButton AddButton;

    public AddCopyD() {
        // construct components
        copyid = new JLabel("copy id");
        bookid = new JLabel("book id");
        status = new JLabel("status");
        copyidtf = new JTextField(5);
        bookidtf = new JTextField(5);
        statustf = new JTextField(5);
        AddButton = new JButton("ADD");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(398, 560));
        setLayout(null);

        // add components
        add(copyid);
        add(bookid);
        add(status);
        add(copyidtf);
        add(bookidtf);
        add(statustf);
        add(AddButton);

        // set font for labels
        copyid.setFont(timesNewRoman);
        bookid.setFont(timesNewRoman);
        status.setFont(timesNewRoman);

        // set font for text fields
        copyidtf.setFont(timesNewRoman);
        bookidtf.setFont(timesNewRoman);
        statustf.setFont(timesNewRoman);

        // set font for button
        AddButton.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        copyid.setBounds(50, 100, 100, 25);
        bookid.setBounds(50, 200, 100, 25);
        status.setBounds(50, 300, 100, 25);
        copyidtf.setBounds(250, 100, 100, 25);
        bookidtf.setBounds(250, 200, 100, 25);
        statustf.setBounds(250, 300, 100, 25);
        AddButton.setBounds(140, 450, 100, 25);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String copyId = copyidtf.getText();
                String bookId = bookidtf.getText();
                String status = statustf.getText();

                cmd.addCopy(copyId, bookId, status);
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }
}
