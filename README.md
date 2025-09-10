# PostTest1PBO

## Deskripsi Singkat
Program ini merupakan program untuk manajemen fasilitas gym. Tujuan dari program ini adalah untuk membantu dalam pencatatan, pengelolaan, dan pembaruan data fasilitas gym agar lebih terorganisir.

## Alur Program
Program dimulai dari 
1. Masuk ke menu
2. Pilihan menu terdiri dari tambah fasilitas,lihat fasilitas,ubah fasilitas, hapus fasilitas, dan keluar dari program
3. Pilihan tambah fasilitas akan muncul fasilitas apa saja yang ada di program lalu kita diminta menambahkan fasilitas apa yg ingin ditambah, jika sudah menambahkan maka fasilitas akan ditambah di program
4. Pilihan lihat fasilitas akan muncul fasilitas apa saja yang tersedia
5. Pilihan update fasilitas akan muncul fasilitas apa saja yang tersedia, lalu diminta memilih id dari fasilitas yang ingin di ubah, jika sudah maka akan diminta untuk mengubah fasilitas yg ingin diubah
6. Pilihan hapus fasilitas akan muncul fasilitas apa saja yg tersedia, lalu diminta memilih id dari fasilitas apa yang ingin dihapus, jika sudah maka fasilitas akan terhapus


## Penjelasan Code

#### package com.mycompany.main;
#### import java.util.ArrayList;
#### import java.util.Scanner;

Kode di atas menggunakan package com.mycompany.main untuk mengelompokkan class agar lebih terstruktur, lalu ArrayList diimpor sebagai struktur data dinamis untuk menyimpan dan mengelola daftar fasilitas gym, sedangkan Scanner digunakan agar program dapat menerima input dari pengguna melalui keyboard, misalnya untuk memilih menu atau memasukkan data baru.

