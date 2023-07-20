/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

/**
 *
 * @author marie
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Goodies_database", "root", "");
        Statement st = conn.createStatement();

        // Execute SELECT query using Statement
        ResultSet rs = st.executeQuery("SELECT * FROM user_registration");
        while (rs.next()) {
            int registration_id = rs.getInt("registration_id");
            String name = rs.getString("firstname");
            System.out.println("ID: " + registration_id + ", Name: " +name);
        }

        // Execute INSERT query using PreparedStatement
        PreparedStatement ps = conn.prepareStatement("INSERT INTO user_registration (registration_id,firstname, lastname, username, telephone, password, gender) VALUES (?, ?, ?, ?, ?, ?,?)");
        ps.setInt(1, 005);
        ps.setString(2, "hh");
        ps.setString(3, "Blue");
        ps.setString(4, "hjn");
        ps.setString(5, "+2344455666");
        ps.setString(6, "nnnnn");
        ps.setString(7, "male");

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Data insertion failed.");
        }
        rs.close();

        ps.close();
        st.close();
        conn.close();
    }
    

    
}
