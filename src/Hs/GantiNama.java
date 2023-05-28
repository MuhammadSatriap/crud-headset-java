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
public class GantiNama {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement st;
    static ResultSet rs;
    
    public void read(){
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        String brand = JOptionPane.showInputDialog("Masukkan Brand Baru Headset");
        int hasil = 0;
        
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET brand = '"+brand+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            String qry = "SELECT * FROM hs";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = st.executeQuery(qry);
            
            // tampilkan hasil query
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Brand: " + rs.getString("brand"));
                
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
  
        
        
    }
    
}
