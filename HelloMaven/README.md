# Pengenalan

Pengenalan build system Maven.

Build system yang populer digunakan pada komunitas Java. Untuk menggunakan build system ini kita memerlukan koneksi aktif ke internet karena Maven akan mendownload paket-paket dari repository di Internet.

Untuk menggunakan Maven pada saat membuat project di Netbeans pilih category Maven.

Pada saat membuat project Maven ada beberapa isian yang perlu diisikan:
1. Project Name: nama project yang akan dibuat
2. Artifact Id: mengikuti nama project name
3. Group Id: nama group project dan organisasi. dalam format alamat web yang ditulis dari belakang ke depan. misalnya untuk organisasi UPH kelas IS17 dan group project pengembangan-aplikasi, nama group Id bisa ditulis menjadi: uph.is17.pengembangan-aplikasi
4. Package: otomatis diisikan dengan group id + artifact id. misalnya: uph.is17.pengembangan-aplikasi.hellomaven

## Struktur directory

Struktur directory default project ANT Netbeans:

- pom.xml

  deskripsi build Maven

- src

  source code

- nbactions.xml

  Konfigurasi netbeans

- target

  file hasil build (JAR/WAR) dan file paket lain yang dibutuhkan pada saat build (boleh tidak disertakan pada saat distribusi code)

## Menentukan mainClass pada saat build JAR

1. Buka file `pom.xml`
2. Tambahkan code di bawah ini di antara tag `<project>...</project>`.

```XML
<build>
    <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
          <configuration>
              <archive>
                  <manifest>
                      <mainClass>your.main.class.here</mainClass>
                  </manifest>
              </archive>
          </configuration>
      </plugin>
  </plugins>
</build>
```

3. Ganti isian `mainClass` dengan nama lengkap class utama misalnya `uph.is17.pengembanganaplikasi.hellomaven.HelloWorld`
4. Build untuk membangun ulang target JAR