#### public class Main {
Baris ini mendeklarasikan sebuah class bernama Main yang menjadi titik awal dari program.

    public static void main(String[] args) {
        ArrayList<String> fasilitasGym = new ArrayList<>();
        try (Scanner menu = new Scanner(System.in)) {
            int pilihan;

            
Bagian ini mendefinisikan method utama main sebagai titik awal program, lalu membuat sebuah ArrayList bertipe String bernama fasilitasGym untuk menyimpan daftar fasilitas gym, kemudian mendeklarasikan Scanner bernama menu dengan mekanisme try-with-resources agar dapat menerima input dari keyboard secara aman, serta menyiapkan variabel pilihan bertipe integer untuk menampung input menu yang dipilih pengguna.
     
            do{
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

                switch (pilihan) {
                    case 1 -> {
                        tampilkanFasilitas(fasilitasGym);
                        System.out.println("Masukkan fasilitas baru: ");
                        fasilitasGym.add(menu.nextLine());
                        System.out.println("Fasilitas berhasil ditambahkan!");
                        tampilkanFasilitas(fasilitasGym);
                    }


Pada bagian ini digunakan switch untuk menangani logika berdasarkan menu yang dipilih pengguna. Jika pengguna memilih angka 1, maka program akan terlebih dahulu menampilkan daftar fasilitas yang sudah ada, kemudian meminta input fasilitas baru. Data yang dimasukkan pengguna ditambahkan ke dalam daftar fasilitasGym, lalu program menampilkan pesan konfirmasi bahwa fasilitas berhasil ditambahkan, dan menampilkan kembali daftar fasilitas terbaru setelah penambahan.

                    case 2 -> tampilkanFasilitas(fasilitasGym);

Jika pengguna memilih angka 2, maka program langsung memanggil fungsi tampilkanFasilitas(fasilitasGym) yang akan menampilkan seluruh daftar fasilitas gym yang tersimpan saat itu, tanpa melakukan perubahan data apa pun

                    case 3 -> {
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

     case 4 -> {
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

             
                    case 5 -> System.out.println("Program Selesai. Terima kasih!");
                        
                    default -> System.out.println("Pilihan tidak valid!");
                        
                }
                
            } while (pilihan != 5);
        }
    }

Pada pilihan 5, program akan menampilkan pesan "Program Selesai. Terima kasih!" dan menjadi syarat untuk menghentikan perulangan karena kondisi while (pilihan != 5) akan bernilai salah. Jika pengguna memasukkan angka selain 1–5, maka blok default dijalankan yang menampilkan pesan "Pilihan tidak valid!". Setelah itu, program akan kembali menampilkan menu sampai pengguna memilih opsi keluar (nomor 5). Dengan demikian, alur program terus berulang hingga benar-benar diperintah berhenti oleh pengguna.

    private static void tampilkanFasilitas(ArrayList<String> fasilitasGym) {
        System.out.println("\n+----+----------------------+");
        System.out.println("| No | Nama Fasilitas       |");
        System.out.println("+----+----------------------+");

        if (fasilitasGym.isEmpty()) {
            System.out.println("| -- | (kosong)             |");
        } else {
            for (int i = 0; i < fasilitasGym.size(); i++) {
                System.out.printf("| %-2d | %-20s |\n", (i + 1), fasilitasGym.get(i));
            }
        }
        System.out.println("+----+----------------------+");
    }

Method tampilkanFasilitas ini berfungsi untuk menampilkan daftar fasilitas gym dalam bentuk tabel yang rapi. Pertama, program mencetak header tabel dengan kolom "No" dan "Nama Fasilitas". Jika daftar fasilitasGym kosong, akan ditampilkan baris khusus dengan keterangan "(kosong)". Jika ada data, program melakukan perulangan menggunakan for untuk mencetak setiap fasilitas beserta nomor urutnya. Format keluaran diatur menggunakan System.out.printf agar tampilan tabel rata dan sejajar. Setelah semua data ditampilkan, tabel ditutup dengan garis bawah sebagai penutup.

## Penjelasan Output
### <img width="366" height="190" alt="image" src="https://github.com/user-attachments/assets/4acb543a-22d3-4f55-91cd-d1db96ef850d" />
Output menu pertama akan ad 5 pilihan yaitu tambah fasilitas,lihat fasilitas,ubah fasilitas,hapus fasilitas dan keluar

### <img width="541" height="368" alt="image" src="https://github.com/user-attachments/assets/8688f9bd-649b-49f3-a8f8-80ef2f9694ea" />
Output pilihan 1 akan memunculkan fasilitas yang tersedia lalu akan meminta fasilitas apa yg ingin ditambahkan, jika sudah ditambahkan maka program akan memanggil lagi tabel fasilitas yang tersedia

### <img width="457" height="229" alt="image" src="https://github.com/user-attachments/assets/4cde293f-d5df-4d3b-95e3-8f5c212b7934" />
Output pilihan 2 akan memperlihatkan fasilitas yang tersedia

### <img width="478" height="523" alt="image" src="https://github.com/user-attachments/assets/bf52ee36-9d00-4611-ac78-69385787a8e8" />
Output pilihan 3 akan memperlihatkan fasilitas yang tersedia lalu meminta id fasilitas yang ingin diubah,jika sudah diubah maka program akan memanggil lagi tabel fasilitas yang tersedia dan fasilitas telah diubah

### <img width="458" height="435" alt="image" src="https://github.com/user-attachments/assets/af9e62b2-c810-4c80-80e1-8eaa69476abc" />
Output pilihan 4 akan memperlihatkan fasilitas yang tersedia lalu meminta id fasilitas yang ingin dihapus,jika sudah dihapus maka program akan memanggil lagi tabel fasilitas yang tersedia dan fasilitas telah dihapus

### <img width="430" height="229" alt="image" src="https://github.com/user-attachments/assets/6b5e2a2a-748d-4081-9b96-b6eb24707189" />
Output pilihan 5 maka akan keluar dari program

### <img width="336" height="222" alt="image" src="https://github.com/user-attachments/assets/2d129782-ad39-417c-8e13-ebe761b7b0d1" />
Output jika memilih angka yang tidak ada di dalam program maka pilihan tidak valid dan kembali lagi ke menu



