package HsBaru;

import Hs.Controller;
import Hs.GantiNama;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Satria
 */
public class Data {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tubespbo";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement st;
    static ResultSet rs;
    
    private int id;//Inisialisasi tipe data.
    private String brand;
    private String tipe;//Inisialisasi tipe data.
    private String jenis;//Inisialisasi tipe data.
    private int harga;//Inisialisasi tipe data.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

        
    public void create(){//Method untuk membuat data
        brand = JOptionPane.showInputDialog("Masukkan Brand Headset");//Mengambil data dengan JOptionpane
        tipe = JOptionPane.showInputDialog("Masukkan Tipe Headset");//Mengambil data dengan JOptionpane
        jenis = JOptionPane.showInputDialog("Masukkan Jenis Headset");//Mengambil data dengan JOptionpane
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga Headset"));//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "INSERT INTO hs(brand, tipe, jenis, harga) values('"+ brand +"', '"+ tipe +"', '"+ jenis +"', '"+ harga +"')"  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void read(){//Method untuk membaca data
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            st = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM hs";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = st.executeQuery(sql);
            
            // tampilkan hasil query
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + ", Brand: " + rs.getString("brand") + ", Tipe: " + rs.getString("tipe") + ", Jenis: " + rs.getString("jenis") +  ", Harga: " + rs.getInt("harga"));
                
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        System.out.println("Data Headset: ");
        System.out.println("------------");
        read();
        System.out.println("------------");
        
        do{
        System.out.println("Update yang mana?  ");//Menuliskan kalimat yang ditentukan
        System.out.println("1. Semua");//Menuliskan kalimat yang ditentukan
        System.out.println("2. Brand");//Menuliskan kalimat yang ditentukan
        System.out.println("3. Tipe");//Menuliskan kalimat yang ditentukan
        System.out.println("4. Jenis");//Menuliskan kalimat yang ditentukan
        System.out.println("5. Harga");//Menuliskan kalimat yang ditentukan
        System.out.println("6. Keluar");
        pilihan = scanner.nextInt();//Membaca inputan dari user
        
        
        switch(pilihan){//Perintah untuk menentukan kondisi beberapa pilihan
            case 1://Case pertama jika user memilih 1
                semua();//Memanggil method 
                break;
            case 2://Case pertama jika user memilih 2
                //dat1.read();//Memanggil method
                brBaru();
                break;
            case 3://Case pertama jika user memilih 3
                tpBaru();//Memanggil method
                break;
            case 4://Case pertama jika user memilih 4
                jnBaru();//Memanggil method
                break;
            case 5:
                hrgBaru();
                break;
            case 6:
                System.out.println("Terimakasih");
                break;
            default:
            System.out.println("Tidak ada di pilihan");
            break;
        }
        
        }while (pilihan !=6 );
        // System.exit(0);
    }
    
    
    //Section Update
    public void semua(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        brand = JOptionPane.showInputDialog("Masukkan Brand baru Headset");//Mengambil data dengan JOptionpane
        tipe = JOptionPane.showInputDialog("Masukkan Tipe baru Headset");//Mengambil data dengan JOptionpane
        jenis = JOptionPane.showInputDialog("Masukkan Jenis baru Headset");//Mengambil data dengan JOptionpane
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga baru Headset"));//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET brand = '"+brand+"', tipe = '"+tipe+"', jenis = '"+jenis+"', harga = '"+harga+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
    public void brBaru(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        brand = JOptionPane.showInputDialog("Masukkan Brand baru Headset");//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET brand = '"+brand+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void tpBaru(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        tipe = JOptionPane.showInputDialog("Masukkan Tipe baru Headset");//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET tipe = '"+tipe+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void jnBaru(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        jenis = JOptionPane.showInputDialog("Masukkan Jenis baru Headset");//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET jenis = '"+jenis+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void hrgBaru(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga baru Headset"));//Mengambil data dengan JOptionpane
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "UPDATE hs " + "SET harga = '"+harga+"' WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    //End Section
    
    public void delete(){
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dihapus"));
        System.out.println("Data Headset: ");
        System.out.println("------------");
        read();
        System.out.println("------------");
        int hasil = 0;
        try {
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            
            String sql = "DELETE FROM hs " + "WHERE id = '"+id+"' "  ;
            
            hasil = st.executeUpdate(sql);
            
            read();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(GantiNama.class.getName()).log(Level.SEVERE, null, e);
        }
              
    }
    
}

