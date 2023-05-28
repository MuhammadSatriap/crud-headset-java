package HsBaru;

import java.util.Scanner;
/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Data dat1 = new Data();
        Scanner scanner = new Scanner(System.in);
        
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
                dat1.read();
                break;
            case 3://Case pertama jika user memilih 3
                dat1.update();//Memanggil method
                break;
            case 4://Case pertama jika user memilih 4
                dat1.delete();//Memanggil method
                break;
            case 5:
                System.out.println("Okay");
                break;
            default:
            System.out.println("Tidak ada di pilihan!");
            break;
        }
        
        }while (pilihan !=5 );
         scanner.close();
    }
    
}
