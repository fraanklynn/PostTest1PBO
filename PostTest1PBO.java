
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> fasilitasGym = new ArrayList<>();
        try (Scanner menu = new Scanner(System.in)) {
            int pilihan;
            
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
                
                switch (pilihan) {
                    case 1 -> {
                        tampilkanFasilitas(fasilitasGym);
                        System.out.println("Masukkan fasilitas baru: ");
                        fasilitasGym.add(menu.nextLine());
                        System.out.println("Fasilitas berhasil ditambahkan!");
                        tampilkanFasilitas(fasilitasGym);
                    }
                        
                    case 2 -> tampilkanFasilitas(fasilitasGym);
                        
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
                        
                    case 5 -> System.out.println("Program Selesai. Terima kasih!");
                        
                    default -> System.out.println("Pilihan tidak valid!");
                        
                }
                
            } while (pilihan != 5);
        }
    }
    
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
}