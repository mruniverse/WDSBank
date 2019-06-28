/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.*;
/**
 *
 * @author yuril
 */
public class Connector {
    private static final String USERNAME = "mysql";
    private static final String PASSWORD = "mysql";
    private static final String CONN_STRING = 
            "jdbc:mysql://localhost:3306/Banco24h";

    public Connector() {
    }
    
    public Connection connect() {
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        
        return conn;
    }
}