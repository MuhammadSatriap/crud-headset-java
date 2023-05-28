/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hs;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TampilData {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement st;
    static ResultSet rs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "SELECT * from hs";
            
            rs = st.executeQuery(sql);
            
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Brand: " + rs.getString("brand") + ", Tipe: " + rs.getString("tipe") + ", Jenis: " + rs.getString("jenis") +  ", Harga: " + rs.getInt("harga"));
                
                
            }
            
        } catch (Exception e) {
        }
    }
    
}
