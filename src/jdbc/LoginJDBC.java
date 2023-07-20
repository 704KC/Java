/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marie
 */
public class LoginJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Goodies_database"; // Replace with your database URL
        String user = "root"; // Replace with your database username
        String password = ""; // Replace with your database password if applicable

        try {
            // Step 1: Register JDBC driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            java.sql.Connection connection = DriverManager.getConnection(url, user, password);

            // Step 3: Create the table
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE login (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableQuery);

            // Step 4: Insert data into the table
            String insertQuery = "INSERT INTO login (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Inserting the first record
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "pass1");
            preparedStatement.executeUpdate();

            // Inserting the second record
            preparedStatement.setString(1, "user2");
            preparedStatement.setString(2, "pass2");
            preparedStatement.executeUpdate();

            System.out.println("Table 'login' created and data inserted successfully.");

            // Step 5: Close resources
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database or execute the query.");
            e.printStackTrace();
        }
    }


    
}
