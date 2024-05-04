import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;

public class DataD extends JPanel {

    Commands cmd = new Commands();
    private JButton Copies;
    private JButton Students;
    private JButton Books;

    public DataD() {
        // construct components
        Copies = new JButton("COPIES");
        Students = new JButton("STUDENTS");
        Books = new JButton("BOOKS");

        // set font to Times New Roman
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 14);

        // adjust size and set layout
        setPreferredSize(new Dimension(300, 450));
        setLayout(null);

        // add components
        add(Copies);
        add(Students);
        add(Books);

        // set font for buttons
        Copies.setFont(timesNewRoman);
        Students.setFont(timesNewRoman);
        Books.setFont(timesNewRoman);

        // set component bounds (only needed by Absolute Positioning)
        Copies.setBounds(100, 200, 100, 25);
        Students.setBounds(75, 300, 150, 25);
        Books.setBounds(100, 100, 100, 25);

        Copies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTableData("bookcopy");
            }
        });

        Students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTableData("students");
            }
        });

        Books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTableData("books");
            }
        });
        setBackground(Color.decode("#ADD8E6"));

    }

    private void displayTableData(String tableName) {
        // Write code here to fetch data from the corresponding table and display it on the screen.
        String query = "SELECT * FROM " + tableName; // Replace with your actual SQL query

        try {
            // Fetch data from the database
            // Assume that executeQuery returns a ResultSet
            ResultSet resultSet = cmd.executeQuery(query);

            // Display data in a JTable (you may want to customize this based on your GUI)
            JTable dataTable = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(dataTable);

            // Create and configure a new JFrame to display the data
            JFrame dataFrame = new JFrame("Table Data: " + tableName);
            dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dataFrame.getContentPane().add(scrollPane);
            dataFrame.pack();
            dataFrame.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data from the database.");
        }
    }

    // Utility method to convert a ResultSet to a DefaultTableModel
    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Get data rows
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(resultSet.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }
}
