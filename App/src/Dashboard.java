import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Dashboard extends JPanel {
    Commands cmd = new Commands();
    private JButton AddBook;
    private JButton AddCopy;
    private JButton Checkout;
    private JButton Return;
    private JButton Hold;
    private JButton Data;

    public Dashboard() {
        // construct components
        AddBook = new JButton("ADD BOOK");
        AddCopy = new JButton("ADD COPY");
        Checkout = new JButton("CHECKOUT");
        Return = new JButton("RETURN");
        Hold = new JButton("HOLD");
        Data = new JButton("SHOW DATA");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(300, 650));
        setLayout(null);

        // add components
        add(AddBook);
        add(AddCopy);
        add(Checkout);
        add(Return);
        add(Hold);
        add(Data);

        // set font for buttons
        AddBook.setFont(timesNewRoman);
        AddCopy.setFont(timesNewRoman);
        Checkout.setFont(timesNewRoman);
        Return.setFont(timesNewRoman);
        Hold.setFont(timesNewRoman);
        Data.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        AddBook.setBounds(75, 100, 150, 25);
        AddCopy.setBounds(75, 135, 150, 25);
        Checkout.setBounds(75, 250, 150, 25);
        Return.setBounds(100, 350, 100, 25);
        Hold.setBounds(100, 450, 100, 25);
        Data.setBounds(75, 550, 150, 25);

        AddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the AddBookD panel
                JFrame frame = new JFrame("Add Book");
                AddBookD addBookPanel = new AddBookD();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(addBookPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });

        AddCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the AddCopyD panel
                JFrame frame = new JFrame("Add Copy");
                AddCopyD addCopyPanel = new AddCopyD();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(addCopyPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });

        Checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the CheckBook panel
                JFrame checkBookFrame = new JFrame("Check Book");
                CheckBook checkBookPanel = new CheckBook();
                checkBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                checkBookFrame.getContentPane().add(checkBookPanel);
                checkBookFrame.pack();
                checkBookFrame.setVisible(true);

                // Get the CheckBook button and add ActionListener
                JButton checkButton = checkBookPanel.getCheckButton();
                checkButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Check if the book is available
                        String bookTitle = checkBookPanel.getBookTitle();
                        boolean available = cmd.checkAvailableBooks(bookTitle);

                        if (available) {
                            // Display the CheckoutD panel
                            JFrame checkoutFrame = new JFrame("Checkout Book");
                            CheckoutD checkoutPanel = new CheckoutD();
                            checkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            checkoutFrame.getContentPane().add(checkoutPanel);
                            checkoutFrame.pack();
                            checkoutFrame.setVisible(true);
                        } else {
                            // If not available, display a message
                            JOptionPane.showMessageDialog(null, "No available copies for the specified book.");
                        }
                    }
                });
            }
        });

        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the ReturnD panel
                JFrame returnFrame = new JFrame("Return Book");
                ReturnD returnPanel = new ReturnD();
                returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                returnFrame.getContentPane().add(returnPanel);
                returnFrame.pack();
                returnFrame.setVisible(true);
            }
        });

        Hold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the ReturnD panel
                JFrame returnFrame = new JFrame("Hold Book");
                HoldD returnPanel = new HoldD();
                returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                returnFrame.getContentPane().add(returnPanel);
                returnFrame.pack();
                returnFrame.setVisible(true);
            }
        });

        Data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the ReturnD panel
                JFrame returnFrame = new JFrame("View Data");
                DataD returnPanel = new DataD();
                returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                returnFrame.getContentPane().add(returnPanel);
                returnFrame.pack();
                returnFrame.setVisible(true);
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }
}
