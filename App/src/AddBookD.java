import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddBookD extends JPanel {
    Commands cmd = new Commands();
    private JLabel bookid;
    private JLabel title;
    private JLabel isbn;
    private JLabel avcopies;
    private JLabel totcopies;
    private JLabel publisherid;
    private JLabel categoryid;
    private JTextField idtf;
    private JTextField titletf;
    private JTextField isbntf;
    private JTextField avcopiestf;
    private JTextField totcopiestf;
    private JTextField publisheridtf;
    private JTextField categoryidtf;
    private JButton AddButton;

    public AddBookD() {
        // construct components
        bookid = new JLabel("id");
        title = new JLabel("title");
        isbn = new JLabel("ISBN");
        avcopies = new JLabel("available copies");
        totcopies = new JLabel("total copies");
        publisherid = new JLabel("publisher id");
        categoryid = new JLabel("category id");
        idtf = new JTextField(5);
        titletf = new JTextField(5);
        isbntf = new JTextField(5);
        avcopiestf = new JTextField(5);
        totcopiestf = new JTextField(5);
        publisheridtf = new JTextField(5);
        categoryidtf = new JTextField(5);
        AddButton = new JButton("ADD");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(409, 557));
        setLayout(null);

        // add components
        add(bookid);
        add(title);
        add(isbn);
        add(avcopies);
        add(totcopies);
        add(publisherid);
        add(categoryid);
        add(idtf);
        add(titletf);
        add(isbntf);
        add(avcopiestf);
        add(totcopiestf);
        add(publisheridtf);
        add(categoryidtf);
        add(AddButton);

        // set font for labels
        bookid.setFont(timesNewRoman);
        title.setFont(timesNewRoman);
        isbn.setFont(timesNewRoman);
        avcopies.setFont(timesNewRoman);
        totcopies.setFont(timesNewRoman);
        publisherid.setFont(timesNewRoman);
        categoryid.setFont(timesNewRoman);

        // set font for text fields
        idtf.setFont(timesNewRoman);
        titletf.setFont(timesNewRoman);
        isbntf.setFont(timesNewRoman);
        avcopiestf.setFont(timesNewRoman);
        totcopiestf.setFont(timesNewRoman);
        publisheridtf.setFont(timesNewRoman);
        categoryidtf.setFont(timesNewRoman);

        // set font for button
        AddButton.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        bookid.setBounds(60, 50, 100, 25);
        title.setBounds(60, 100, 100, 25);
        isbn.setBounds(60, 150, 100, 25);
        avcopies.setBounds(60, 200, 100, 25);
        totcopies.setBounds(60, 250, 100, 25);
        publisherid.setBounds(60, 300, 100, 25);
        categoryid.setBounds(60, 350, 100, 25);
        idtf.setBounds(220, 50, 100, 25);
        titletf.setBounds(220, 100, 100, 25);
        isbntf.setBounds(220, 150, 100, 25);
        avcopiestf.setBounds(220, 200, 100, 25);
        totcopiestf.setBounds(220, 250, 100, 25);
        publisheridtf.setBounds(220, 300, 100, 25);
        categoryidtf.setBounds(220, 350, 100, 25);
        AddButton.setBounds(150, 500, 100, 25);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idtf.getText();
                String title = titletf.getText();
                String isbn = isbntf.getText();
                String avCopies = avcopiestf.getText();
                String totCopies = totcopiestf.getText();
                String publisherId = publisheridtf.getText();
                String categoryId = categoryidtf.getText();

                cmd.addBook(id, title, isbn, avCopies, totCopies, publisherId, categoryId);
            }
        });
        setBackground(Color.decode("#ADD8E6"));
    }
}
