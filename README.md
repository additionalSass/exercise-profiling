Minggu 5 

Test Plan 1 dalam JMeter untuk endpoint /all-student, 2 untuk endpoint /all-student-name, dan 3 untuk endpoint /highest-gpa. 

<img src="images-for-readme/test_plan_1_all-student_table_result.JPG" width="512" alt="test plan 1"/>
<img src="images-for-readme/test_plan_2_all-student-name_table_result.JPG" width="512" alt="test plan 2"/>
<img src="images-for-readme/test_plan_3_highest_gpa_table_result.JPG" width="512" alt="test plan 3"/>
<img src="images-for-readme/cmdl1.JPG" width="512" alt="test plan 1"/>
<img src="images-for-readme/cmdl2.JPG" width="512" alt="test plan 2"/>
<img src="images-for-readme/cmdl3.JPG" width="512" alt="test plan 3"/>
<img src="images-for-readme/jtl-results-1.JPG" width="512" alt="test plan 1"/>
<img src="images-for-readme/jtl-results-2.JPG" width="512" alt="test plan 2"/>
<img src="images-for-readme/jtl-results-3.JPG" width="512" alt="test plan 3"/>

Apakah ada peningkatan performa yang bisa diukur setelah mengoptimisasi kode untuk tiga method di service yang berkaitan dengan tiga endpoint? Iya. Ada.
<img src="images-for-readme/jtl-results-afteroptimized-1.JPG" width="512" alt="test plan 1 setelah refactor kode"/>
<img src="images-for-readme/jtl-results-afteroptimized-2.JPG" width="512" alt="test plan 2 setelah refactor kode"/>
<img src="images-for-readme/jtl-results-afteroptimized-3.JPG" width="512" alt="test plan 3 setelah refactor kode"/>
Dilihat dari file jtl, bisa dikatakan semuanya meningkat.
Dari 140 ribuan dalam elapsed time ms ke satu ribuan untuk endpoint pertama (/all-student)
Dari 4 ribuan dalam elapsed time ms ke puluhan untuk endpoint kedua (/all-student-name)
Dari range [34,99] ms dalam elapsed time ke [5,64] ms untuk endpoint ketiga (/highest-gpa)

Kemudian, ada juga hasil dari Profiler milik Intellij.
<img src="images-for-readme/findStudentWithHighestGpa-profiling-result-first.JPG" width="512" alt="highest gpa sebelum refactor kode"/>
<img src="images-for-readme/getAllStudents-profiling-result-first.JPG" width="512" alt="get all students sebelum refactor kode"/>
<img src="images-for-readme/joinStudentNames-profiling-result-first.JPG" width="512" alt="join student names sebelum refaktor kode"/>
<img src="images-for-readme/findStudentWithHighestGpa-profiling-result-optimized.JPG" width="512" alt="highest gpa setelah refactor kode"/>
<img src="images-for-readme/getAllStudents-profiling-result-afteroptimization1.JPG" width="512" alt="get all students setelah refactor kode"/>
<img src="images-for-readme/joinStudentNames-profiling-result-optimized.JPG" width="512" alt="join student names setelah refactor kode"/>

Dan enam hasil profiling di atas berbicara sendiri.

Secara umum, metode lama yang melibatkan pembuatan objek dalam Java inferior (dalam segi waktu eksekusi) dibandingkan dengan memanfaatkan @Query annotation di interfaca masing-masing repository dan memanggil method yang berkaitan dalam service! 

Untuk menjawab ketujuh pertanyaan:
1. JMeter digunakan untuk pengujian beban dan mengukur performance aplikasi secara menyeluruh, sedangkan IntelliJ Profiler digunakan membuat profil tingkat kode untuk mengidentifikasi masalah performance dalam method dan class tertentu.
2. Pembuatan profil membantu mengidentifikasi bottleneck performance dengan memberikan informasi terperinci tentang waktu eksekusi, beban CPU, dan konsumsi memori masing-masing method dan class dalam kode Java yang saya tulis.
3. Ya. IntelliJ Profiler alat yang baik untuk menganalisis dan mengidentifikasi masalah dalam kode java,  fitur seperti analisis tree call, sinkronisasi method, dan pelacakan memori jika ada penggunaan memori yang tidak wajar.
4. Tantangan pengujian performance dan pembuatan profil mencakup mereproduksi skenario yang sesuai, menangani data  jumlah besar dari database, serta menginterpretasikan hasil. Hal ini dapat diatasi dalam lingkungan teoritis yang ideal dengan menggunakan data pengujian yang realistis dan lengkap dan melakukan simulasi lingkungan produksi.
5. Manfaat menggunakan IntelliJ Profiler mencakup informasi performance terperinci, integrasi dengan IntelliJ IDE, representasi visual data performance, dan dukungan untuk berbagai mode pembuatan profil.
6. Jika hasil pembuatan profil tidak sesuai dengan hasil pengujian performance JMeter, analisis perbedaan tersebut dengan meninjau skenario yang sebanding, berpikir, melakukan pembuatan profil atau pengujian yang ditargetkan, dan bekerja sama dan bertanya kepada orang lain untuk menemukan solusi.
7. Setelah menganalisis hasil performance, strategi optimisasi mencakup meminimalkan pembuatan objek, mengoptimalkan pembuatan kueri database yang berdasarkan PostGRESQL.
