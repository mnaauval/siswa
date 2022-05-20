package com.learn;
import java.util.ArrayList;
import java.util.Scanner;

class Siswa {
    int ID, bid, mtk, ipa, ips, bing, avg;
    String nama, kategori;

    public Siswa(int ID, String nama, int bid, int mtk, int ipa, int ips, int bing) {
        this.ID = ID;
        this.nama = nama;
        this.bid = bid;
        this.mtk = mtk;
        this.ipa = ipa;
        this.ips = ips;
        this.bing = bing;
    }

    int hitung_avg() {
        avg = (bid + mtk + ipa + ips + bing) / 5;
        return avg;
    }

    String kategori_avg() {
        if (avg > 90) {
            return kategori = "A";
        } else if (avg > 80 && avg <= 90) {
            return kategori = "B";
        } else if (avg > 60 && avg <= 80) {
            return kategori = "C";
        } else if (avg > 50 && avg <= 60) {
            return kategori = "D";
        } else {
            return kategori = "E";
        }
    }
}

public class Main {
    ArrayList<Siswa> siswa = new ArrayList<Siswa>();

    void addSiswa(Siswa siswaa) {
        siswa.add(siswaa);
    }

    void editSiswa(String name, Siswa s) {
        for(Siswa siswaa : siswa) {
            if(siswaa.nama.equals(name)) {
                siswa.set(siswa.indexOf(siswaa), s);
            }
        }
    }

    void searchSiswaByNama(String name) {
        for(Siswa siswaa : siswa) {
            if(siswaa.nama.equals(name)) {
                System.out.println("ID: " + siswaa.ID);
                System.out.println("Nama: " + siswaa.nama);
                System.out.println("Bidang: " + siswaa.bid);
                System.out.println("Matematika: " + siswaa.mtk);
                System.out.println("IPA: " + siswaa.ipa);
                System.out.println("IPS: " + siswaa.ips);
                System.out.println("Bing: " + siswaa.bing);
                System.out.println("Rata-rata: " + siswaa.hitung_avg());
                System.out.println("Kategori: " + siswaa.kategori_avg());
            } else {
                System.out.println("Nama tidak ditemukan");
            }
        }
    }

    void removeSiswa(String nama) {
        for(Siswa siswaa : siswa) {
            if(siswaa.nama.equals(nama)) {
                siswa.remove(siswaa);
            } else {
                System.out.println("Nama tidak ditemukan");
            }
        }
    }

    void showSiswa() {
        int lolos = 0;
        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("ID\tNama\t\tBId\tMTK\tIPA\tIPS\tBIng\tAVG\tKategori");
        System.out.println("------------------------------------------------------------------------------------");
        for(Siswa siswaa : siswa) {
            System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%d\t%d\t%s\n", siswaa.ID, siswaa.nama, siswaa.bid, siswaa.mtk, siswaa.ipa, siswaa.ips, siswaa.bing, siswaa.hitung_avg(), siswaa.kategori_avg());
        }
        System.out.println("------------------------------------------------------------------------------------");
        for(Siswa siswaa : siswa) {
            int standard = siswaa.hitung_avg() / siswa.size();
            if (siswaa.hitung_avg() > standard) {
                lolos++;
            }
        }
        System.out.printf("Siswa yang lolos standard : %d", lolos);
    }

    
    public static void main(String[] args) {
        int menu;
        int ID, bid, mtk, ipa, ips, bing;
        String nama, search_name;
        boolean loop = true;
        
        Main main = new Main();

        System.out.println("MENU DATA SISWA");
        System.out.println("1. Input Siswa (id, nama, BId, MTK, IPA, IPS, BIng");
        System.out.println("2. Edit Siswa (pilih nama data siapa yang akan diedit)");
        System.out.println("3. Cari Siswa (via nama)");
        System.out.println("4. Hapus Siswa (via nama)");
        System.out.println("5. Tampilkan Data Siswa (include Rata\" dan nilai konversi Huruf");
        System.out.println("6. Exit");

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n\nEnter menu id : ");
            menu = scanner.nextInt();
        
            switch (menu) {
                case 1:
                    // System.out.println("Input Siswa");
                    Scanner input = new Scanner(System.in);
                    System.out.print("\nEnter id : ");
                    ID = input.nextInt();

                    System.out.print("Enter nama : ");
                    nama = input.next();

                    System.out.print("Enter bid : ");
                    bid = input.nextInt();

                    System.out.print("Enter mtk : ");
                    mtk = input.nextInt();

                    System.out.print("Enter ipa : ");
                    ipa = input.nextInt();

                    System.out.print("Enter ips : ");
                    ips = input.nextInt();

                    System.out.print("Enter bing : ");
                    bing = input.nextInt();

                    main.addSiswa(new Siswa(ID, nama, bid, mtk, ipa, ips, bing));
                    break;
                case 2:
                    // System.out.println("Edit Siswa");
                    Scanner change = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("\n\nSearch name : ");
                    search_name = input2.next();

                    System.out.print("\nEnter id : ");
                    ID = change.nextInt();
        
                    System.out.print("Enter nama : ");
                    nama = change.next();
    
                    System.out.print("Enter bid : ");
                    bid = change.nextInt();
    
                    System.out.print("Enter mtk : ");
                    mtk = change.nextInt();
    
                    System.out.print("Enter ipa : ");
                    ipa = change.nextInt();
    
                    System.out.print("Enter ips : ");
                    ips = change.nextInt();
    
                    System.out.print("Enter bing : ");
                    bing = change.nextInt();

                    main.editSiswa(search_name, new Siswa(ID, nama, bid, mtk, ipa, ips, bing));
                    break;
                case 3:
                    // System.out.println("Cari Siswa");
                    Scanner search = new Scanner(System.in);
                    System.out.print("\n\nSearch name : ");
                    search_name = search.next();
        
                    main.searchSiswaByNama(search_name);
                    break;
                case 4:
                    // System.out.println("Hapus Siswa");
                    Scanner search2 = new Scanner(System.in);
                    System.out.print("\n\nSearch name : ");
                    search_name = search2.next();
        
                    main.removeSiswa(search_name);
                    break;
                case 5:
                    // System.out.println("Tampilkan Data Siswa");
                    main.showSiswa();
                    break;
                case 6:
                    // System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
                    break;
            }
        } while (menu !=6);
    }
}