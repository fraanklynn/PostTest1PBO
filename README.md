# PostTest1PBO

## Deskripsi Singkat
Program ini merupakan program untuk manajemen fasilitas gym. Tujuan dari program ini adalah untuk membantu dalam pencatatan, pengelolaan, dan pembaruan data fasilitas gym agar lebih terorganisir.

## Alur Program
Program dimulai dari 
1. Masuk ke menu
2. Pilihan menu terdiri dari tambah fasilitas,lihat fasilitas,update fasilitas, hapus fasilitas, dan keluar dari program
3. Pilihan tambah fasilitas akan muncul fasilitas apa saja yang ada di program lalu kita diminta menambahkan fasilitas apa yg ingin ditambah, jika sudah menambahkan maka fasilitas akan ditambah di program
4. Pilihan lihat fasilitas akan muncul fasilitas apa saja yang tersedia
5. Pilihan update fasilitas akan muncul fasilitas apa saja yang tersedia, lalu diminta memilih id dari fasilitas yang ingin di update, jika sudah maka akan diminta untuk mengubah fasilitas yg ingin diubah
6. Pilihan hapus fasilitas akan muncul fasilitas apa saja yg tersedia, lalu diminta memilih id dari fasilitas apa yang ingin dihapus, jika sudah maka fasilitas akan terhapus


## Penjelasan Code

#### package com.mycompany.main;
#### import java.util.ArrayList;
#### import java.util.Scanner;

Kode di atas menggunakan package com.mycompany.main untuk mengelompokkan class agar lebih terstruktur, lalu ArrayList diimpor sebagai struktur data dinamis untuk menyimpan dan mengelola daftar fasilitas gym, sedangkan Scanner digunakan agar program dapat menerima input dari pengguna melalui keyboard, misalnya untuk memilih menu atau memasukkan data baru.

#### public class Main {
Baris ini mendeklarasikan sebuah class bernama Main yang menjadi titik awal dari program.

#### public static void main(String[] args) {
        ArrayList<String> fasilitasGym = new ArrayList<>();
        try (Scanner menu = new Scanner(System.in)) {
            int pilihan;
Bagian ini mendefinisikan method utama main sebagai titik awal program, lalu membuat sebuah ArrayList bertipe String bernama fasilitasGym untuk menyimpan daftar fasilitas gym, kemudian mendeklarasikan Scanner bernama menu dengan mekanisme try-with-resources agar dapat menerima input dari keyboard secara aman, serta menyiapkan variabel pilihan bertipe integer untuk menampung input menu yang dipilih pengguna.

#### do{
                System.out.println("-----Fasilitas Gym-----");
                System.out.println("1. Tambah Fasilitas");
                System.out.println("2. Lihat Fasilitas");
                System.out.println("3. Ubah Fasilitas");
                System.out.println("4. Hapus Fasilitas");
                System.out.println("5. Keluar");
                System.out.println("Pilih Menu : ");
                pilihan = menu.nextInt();
                menu.nextLine();
                
Bagian ini menampilkan daftar menu utama berupa opsi untuk menambah, melihat, mengubah, menghapus fasilitas, atau keluar dari program. Menu tersebut dicetak berulang setiap kali pengguna selesai memilih, lalu input angka yang dimasukkan pengguna disimpan dalam variabel pilihan. Pemanggilan menu.nextLine() setelahnya berguna untuk menghindari masalah loncatan input ketika pengguna memasukkan data berikutnya.

####   switch (pilihan) {
                    case 1 -> {
                        tampilkanFasilitas(fasilitasGym);
                        System.out.println("Masukkan fasilitas baru: ");
                        fasilitasGym.add(menu.nextLine());
                        System.out.println("Fasilitas berhasil ditambahkan!");
                        tampilkanFasilitas(fasilitasGym);
                    }

Pada bagian ini digunakan switch untuk menangani logika berdasarkan menu yang dipilih pengguna. Jika pengguna memilih angka 1, maka program akan terlebih dahulu menampilkan daftar fasilitas yang sudah ada, kemudian meminta input fasilitas baru. Data yang dimasukkan pengguna ditambahkan ke dalam daftar fasilitasGym, lalu program menampilkan pesan konfirmasi bahwa fasilitas berhasil ditambahkan, dan menampilkan kembali daftar fasilitas terbaru setelah penambahan.

####      
                    case 2 -> tampilkanFasilitas(fasilitasGym);

Jika pengguna memilih angka 2, maka program langsung memanggil fungsi tampilkanFasilitas(fasilitasGym) yang akan menampilkan seluruh daftar fasilitas gym yang tersimpan saat itu, tanpa melakukan perubahan data apa pun

####  case 3 -> {
                        if(!fasilitasGym.isEmpty()) {
                            tampilkanFasilitas(fasilitasGym);
                            System.out.println("Pilih nomor fasilitas yang diubah: ");
                            int idxUbah = menu.nextInt(); menu.nextLine();
                            if (idxUbah >= 1 && idxUbah <= fasilitasGym.size()) {
                                System.out.println("Masukkan fasilitas baru: ");
                                fasilitasGym.set(idxUbah - 1, menu.nextLine());
                                System.out.println("Fasilitas berhasil diubah!");
                            } else {
                                System.out.println("Nomor tidak valid");
                            }
                            tampilkanFasilitas(fasilitasGym);
                        } else {
                            System.out.println("Belum ada fasilitas");
                        }
                    }

