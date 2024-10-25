import java.util.HashMap;
import java.util.Scanner;

public class ManajemenStokToko01 {
    private static class Barang {
        String nama;
        int jumlahStok;
        double hargaPerUnit;

        Barang(String nama, int jumlahStok, double hargaPerUnit) {
            this.nama = nama;
            this.jumlahStok = jumlahStok;
            this.hargaPerUnit = hargaPerUnit;
        }

        double totalNilai() {
            return jumlahStok * hargaPerUnit;
        }

        boolean bisaDipenuhi(int permintaan) {
            return permintaan <= jumlahStok;
        }

        void kurangiStok(int jumlah) {
            jumlahStok -= jumlah;
        }
    }

    private static HashMap<String, Barang> daftarBarang = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Masukkan nama barang (ketik 'selesai' untuk keluar): ");
            String namaBarang = scanner.nextLine();
            if (namaBarang.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan jumlah stok: ");
            int jumlahStok = scanner.nextInt();

            System.out.print("Masukkan harga per unit: ");
            double hargaPerUnit = scanner.nextDouble();
            scanner.nextLine(); 

            Barang barang = new Barang(namaBarang, jumlahStok, hargaPerUnit);
            daftarBarang.put(namaBarang, barang);

            System.out.println("Total nilai stok " + namaBarang + ": " + barang.totalNilai());

            System.out.print("Masukkan jumlah permintaan barang: ");
            int permintaan = scanner.nextInt();
            scanner.nextLine(); 

            if (barang.bisaDipenuhi(permintaan)) {
                barang.kurangiStok(permintaan);
                System.out.println("Permintaan dapat dipenuhi. Stok sekarang: " + barang.jumlahStok);
            } else {
                System.out.println("Stok tidak mencukupi! Stok tersedia: " + barang.jumlahStok);
            }
        }

        System.out.println("\nInformasi Stok Barang:");
        for (Barang barang : daftarBarang.values()) {
            System.out.println("Nama: " + barang.nama + ", Stok: " + barang.jumlahStok + ", Total Nilai: " + barang.totalNilai());
        }
        
    }
}