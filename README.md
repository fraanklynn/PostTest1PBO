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
            

Potongan kode tersebut mendefinisikan method utama main sebagai titik awal program, lalu membuat sebuah ArrayList bertipe String bernama fasilitasGym untuk menyimpan daftar fasilitas gym, kemudian mendeklarasikan Scanner bernama menu dengan mekanisme try-with-resources agar dapat menerima input dari keyboard secara aman, serta menyiapkan variabel pilihan bertipe integer untuk menampung input menu yang dipilih pengguna.

