package Hs;//Untuk mengelompokan class-class yang terkait/Folder dalam direktori file yang dapat digunakan untuk menghindari konflik nama.

import java.sql.Connection;//Mengimport class untuk mengkoneksikan java dengan SQL.
import java.sql.ResultSet;//Mengimport class sql untuk mendapatkan return value ketika menjalankan statement ke database
import java.sql.SQLException;//Mengimport class sql untuk mendreskripsikan error
import java.sql.Statement;//Mengimport class sql untuk membuat statement
import java.util.ArrayList;//Mengimport class untuk array
import java.util.List;//Mengimport class untuk list
import java.util.logging.Level;//Mengimport class untuk membuat type data yang lebih tinggi/ BigDecimal
import java.util.logging.Logger;//Mengimport class untuk membuat type data yang lebih tinggi/ BigDecimal
/**
 *
 * @author Satria
 */
public class Controller {//Cetak biru atau blueprint yang berisikan tipe data dan method.

//Tambah data atau create data
    public int saveData(String brand, String tipe, String jenis, int harga){
        int hasil = 0;
            ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
            Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
            String query = "INSERT INTO hs(brand, tipe, jenis, harga) values('"+ brand +"', '"+ tipe +"', '"+ jenis +"', '"+ harga +"')" ;//query sql
        try {//Untuk menangkap dan menangani error runtime
            Statement stm = conn.createStatement();//Membuat statement sql.
            hasil = stm.executeUpdate(query);//Menjalankan statement sql.
        } catch (SQLException ex) {//Untuk menangani error runtime
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();//Memanggil conMan.logOff
    return hasil;//Mengembalikan nilai hasil.
    }   

//Baca data atau read data
    
    public List<Data> getAllData(){//Method untuk menampilkan semua data
        String query = "Select * from hs";//Query sql select dari database
        List<Data> allData = new ArrayList<Data>();
        ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
        Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
        try {//Untuk menangkap dan menangani error runtime
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){//Mengembalikan nilai boolean yang menentukan apakah ResultSet berisi lebih banyak baris
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String tipe = rs.getString("tipe");
                String jenis = rs.getString("jenis");
                int harga = rs.getInt("harga");
                Data d1 = new Data(id, brand, tipe, jenis, harga);
                allData.add(d1);
                
            }
        } catch (SQLException ex) {//Untuk menangkap dan menangani error runtime
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
    
    return allData;
    }
    
//Update data
    public int updateData(int id, String brand, String tipe, String jenis, int harga){//Method untuk Memperbarui data
        int hasil = 0;
            ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
            Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
            String query = "UPDATE hs " + "SET brand = '"+brand+"', tipe = '"+tipe+"', jenis = '"+jenis+"', harga = '"+harga+"' WHERE id = '"+id+"' "  ;
        try {//Untuk menangkap dan menangani error runtime
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {//Untuk menangkap dan menangani error runtime
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
    return hasil;
    } 

//Delete data
    public int deleteData(int id, String brand, String tipe, String jenis, int harga){//Method untuk menghaus data
        int hasil = 0;
            ConnectionManager conMan = new ConnectionManager();//Membuat objek connectionManager
            Connection conn = conMan.logOn();//Inisialisasi connection dengan conMan.logOn
            String query = "DELETE FROM hs " + "WHERE id = '"+id+"' "  ;
        try {//Untuk menangkap dan menangani error runtime
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {//Untuk menangkap dan menangani error runtime
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
    return hasil;
    }

    public void read(){//Method untuk membaca data
        Controller manCon = new Controller();
        List<Data> allData = manCon.getAllData();
        for(Data dat1: allData){
            System.out.println(dat1);
        }
    }
 
}
