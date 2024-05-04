import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {

    private JLabel Username;
    private JLabel Password;
    private JTextField username;
    private JPasswordField password;
    private JButton LoginButton;

    private ActionListener loginActionListener;

    public Login() {
        // construct components
        Username = new JLabel("USERNAME");
        Password = new JLabel("PASSWORD");
        username = new JTextField(5);
        password = new JPasswordField(5);
        LoginButton = new JButton("Login");

        // adjust size and set layout
        setPreferredSize(new Dimension(643, 385));
        setLayout(null);

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // add components
        add(Username);
        add(Password);
        add(username);
        add(password);
        add(LoginButton);

        // set font for labels
        Username.setFont(timesNewRoman);
        Password.setFont(timesNewRoman);

        // set font for text fields
        username.setFont(timesNewRoman);
        password.setFont(timesNewRoman);

        // set font for button
        LoginButton.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        Username.setBounds(100, 100, 100, 25);
        Password.setBounds(100, 200, 100, 25);
        username.setBounds(300, 100, 100, 25);
        password.setBounds(300, 200, 100, 25);
        LoginButton.setBounds(300, 300, 100, 25);

        // add ActionListener to the LoginButton
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginActionListener != null) {
                    loginActionListener.actionPerformed(e);
                }
            }
        });

        // set background color using HTML
        setBackground(Color.decode("#ADD8E6")); // Light Blue color
    }

    // Getter methods for username, password, and LoginButton
    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public JButton getLoginButton() {
        return LoginButton;
    }

    // Setter method for loginActionListener
    public void setLoginActionListener(ActionListener loginActionListener) {
        this.loginActionListener = loginActionListener;
    }
}
