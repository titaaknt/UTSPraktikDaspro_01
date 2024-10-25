import java.util.Scanner;

public class ManajemenNilaiSiswa01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNama;
        double totalNilai = 0;
        int jumlahSiswa = 0;
        int diAtasRataRata = 0;
        int diBawahRataRata = 0;

        double[] nilaiSiswa = new double[100]; 

        while (true) {
            System.out.print("Masukkan nama siswa (atau ketik 'selesai' untuk berhenti): ");
            inputNama = scanner.nextLine();
            
            if (inputNama.equalsIgnoreCase("selesai")) {
                break;
            }
            
            System.out.print("Masukkan nilai siswa: ");
            double nilai = scanner.nextDouble();
            scanner.nextLine(); 
            
            totalNilai += nilai;
            nilaiSiswa[jumlahSiswa] = nilai;
            jumlahSiswa++;
        }
        
        double rataRataNilai = totalNilai / jumlahSiswa;
        System.out.println("Rata-rata nilai kelas: " + rataRataNilai);
        
        
        for (int i = 0; i < jumlahSiswa; i++) {
            if (nilaiSiswa[i] > rataRataNilai) {
                diAtasRataRata++;
            } else if (nilaiSiswa[i] < rataRataNilai) {
                diBawahRataRata++;
            }
        }
        
        System.out.println("Jumlah siswa dengan nilai di atas rata-rata: " + diAtasRataRata);
        System.out.println("Jumlah siswa dengan nilai di bawah rata-rata: " + diBawahRataRata);
        
        if (diAtasRataRata > jumlahSiswa / 2) {
            System.out.println("Mayoritas siswa memiliki nilai di atas rata-rata.");
        } else {
            System.out.println("Mayoritas siswa tidak memiliki nilai di atas rata-rata.");
        }
        
    }
}