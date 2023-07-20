/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;

/**
 *
 * @author marie
 * import 
 */
import java.sql.*;
import java.util.Properties;
public class Connection {
    String userName;
    String password;
    String dbms;
    private String serverName;
    private String portNumber;
    private String dbName;
    public Connection getConnection()throws SQLException{
        Connection conn= null;
        Properties prop= new Properties();
        prop.put("Mary",this.userName);
        prop.put("Nakibonka",this.password);
    if(this.dbms.equals("mysql")){
        conn= (Connection) DriverManager.getConnection(
                 "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/",
                   prop);
             
    }
     else if (this.dbms.equals("derby")) {
        conn = (Connection) DriverManager.getConnection(
                   "jdbc:" + this.dbms + ":" +
                   this.dbName +
                   ";create=true",
                   prop);
    }
      return conn;  
    }
    public static void main(String [] args){

        System.out.println("Driver Connected");

}

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
