
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // JDBC URL, username, and password of MySQL server
                String url = "jdbc:mysql://localhost:3306/library";
                String mysqluser = "root";
                String mysqlpassword = "172901120103";

                //// Create an instance of the Login panel
                Login login = new Login();

                // Create an instance of the Dashboard panel
                Dashboard dashboard = new Dashboard();

                // Set up an ActionListener for the LoginButton
                login.setLoginActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String pswrd = login.getPassword();
                        String usernm = login.getUsername();

                        try {
                            // Establishing the connection
                            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);
                            Statement statement = connection.createStatement();

                            ResultSet resultSet = statement.executeQuery("select password from Admins where username ='" + usernm + "';");

                            if (resultSet.next()) {
                                String realpswrd = resultSet.getString("password");
                                if (realpswrd.equals(pswrd)) {
                                    // Close the login frame
                                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(login);
                                    loginFrame.dispose();

                                    // Open the Dashboard
                                    JFrame dashboardFrame = new JFrame("Dashboard");
                                    dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    dashboardFrame.getContentPane().add(dashboard);
                                    dashboardFrame.pack();
                                    dashboardFrame.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Username or password incorrect");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Username not found");
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Display the Login panel
                JFrame frame = new JFrame("Library System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(login);
                frame.pack();
                frame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
