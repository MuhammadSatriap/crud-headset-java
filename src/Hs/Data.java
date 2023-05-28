package Hs;//Untuk mengelompokan class-class yang terkait/Folder dalam direktori file yang dapat digunakan untuk menghindari konflik nama.

import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Satria
 */
public class Data {//Cetak biru atau blueprint yang berisikan tipe data dan method.
    private int id;//Inisialisasi tipe data.
    private String brand;
    private String tipe;//Inisialisasi tipe data.
    private String jenis;//Inisialisasi tipe data.
    private int harga;//Inisialisasi tipe data.

    public Data() {
    }

    public Data(String brand, String tipe, String jenis, int harga) {
        this.brand = brand;
        this.tipe = tipe;
        this.jenis = jenis;
        this.harga = harga;
    }

    
    public Data(int id, String brand, String tipe, String jenis, int harga) {
        this.id = id;
        this.brand = brand;
        this.tipe = tipe;
        this.jenis = jenis;
        this.harga = harga;
    }


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

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", brand=" + brand + ", tipe=" + tipe + ", jenis=" + jenis + ", harga=" + harga + '}';
    }
        
    public void create(){//Method untuk membuat data
        brand = JOptionPane.showInputDialog("Masukkan Brand Headset");//Mengambil data dengan JOptionpane
        tipe = JOptionPane.showInputDialog("Masukkan Tipe Headset");//Mengambil data dengan JOptionpane
        jenis = JOptionPane.showInputDialog("Masukkan Jenis Headset");//Mengambil data dengan JOptionpane
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga Headset"));//Mengambil data dengan JOptionpane
        
        Controller manCon = new Controller();//Membuat objek Controller
        int hasil = manCon.saveData(brand, tipe, jenis, harga);//Inisialisasi hasil
        System.out.println("Hasil input data: " + hasil);
        read();
    }
    
    public void read(){//Method untuk membaca data
        Controller manCon = new Controller();
        List<Data> allData = manCon.getAllData();
        for(Data dat1: allData){
            System.out.println(dat1);
        }
    }
    
    public void update(){//Method untuk memperbarui data
        id = Integer.parseInt(JOptionPane.showInputDialog("Masukkan ID headset yang mau dirubah"));
        brand = JOptionPane.showInputDialog("Masukkan Brand Baru Headset");
        tipe = JOptionPane.showInputDialog("Masukkan Tipe Baru Headset");
        jenis = JOptionPane.showInputDialog("Masukkan Jenis Baru Headset");
        harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga Baru Headset"));
        
        Controller manCon = new Controller();
        int hasil = manCon.updateData(id, brand, tipe, jenis, harga);
        System.out.println("Hasil update data: " + hasil);
        read();
    }
    
    public void delete(){//Method untuk menghapus data.
        id = Integer.parseInt(JOptionPane.showInputDialog("ID Yang mau dihapus"));
        
        Controller manCon = new Controller();
        int hasil = manCon.deleteData(id, brand, tipe, jenis, harga);
        System.out.println("Hasil hapus data: " + hasil);
        read();
    }
}
