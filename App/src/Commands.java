
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class Commands {

    // JDBC URL, username, and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String mysqluser = "root";
    private static final String mysqlpassword = "172901120103";

    public static void addBook(String id, String title, String isbn, String avCopies, String totCopies,
                               String publisherId, String categoryId) {
        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // SQL query to insert a new book
            String insertQuery = "INSERT INTO Books (book_id, title, isbn, available_copies, total_copies, publisher_id, category_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, isbn);
                preparedStatement.setString(4, avCopies);
                preparedStatement.setString(5, totCopies);
                preparedStatement.setString(6, publisherId);
                preparedStatement.setString(7, categoryId);

                // Execute the query
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Book added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding book");
        }
    }

    public static void addCopy(String copyId, String bookId, String status) {
        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // SQL query to insert a new book copy
            String insertQuery = "INSERT INTO Bookcopy (copy_id, book_id, status) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, copyId);
                preparedStatement.setString(2, bookId);
                preparedStatement.setString(3, status);

                // Execute the query
                preparedStatement.executeUpdate();

                // Increment available_copies and total_copies in the books table
                String updateQuery = "UPDATE books SET available_copies = available_copies + 1, total_copies = total_copies + 1 WHERE book_id = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setString(1, bookId);
                    updateStatement.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Copy added successfully, and book details updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding copy");
        }
    }

    private static boolean isBookCopyAvailable(Connection connection, String copyId) throws SQLException {
        // Check if the book copy is available
        String availabilityQuery = "SELECT status FROM Bookcopy WHERE copy_id = ?";
        try (PreparedStatement availabilityStatement = connection.prepareStatement(availabilityQuery)) {
            availabilityStatement.setString(1, copyId);
            ResultSet availabilityResultSet = availabilityStatement.executeQuery();

            if (availabilityResultSet.next()) {
                String status = availabilityResultSet.getString("status");
                return "available".equalsIgnoreCase(status);
            }
        }
        return false;
    }

    private static void updateBookCopyStatus(Connection connection, String copyId) throws SQLException {
        // Update the status in the Bookcopy table
        String updateStatusQuery = "UPDATE Bookcopy SET status = 'Not Available' WHERE copy_id = ?";
        try (PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery)) {
            updateStatusStatement.setString(1, copyId);
            updateStatusStatement.executeUpdate();
        }
    }

    private static void updateAvailableCopies(Connection connection, String copyId) throws SQLException {
        // Decrement available_copies in the Books table
        String decrementCopiesQuery = "UPDATE Books SET available_copies = available_copies - 1 WHERE book_id IN " +
                "(SELECT book_id FROM Bookcopy WHERE copy_id = ?)";
        try (PreparedStatement decrementCopiesStatement = connection.prepareStatement(decrementCopiesQuery)) {
            decrementCopiesStatement.setString(1, copyId);
            decrementCopiesStatement.executeUpdate();
        }
    }
    public static boolean checkAvailableBooks(String title) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Get book ID based on the title
            String bookIdQuery = "SELECT book_id FROM Books WHERE title = ?";
            String bookId;

            try (PreparedStatement bookIdStatement = connection.prepareStatement(bookIdQuery)) {
                bookIdStatement.setString(1, title);
                ResultSet bookIdResultSet = bookIdStatement.executeQuery();

                if (bookIdResultSet.next()) {
                    bookId = bookIdResultSet.getString("book_id");
                } else {
                    // If book not found, display a message
                    JOptionPane.showMessageDialog(null, "Book not found.");
                    return false;
                }
            }

            // SQL query to check for available copies
            String selectQuery = "SELECT copy_id FROM Bookcopy WHERE book_id = ? AND status = 'available'";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, bookId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                List<String> availableCopyIds = new ArrayList<>();

                while (resultSet.next()) {
                    String copyId = resultSet.getString("copy_id");
                    availableCopyIds.add("Copy_ID " + copyId);
                }

                // Display the available copy IDs
                if (!availableCopyIds.isEmpty()) {
                    String message = String.join("\n", availableCopyIds);
                    JOptionPane.showMessageDialog(null, message);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No available copies for the specified book.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkoutBook(String checkoutId, String studentId, String copyId,
                                       String checkoutDate, String returnDate) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Check if the book copy is available
            if (isBookCopyAvailable(connection, copyId)) {

                // Update the Bookcopy table
                updateBookCopyStatus(connection, copyId);

                // Update the available_copies in the Books table
                updateAvailableCopies(connection, copyId);

                // Insert the checkout record
                String query = "INSERT INTO Checkout (checkout_id, student_id, copy_id, checkout_date, return_date) " +
                        "VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, checkoutId);
                    preparedStatement.setString(2, studentId);
                    preparedStatement.setString(3, copyId);
                    preparedStatement.setString(4, checkoutDate);
                    preparedStatement.setString(5, returnDate);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Book checked out successfully");
                        return true; // Successful checkout
                    } else {
                        JOptionPane.showMessageDialog(null, "Error checking out book");
                        return false; // Error in checkout
                    }
                }
            } else {
                // If the book copy is not available, display a message
                JOptionPane.showMessageDialog(null, "The selected book copy is not available for checkout.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error checking out book");
            return false; // Error in checkout
        }
    }

    public static boolean returnBook(String checkoutId) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Get information about the checkout record
            String selectQuery = "SELECT * FROM Checkout WHERE checkout_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, checkoutId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String copyId = resultSet.getString("copy_id");

                    // Update the Bookcopy table
                    String updateStatusQuery = "UPDATE Bookcopy SET status = 'Available' WHERE copy_id = ?";
                    try (PreparedStatement updateStatusStatement = connection.prepareStatement(updateStatusQuery)) {
                        updateStatusStatement.setString(1, copyId);
                        updateStatusStatement.executeUpdate();
                    }

                    // Update the available_copies in the Books table
                    String incrementCopiesQuery = "UPDATE Books SET available_copies = available_copies + 1 WHERE book_id IN " +
                            "(SELECT book_id FROM Bookcopy WHERE copy_id = ?)";
                    try (PreparedStatement incrementCopiesStatement = connection.prepareStatement(incrementCopiesQuery)) {
                        incrementCopiesStatement.setString(1, copyId);
                        incrementCopiesStatement.executeUpdate();
                    }

                    // Delete the checkout record
                    /*
                    String deleteCheckoutQuery = "DELETE FROM Checkout WHERE checkout_id = ?";
                    try (PreparedStatement deleteCheckoutStatement = connection.prepareStatement(deleteCheckoutQuery)) {
                        deleteCheckoutStatement.setString(1, checkoutId);
                        deleteCheckoutStatement.executeUpdate();
                    }*/

                    return true; // Successful return
                } else {
                    // If checkout record not found, display a message
                    JOptionPane.showMessageDialog(null, "Checkout record not found.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error returning book.");
            return false; // Error in return
        }
    }

    public static boolean isBookOnHold(Connection connection, String checkoutId) throws SQLException {
        // Check if the book copy related to the given checkoutId is on hold
        String onHoldQuery = "SELECT * FROM Hold WHERE copy_id = " +
                "(SELECT copy_id FROM Checkout WHERE checkout_id = ?)";
        try (PreparedStatement onHoldStatement = connection.prepareStatement(onHoldQuery)) {
            onHoldStatement.setString(1, checkoutId);
            ResultSet onHoldResultSet = onHoldStatement.executeQuery();
            return onHoldResultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            // Return false in case of an exception
            return false;
        }
    }

    private static int getMaxHoldStatus(Connection connection, String copyId) throws SQLException {
        // Find the maximum status for the specified copy_id
        String maxStatusQuery = "SELECT MAX(status) AS max_status FROM Hold WHERE copy_id = ?";
        try (PreparedStatement maxStatusStatement = connection.prepareStatement(maxStatusQuery)) {
            maxStatusStatement.setString(1, copyId);
            ResultSet maxStatusResultSet = maxStatusStatement.executeQuery();

            if (maxStatusResultSet.next()) {
                return maxStatusResultSet.getInt("max_status");
            }
        }
        return 0; // If no holds exist for the copy_id, return 0
    }

    public static boolean holdBook(String holdId, String studentId, String copyId, String holdDate) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Insert the hold record
            String query = "INSERT INTO Hold (hold_id, student_id, copy_id, hold_date, status) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, holdId);
                preparedStatement.setString(2, studentId);
                preparedStatement.setString(3, copyId);
                preparedStatement.setString(4, holdDate);

                // Get the maximum hold status for the specified copy_id
                int status = getMaxHoldStatus(connection, copyId);
                preparedStatement.setInt(5, status + 1);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    return true; // Successful hold
                } else {
                    JOptionPane.showMessageDialog(null, "Error placing book on hold.");
                    return false; // Error in hold
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error placing book on hold.");
            return false; // Error in hold
        }
    }

    public static int getHoldingStudentId(String checkoutId) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Get the copy ID corresponding to the checkout ID
            String copyIdQuery = "SELECT copy_id FROM Checkout WHERE checkout_id = ?";
            String copyId;

            try (PreparedStatement copyIdStatement = connection.prepareStatement(copyIdQuery)) {
                copyIdStatement.setString(1, checkoutId);
                ResultSet copyIdResultSet = copyIdStatement.executeQuery();

                if (copyIdResultSet.next()) {
                    copyId = copyIdResultSet.getString("copy_id");
                } else {
                    // If copy_id not found, return -1
                    return -1;
                }
            }

            // Get the student ID holding the book with status 1
            String selectQuery = "SELECT Hold.student_id FROM Hold JOIN Checkout ON Hold.copy_id = Checkout.copy_id WHERE Hold.copy_id = ? AND Hold.status = 1";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, copyId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt("student_id");
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static void decrementHoldStatus(String checkoutId) {
        try {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);

            // Get copy_id from the returned book
            String copyIdQuery = "SELECT copy_id FROM Checkout WHERE checkout_id = ?";
            String copyId;

            try (PreparedStatement copyIdStatement = connection.prepareStatement(copyIdQuery)) {
                copyIdStatement.setString(1, checkoutId);
                ResultSet copyIdResultSet = copyIdStatement.executeQuery();

                if (copyIdResultSet.next()) {
                    copyId = copyIdResultSet.getString("copy_id");

                    // Get the hold ID with status 1 for the specified copy_id
                    String getHoldIdQuery = "SELECT hold_id FROM Hold WHERE copy_id = ? AND status = 1 ORDER BY hold_date ASC LIMIT 1";
                    String holdIdToDelete;

                    try (PreparedStatement getHoldIdStatement = connection.prepareStatement(getHoldIdQuery)) {
                        getHoldIdStatement.setString(1, copyId);
                        ResultSet holdIdResultSet = getHoldIdStatement.executeQuery();

                        if (holdIdResultSet.next()) {
                            holdIdToDelete = holdIdResultSet.getString("hold_id");

                            // Delete the hold record
                            String deleteHoldQuery = "DELETE FROM Hold WHERE hold_id = ?";
                            try (PreparedStatement deleteHoldStatement = connection.prepareStatement(deleteHoldQuery)) {
                                deleteHoldStatement.setString(1, holdIdToDelete);
                                deleteHoldStatement.executeUpdate();
                            }
                        }
                    }

                    // Decrement statuses for other holds of the same copy_id
                    String decrementStatusQuery = "UPDATE Hold SET status = status - 1 WHERE copy_id = ? AND status > 1";
                    try (PreparedStatement decrementStatusStatement = connection.prepareStatement(decrementStatusQuery)) {
                        decrementStatusStatement.setString(1, copyId);
                        decrementStatusStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
            Connection connection = DriverManager.getConnection(url, mysqluser, mysqlpassword);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);

    }


}
