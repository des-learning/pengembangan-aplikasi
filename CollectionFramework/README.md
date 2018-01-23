# Collection Framework

Collection Framework di Java mempermudah pekerjaan programmer dalam memproses
kumpulan data.

Framework ini menyediakan:

1. Interface

   Operasi umum yang nantinya dapat dioperasikan pada koleksi data. Misalnya,
   `add` untuk menambah item data, `remove` untuk menghapus dan sebagainya.  
   Beberapa jenis interface collection yang tersedia:
   
   * List

     List mirip dengan array di Java. Item dapat ditambahkan pada posisi
     tertentu ke dalam list dan item data juga dapat diakses dari posisi index
     tertentu.

   * Set

     Menampung kumpulan data yang tidak boleh ada duplikat.

   * Queue

     Antrian, mirip dengan List. Bedanya antrian hanya dapat diakses dari
     element pertama atau ditambahkan data ke element paling akhir.

   * Deque (double ended queue)
     
     Antrian yang datanya bisa diakses dan ditambahkan dari element paling
     depan (pertama) atau dari paling belakang terakhir).

   * Map

     Mapping key value. Masing-masing item di-identifikasikan dengan menggunakan
     key dan masing-masing key cuma bisa memiliki 1 value. Nama lain dikenal
     juga sebagai Hash Table atau Dictionary.

2. Implementation

   Implementasi struktur data collection. Programmer dapat memilih struktur data
   yang paling sesuai dengan *use case* yang sedang dikembangkan.

   Misalnya untuk `List` programmer dapat memilih menggunakan `ArrayList` atau
   `LinkedList` atau yang lainnya sebagai *backing implementation*. Masing-masing
   implementation yang berbeda memiliki karakteristik operasional yang berbeda
   misalnya, operasi akses random pada `ArrayList` lebih efisien dibandingkan
   dengan `LinkedList`.

3. Algorithms

   Collection framework menyediakan algoritma untuk operasi-operasi umum
   misalnya untuk pengurutan dan pencarian.