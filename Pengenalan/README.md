# Pengenalan

Pengenalan IDE (Netbeans) dan build system ANT.

Aplikasi Java biasanya dipaketkan menjadi paket JAR atau WAR.

Paket JAR (Java Archive) biasanya untuk aplikasi command line dan desktop sedangkan WAR (Web Archive) digunakan untuk memaketkan aplikasi web yang akan dijalankan pada web container seperti Tomcat atau lainnya.

IDE Netbeans secara default menggunakan ANT sebagai build system.

## Mebangun paket JAR/WAR

Pada project, klik kanan pilih `Build` atau `Clean and Build`

## Struktur directory

Struktur directory default project ANT Netbeans:

- build.xml

  deskripsi build ANT

- manifest.mf
 
  berisikan informasi aplikasi yang dipaketkan menjadi JAR/WAR

- nbproject/

  directory project netbeans, berisikan konfigurasi dan perintah build ANT

- src

  source code

- test

  source code test unit

- build

  berisikan hasil build (digunakan untuk mempercepat proses build berikutnya)

- dist

  berisikan binary JAR/WAR hasil build

Untuk distribusi code, directory `build` dan `dist` boleh tidak diikutkan karena dapat di-*generate* dari netbeans.

## Refactoring rename class

Langkah-langkah:
1. Klik kanan pada nama class misalnya pada `public class Pengenalan`
2. Pilih menu `Refactor`
3. Pilih `Rename` kemudian ganti menjadi nama lain misalnya `HelloWorld`
4. Klik tombol `Preview` untuk melihat apa saja yang akan berubah
5. Klik tombol `Refactor` untuk melakukan refactoring

## Mengganti mainClass yang akan dijalankan pada paket JAR

1. Klik kanan pada project, pilih `Properties`
2. Pilih category `Run` dan kemudian ganti isian `Main Class` sesuai dengan nama class utama yang akan dijalankan
3. Klik OK untuk menyimpan konfigurasi
4. Build ulang project untuk mendapatkan JAR dengan mainClass yang sesuai

## Melakukan debugging (melihat state)

1. Klik pada baris code dimana akan diletakkan break line (program akan di-*pause* pada baris ini) pada baris tersebut akan ada icon stop warna merah
2. Jalankan program dengan menggunakan tombol `debug project` (disebelah kanan tombol run)
3. Program akan berjalan seperti biasa. Pada baris yang telah ditandai pada langkah 1, program akan berhenti dan kita dapat melihat state aplikasi pada bagian bawah.
4. Klik tombol continue, step over, dll untuk melanjutkan aplikasi.