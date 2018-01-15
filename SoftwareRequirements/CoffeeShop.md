# Coffee Shop

Contoh *user requirements* untuk sebuah usaha *Coffee Shop*.

## Identifikasi stakeholder

2. Staff coffee shop, terdiri dari:

   * kasir
   * barista
   * manajemen
   
3. Pelanggan

## Identifikasi tujuan proyek

Membangun aplikasi *Point of Sale* (POS) untuk digunakan pada *Coffee Shop*. Aplikasi POS ini nantinya menjadi alat
pencatatan transaksi dan sebagai acuan dalam akuntibilitas operasional *Coffee Shop*.

## *Functional Requirement*

Fitur-fitur yang harus diimplementasikan pada aplikasi POS ini adalah:

1. Menerima orderan pelanggan dan mencatat transaksi pembayaran.
2. Mencetak faktur order dan pembayaran
3. Menampilkan catatan jumlah uang pada *cash register*

Setiap transaksi harus mencantumkan nama staff yang menerima orderan dan memproses pembayaran.

### Flow proses bisnis

1. Pelanggan datang ke *Coffee Shop* dan melakukan pemesanan terhadap staff di-counter.
2. Staff menginput pemesanan ke sistem dan kemudian mencetak faktur order dan pembayaran.
3. Pelanggan membayar pesanan dan staff memberikan uang kembalian (jika ada)
4. Pelanggan menunggu pesanan.

## *Non-Functional Requirements*

Aplikasi yang dikembangkan harus dapat digunakan dengan *touch screen* secara optimal.

## Design solusi

### Needs

1. Aplikasi Point of Sales (POS)

   * identifikasi staff (berarti ada sistem login/logout)
   * input order
   * cetak faktur order/pembayaran
   * Laporan tansaksi
   
2. Catatan jumlah uang pada cash register

   * Deposit (menambah uang ke cash register bukan melalui proses pembayaran)
   * Withdrawal (mengambil uang dari cash register)
   * Pergantian staff (cetak tanda serah terima)
   * Laporan jumlah uang beserta transaksi
   
### Features

1. Aplikasi Point of Sales (POS)

   * User management
   
     Untuk login/logout dan identifikasi staff yang melakukan transaksi.
     
     Fungsi untuk manajemen:
     
     - Menambahkan user baru
     - Menghapus/disable user (user tidak dapat login)
     - Mengganti password user (reset password)
     
   * Product management
   
     Untuk daftar produk yang dijual dan bisa diorder.
     
     - Menambahkan product baru
     - Mengupdate informasi product
     - Menghapus/mengnontaktifkan product
   
   * Order and Payment
   
     Menerima orderan dan menerima pembayaran.
     
     - Menerima pemesanan dari pelanggan
     - Menerima pembayaran dari pelanggan
     
   * Report
   
     Menampilkan daftar transaksi yang terjadi.
     
2. Catatan jumlah uang pada Cash Register

   * User management
   
     Untuk login/logout dan identifikasi staff yang melakukan transaksi.
     
   * Cash out/in
   
     Untuk melakukan deposit atau withdrawal dari cash register yang tidak berkaitan dengan transaksi penjualan.
     
   * Ganti shift
   
     Proses pergantian staff kasir.
     
   * Report
   
     Menampilkan jumlah uang dan transaksi.
     
Dokumen use case lihat di [Use Case Diagram](CoffeeShop-UseCase.md).
