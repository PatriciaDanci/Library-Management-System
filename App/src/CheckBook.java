import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CheckBook extends JPanel {
    Commands cmd = new Commands();
    private JLabel title;
    private JTextField booktitle;
    private JButton CheckButton;

    public CheckBook() {
        // construct components
        title = new JLabel("            Title");
        booktitle = new JTextField(5);
        CheckButton = new JButton("CHECK");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(500, 550));
        setLayout(null);

        // add components
        add(title);
        add(booktitle);
        add(CheckButton);

        // set font for label
        title.setFont(timesNewRoman);

        // set font for text field
        booktitle.setFont(timesNewRoman);

        // set font for button
        CheckButton.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        title.setBounds(200, 100, 100, 25);
        booktitle.setBounds(100, 200, 300, 25);
        CheckButton.setBounds(200, 300, 100, 25);

        CheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = booktitle.getText();
                boolean available = cmd.checkAvailableBooks(bookTitle);

                if (!available) {
                    // If available, show another window or perform further actions
                    JOptionPane.showMessageDialog(null, "No available copies for the specified book.");
                }
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }

    public JButton getCheckButton() {
        return CheckButton;
    }

    public String getBookTitle() {
        return booktitle.getText();
    }
}
