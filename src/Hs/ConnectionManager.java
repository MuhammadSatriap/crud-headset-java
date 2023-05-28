package Hs;//Untuk mengelompokan class-class yang terkait/Folder dalam direktori file yang dapat digunakan untuk menghindari konflik nama.

import java.sql.Connection;//memanggil class driver dari Sql
import java.sql.DriverManager;//memanggil class driver dari Sql

/**
 *
 * @author Satria
 */
public class ConnectionManager {//Cetak biru atau blueprint yang berisikan tipe data dan method.
    private Connection con;//Inisiaslisasi connection
    private String driver = "com.mysql.jdbc.Driver";//Memanggil driver mySql
    private String url = "jdbc:mysql://localhost/tubespbo"; //Memasukkan nama database
    private String username = "root"; //Username dari database
    private String password = ""; //Password dari database
    
    public Connection logOn(){//Method log on
        try {//Untuk mencoba seuah kode
            //Load JDBC Driver
            Class.forName( driver ).newInstance();//mengembalikan nilai objek class yang terkait
            //Buat object Connection
            con = DriverManager.getConnection(url,username,password );//Mengkoneksikan driver dengan database
        }
        catch(Exception ex){//Untuk menangkap sebuah error  yang dihasilikan dari code tersebut
            ex.printStackTrace();
        }
    
    return con;
    }
    
    public void logOff(){
        try {
            //Tutup Koneksi
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
