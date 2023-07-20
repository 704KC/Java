/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marie
 */

public class ProductsJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Goodies_database", "root", "");
        Statement st = con.createStatement();
        String table3 = "CREATE TABLE products ("
                + "products_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, "
                + "Product_name VARCHAR(234) NOT NULL, "
                + "description VARCHAR(56) ,"
                + "quantity VARCHAR(25) NOT NULL,"
                + "Price DECIMAL(10,3 ) NOT NULL)";

        st.executeUpdate(table3);

        PreparedStatement ps = con.prepareStatement("INSERT INTO products ( Product_name, description,quantity,Price) VALUES (?, ?,?,?)");
        String[][] productsData = {
            {"Sugar","A product of kakiraaa", "kg" ,"5000.0"},
            {"Headsets","Music", "","3900.0"}
            
        };

        // Adding records to batch
        for (String[] y : productsData) {
            ps.setString(1, y[0]);//name
            ps.setString(2, y[1]);//description
            ps.setString(3, y[2]);//quantity
            ps.setBigDecimal(4, new BigDecimal(y[3])); // Price            
            ps.addBatch();
        }

        // Print results for the batch
        int[] rowsAffected = ps.executeBatch();

        for (int i = 0; i < rowsAffected.length; i++) {
            if (rowsAffected[i] > 0) {
                System.out.println("Insert done");
            } else {
                System.out.println("Insert failed");
            }
        }

        ps.close();
        st.close();
        con.close();
    }
}