Pada pilihan 3, program digunakan untuk mengubah data fasilitas. Pertama, dicek apakah daftar fasilitas kosong atau tidak. Jika ada isinya, program menampilkan semua fasilitas lalu meminta pengguna memilih nomor fasilitas yang ingin diubah. Setelah pengguna memasukkan nomor, dicek apakah nomor tersebut valid (ada dalam daftar). Jika valid, program meminta input nama fasilitas baru dan menggantikan data lama dengan yang baru menggunakan set(). Setelah berhasil, program menampilkan pesan konfirmasi serta daftar fasilitas terbaru. Jika nomor yang dimasukkan tidak sesuai, muncul pesan "Nomor tidak valid", sedangkan jika daftar masih kosong maka ditampilkan pesan "Belum ada fasilitas".

####  case 4 -> {
                        if (!fasilitasGym.isEmpty()) {
                            tampilkanFasilitas(fasilitasGym);
                            System.out.print("Pilih nomor fasilitas yang dihapus: ");
                            int idxHapus = menu.nextInt(); menu.nextLine();
                            if (idxHapus >= 1 && idxHapus <= fasilitasGym.size()) {
                                fasilitasGym.remove(idxHapus - 1);
                                System.out.println("Fasilitas berhasil dihapus!");
                            } else {
                                System.out.println("Nomor tidak valid!");
                            }
                            tampilkanFasilitas(fasilitasGym);
                        } else {
                            System.out.println("Belum ada fasilitas.");
                        }
                    }

Pada pilihan 4, program dipakai untuk menghapus fasilitas. Jika daftar fasilitas tidak kosong, program menampilkan seluruh fasilitas terlebih dahulu lalu meminta pengguna memilih nomor fasilitas yang ingin dihapus. Nomor yang dimasukkan dicek apakah valid (masih dalam rentang daftar). Jika valid, fasilitas tersebut dihapus dari ArrayList menggunakan remove(), kemudian program menampilkan pesan konfirmasi dan daftar terbaru. Jika nomor tidak sesuai, akan muncul pesan "Nomor tidak valid!", sedangkan jika daftar kosong dari awal maka akan ditampilkan pesan "Belum ada fasilitas.".

####     case 5 -> System.out.println("Program Selesai. Terima kasih!");
                        
                    default -> System.out.println("Pilihan tidak valid!");
