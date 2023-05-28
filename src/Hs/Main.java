package Hs;//Untuk mengelompokan class-class yang terkait/Folder dalam direktori file yang dapat digunakan untuk menghindari konflik nama.

import java.sql.Connection;//Mengimport class untuk mengkoneksikan java dengan SQL.
import java.util.Scanner;//Mengimpirt class yang berfungsi membaca masukan dari keyboard.
/**
 *
 * @author User
 */
public class Main {//Cetak biru atau blueprint yang berisikan tipe data dan method.

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//Method yang berfungsi untuk menjalankan program/sebagai main.
        Scanner scanner = new Scanner(System.in);
        ConnectionManager conMan = new ConnectionManager();//Membuat obbjek baru dari class ConnectionManager
        Connection conn = conMan.logOn();//Inisialisasi Conn dengan dengan conMan.logOn
        System.out.println("Koneksi" + conn);//Menuliskan kalimat yang ditentukan
        Data dat1 = new Data();//Membuat objek data.
        Controller con1 = new Controller();
        int pilihan;
        do{
        System.out.println("Selamat Datang, Silahkan Masukan Pilihan: ");//Menuliskan kalimat yang ditentukan
        System.out.println("1. Menambahkan Data (Create)");//Menuliskan kalimat yang ditentukan
        System.out.println("2. Membaca Data (Read)");//Menuliskan kalimat yang ditentukan
        System.out.println("3. Memperbarui Data (Update)");//Menuliskan kalimat yang ditentukan
        System.out.println("4. Menghapus Data (Delete)");//Menuliskan kalimat yang ditentukan
        System.out.println("5. Keluar");//Menuliskan kalimat yang ditentukan
        pilihan = scanner.nextInt();//Membaca inputan dari user
        
        
        switch(pilihan){//Perintah untuk menentukan kondisi beberapa pilihan
            case 1://Case pertama jika user memilih 1
                dat1.create();//Memanggil method 
                break;
            case 2://Case pertama jika user memilih 2
                //dat1.read();//Memanggil method
                con1.read();
                break;
            case 3://Case pertama jika user memilih 3
                dat1.update();//Memanggil method
                break;
            case 4://Case pertama jika user memilih 4
                dat1.delete();//Memanggil method
                break;
            case 5:
                System.out.println("Terimakasih");
        }
        
        }while (pilihan !=5 );
         scanner.close();
    }
    
}
