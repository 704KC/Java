/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

/**
 *
 * @author marie
 */
import java.sql.*;
public class MyJdbc {
    public static void main(String []args) throws ClassNotFoundException,SQLException{
    
    String driver="oracle.jdbc.driver.OracleDriver";
    String url="jdbc:oracle:thin:@localhost:1521:xe";
    String user="system";
    String password="Nakiboneka";
    String query="Enter Querry here";
    
    
    //Register database driver
    Class.forName(driver);
    
    Connection con= (Connection) DriverManager.getConnection(url,user,password);
    Statement st= con.createStatement();
    int count = st.executeUpdate(query);
    System.out.println(" My first jdbc ");
    
    con.close();
    
    }
    
}
