package com.bangkit.skeen.skeencare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skeen.MainActivity
import com.bangkit.skeen.R

class SkeenCare : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DiseaseAdapter
    private lateinit var diseaseList: MutableList<Disease>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skeencare)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        findViewById<ImageView>(R.id.imageBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        diseaseList = mutableListOf(
            Disease(
                "Kutil",
                "Kutil merupakan gangguan yang terjadi pada kulit. Kondisi ini muncul karena ada penebalan lapisan luar kulit",
                R.drawable.kutil1,
                "Umumnya, kondisi ini terjadi akibat infeksi virus dan jenis yang" + " paling sering adalah human papilloma virus (HPV). Virus ini " + "memiliki banyak serotipe dengan jumlah lebih dari 150 jenis. " + "Dari 100 serotipe tersebut, hanya beberapa yang menyebabkan" + " kutil di bagian tubuh selain kelamin. Beberapa serotipe lain " + "menyebabkan kutil pada kelamin dan sebagian lain dapat membuat " + "kondisi serius, seperti kanker serviks. Virus ini menyebar " + "dengan cara kontak kulit dan paling sering menginfeksi " + "individu dengan sistem imun yang lemah. Seperti, anak-anak, lansia, atau seseorang yang mengidap masalah imunokompromais (HIV/AIDS, mengonsumsi kortikosteroid, dan diabetes mellitus).",
                "Kebanyakan orang yang memiliki risiko gangguan HPV di beberapa area tubuh untuk mengalami kutil. Namun, ada beberapa cara yang dapat dilakukan untuk menurunkan risiko masalah kulit ini dan mencegah penyebarannya pada orang lain. Ketahui beberapa cara pencegahannya, antara lain:\n" + "•\tHindari kontak dengan kutil (diri sendiri maupun orang lain).\n" + "•\tJaga kebersihan tangan.\n" + "•\tMemakai alas kaki di tempat umum.\n" + "•\tJaga tubuh agar tidak lembap.\n" + "•\tHindari menggaruknya.\n"
            ), Disease(
                "Bisul",
                "Bisul atau furunkel adalah benjolan merah pada kulit yang berisi nanah dan terasa nyeri.",
                R.drawable.bisul,
                "Penyebab utama bisul adalah infeksi bakteri Staphylococcus aureus pada folikel rambut. Pada beberapa orang, bakteri tersebut dapat ditemukan di kulit dan dalam lapisan hidung tanpa menimbulkan gangguan. Infeksi baru akan terjadi jika bakteri masuk ke folikel rambut akibat luka gores atau gigitan serangga.\n" + "Beberapa faktor yang diduga dapat meningkatkan risiko seseorang terkena bisul adalah:\n" + "•\tMelakukan kontak langsung dengan penderita bisul, misalnya karena tinggal serumah\n" + "•\tMemiliki daya tahan tubuh yang lemah, misalnya karena menderita HIV, menjalani kemoterapi, atau menderita diabetes\n" + "•\tMengalami masalah kulit, misalnya kulit berjerawat, eksim, atau scabies\n",
                "Bisul dapat dicegah dengan menjaga kebersihan diri. Berikut adalah beberapa cara yang bisa diterapkan:\n" + "•\tMandi dan cuci tangan secara teratur dengan sabun dan air mengalir\n" + "•\tMembersihkan dan merawat luka dengan benar, bila mengalami luka goresan, luka robek, atau luka potong.\n" + "•\tTidak berbagi penggunaan barang pribadi dengan orang lain, misalnya handuk, alat cukur, atau pakaian\n"
            ), Disease(
                "Cacar Air",
                "Cacar air adalah infeksi yang disebabkan oleh virus Varicella-zoster.",
                R.drawable.cacarairr,
                "Penyebab utama cacar air adalah infeksi virus Varicella zoster. Virus tersebut dapat menyebar melalui kontak langsung dengan ruam. Selain itu, penularan virus Varicella zoster juga dapat menyebar ketika seseorang dengan cacar air batuk atau bersin dan terhirup oleh seseorang melalui droplet di udara. Jika seseorang tertular, maka infeksi akan dimulai dengan munculnya ruam. Kemudian, ruam tersebut berubah menjadi bintil merah berisi cairan yang terasa gatal, dan mengering dalam jangka waktu tertentu. Bintil tersebut kemudian menjadi koreng dan terkelupas dalam waktu 7 hingga 14 hari.",
                "Cacar air dapat dicegah dengan melakukan vaksinasi. Vaksinasi cacar air menjadi salah satu langkah preventif yang paling efektif. Jika terkena, gejala yang dialami tidak akan parah dan mencegah munculnya komplikasi yang bisa saja membahayakan kesehatan anak. Penularan penyakit tersebut terjadi sangat mudah dan cepat. Jika anak adalah pengidap, isolasi di rumah selama 1 minggu ke depan, terutama 1–2 hari sebelum kemunculan ruam. Jika anak berinteraksi dengan pengidap, periksakan diri ke dokter untuk mendapatkan perawatan yang dibutuhkan."
            ), Disease(
                "Campak",
                "Campak adalah penyakit infeksi saluran pernapasan yang sangat menular. Penyakit ini ditandai dengan ruam kulit di seluruh tubuh dan gejala seperti flu.",
                R.drawable.campak,
                "Campak disebabkan oleh virus rubeola dari genus Morbillivirus dalam keluarga Paramyxoviridae. Penyakit ini menyebar melalui kontak langsung atau tetesan udara dari orang yang terinfeksi. Virus masuk melalui mulut, hidung, atau mata, lalu memasuki paru-paru dan menginfeksi sel kekebalan. Sel kekebalan yang terinfeksi berpindah ke kelenjar getah bening, kemudian menyebar ke seluruh tubuh melalui darah, mencapai organ seperti hati, kulit, sistem saraf pusat, dan limpa. Di kulit, virus menyebabkan peradangan pada pembuluh kapiler, menghasilkan ruam khas campak. Gejala muncul dalam 6 hingga 21 hari setelah infeksi. Campak menular dari empat hari sebelum hingga empat hari setelah ruam muncul.",
                "Campak juga dikenal dengan rubeola. Saat ini telah tersedia vaksin untuk mencegah penyakit ini. Vaksin untuk penyakit ini termasuk dalam bagian dari vaksin MMR. Vaksinasi MMR adalah vaksin gabungan untuk campak, gondongan, dan rubella. Vaksinasi MMR diberikan dua kali. Pertama, diberikan ketika Si Kecil berusia 15 bulan dan dosis vaksin MMR berikutnya diberikan saat mereka berusia 5–6 tahun atau sebelum memasuki masa sekolah dasar. Vaksin memiliki fungsi yang cukup penting dalam mencegah campak. Bagaimana cara kerja vaksin campak? Saat kamu mendapatkan vaksin campak, sistem kekebalan akan membuat antibodi pelindung terhadap virus vaksin yang dilemahkan. Dengan begitu, jika suatu saat kamu terinfeksi virus penyebab campak, sistem kekebalan tubuh dapat melawan serangan virus tersebut."
            ), Disease(
                "Eksim",
                "Eksim adalah istilah terkait gangguan pembengkakan pada kulit. Gangguan ini disebut juga dengan dermatitis.",
                R.drawable.eksim,
                "Eksim dapat disebabkan oleh faktor dari luar (eksogen), seperti bahan kimia, mikroorganisme (bakteri, jamur). Selain itu, masalah ini juga bisa disebabkan oleh pengaruh dari dalam (endogen), seperti eksim atopik. Sebagian lainnya belum diketahui secara pasti, terutama yang berhubungan dengan endogen.",
                "Pencegahan pada eksim umumnya dilakukan dengan melakukan perawatan kulit yang benar. Pastikan untuk menghindari kulit yang terlalu kering atau terlalu basah. Jaga kelembapan kulit serta hindari keringat yang berlebih. \n" + "•\tHindari menggunakan bahan yang menimbulkan rasa gatal, seperti wol.\n" + "•\tJangan gunakan sabun dan detergen dengan kandungan yang keras.\n" + "•\tPastikan untuk menggunakan pelembap udara di kamar tidur.\n" + "•\tKurangi pikiran yang menyebabkan stres.\n" + "•\tSebaiknya hindari untuk mengonsumsi makanan pemicu alergi dan pemicu iritasi.\n" + "•\tCegah perubahan suhu dan kelembapan kulit yang ekstrim.\n" + "•\tHindari mandi menggunakan air yang terlalu panas.\n" + "•\tJangan memanaskan dan mendinginkan kulit secara berlebih.\n" + "•\tGunakan pelindung ketika bersentuhan dengan detergen atau bahan kimia lainnya.\n"
            ), Disease(
                "Herpes",
                "Herpes adalah penyakit yang ditandai dengan munculnya lepuhan berwarna kemerahan dan berisi cairan pada kulit.",
                R.drawable.herpes,
                "Herpes disebabkan oleh virus herpes simpleks tipe I (HSV-1) dan II (HSV-2), serta virus varicella zoster.\n" + "HSV-1:\n" + "Penyebab: Virus herpes simpleks tipe 1. Penularan: Kontak mulut ke mulut, seks oral, berciuman, dan kontak kulit. Menyebabkan: Herpes oral (di sekitar mulut), kadang herpes genital.\n" + "HSV-2:\n" + "Penyebab: Virus herpes simpleks tipe 2. Penularan: Kontak seksual, berbagi mainan seks, dan kontak langsung dengan luka herpes atau cairan tubuh. Menyebabkan: Herpes genital, kadang herpes oral.\n" + "Varicella zoster (herpes zoster):\n" + "Penyebab: Virus varicella zoster, penyebab cacar air di masa kanak-kanak. Penularan: Kontak dengan vesikel atau cairan di dalamnya, air liur pengidap. Menyebabkan: Herpes zoster (shingles), sering terjadi jika sistem kekebalan tubuh menurun.\n" + "\n",
                "Satu-satunya cara untuk sepenuhnya menghindari infeksi virus ini adalah menghindari penyebab penyakit herpes yakni dengan tidak melakukan hubungan seksual dengan pengidapnya. Jika aktif secara seksual, kamu dapat melakukan hal-hal berikut untuk menurunkan kemungkinan terinfeksi virus:\n" + "\n" + "•\tBertahan dalam satu hubungan jangka panjang.\n" + "•\tMenggunakan kondom.\n" + "•\tJangan berhubungan intim dengan orang yang memiliki luka kelamin.\n" + "•\tTerbuka terhadap pasangan.\n" + "•\tJangan berciuman atau melakukan sex oral dengan pasangan yang terinfeksi.\n"
            ), Disease(
                "Jerawat",
                "Jerawat adalah kondisi kulit yang umum terjadi ketika folikel rambut di kulit tersumbat oleh minyak dan sel kulit mati.",
                R.drawable.jerawat,
                "Beberapa kondisi yang memicu munculnya kondisi ini, antara lain:\n" + "•\tProduksi sebum berlebih: Kelenjar minyak menghasilkan sebum yang berlebihan untuk mencegah kulit kering.\n" + "•\tSumbatan folikel rambut: Campuran sel kulit mati dan sebum menyumbat folikel rambut.\n" + "•\tBakteri Propionibacterium acnes: Bakteri ini berkembang dalam folikel yang tersumbat dan menyebabkan peradangan.\n" + "•\tFaktor genetik: Masalah jerawat bisa diwariskan dari orangtua.\n" + "•\tFolikel tersumbat: Paparan udara luar dapat mengubah folikel yang tersumbat menjadi komedo putih atau hitam, yang dapat berkembang menjadi pustula, papula, nodul, atau kista jika terkontaminasi bakteri.\n" + "•\tHormon: Perubahan hormon, terutama hormon androgen, dan selama menstruasi dapat memicu jerawat.\n" + "•\tKosmetik: Penggunaan kosmetik yang tidak cocok bisa menyebabkan jerawat.\n" + "•\tStres: Stres dapat mempengaruhi pola makan dan gaya hidup yang memicu jerawat.\n",
                "Ada beberapa tips yang bisa kamu coba untuk mencegah timbulnya masalah kulit ini, yaitu:\n" + "1. Rutin membersihkan wajah\n" + "2. Hidrasi tubuh dengan baik\n" + "3. Batasi penggunaan riasan wajah\n" + "4. Hindari menyentuh wajah sembarangan\n" + "5. Hindari paparan sinar matahari langsung\n" + "6. Cermat dalam memilih produk sampo yang digunakan\n" + "7. Pola makan sehat\n"
            ), Disease(
                "Kangker Kulit",
                "Kanker kulit diduga kuat disebabkan oleh paparan sinar ultraviolet dari matahari.",
                R.drawable.kangkerkulit,
                "Kanker kulit disebabkan oleh mutasi genetik pada sel kulit, sering akibat paparan sinar ultraviolet (UV) dari matahari. Faktor yang meningkatkan risiko kanker kulit meliputi:\n" + "\n" + "Faktor internal:\n" + "\n" + "Riwayat kanker kulit: Risiko tinggi bagi mereka yang pernah atau memiliki anggota keluarga dengan riwayat kanker kulit.\n" + "Kulit putih: Orang berkulit putih memiliki lebih sedikit melanin, sehingga perlindungan terhadap sinar UV lebih lemah.\n" + "Tahi lalat: Banyak tahi lalat atau tahi lalat besar meningkatkan risiko.\n" + "Sistem kekebalan tubuh lemah: Penderita HIV/AIDS atau pengguna obat imunosupresif berisiko tinggi.\n" + "Solar keratosis: Bercak kasar dan bersisik akibat sinar matahari, berpotensi menjadi kanker.\n" + "Faktor eksternal:\n" + "\n" + "Paparan sinar matahari: Sering terpapar sinar matahari tanpa perlindungan tabir surya, terutama di daerah tropis atau dataran tinggi.\n" + "Paparan radiasi: Radioterapi untuk eksim atopik atau jerawat meningkatkan risiko karsinoma sel basal.\n" + "Paparan bahan kimia: Bahan karsinogenik, seperti arsenik, meningkatkan risiko kanker kulit.",
                "Cara terbaik untuk mencegah kanker kulit adalah melindungi kulit dari paparan sinar matahari atau sumber sinar ultraviolet (UV) yang lain, seperti alat penggelap (tanning) kulit. Upaya yang dapat dilakukan antara lain:\n" + "\n" + "Hindari sinar matahari pada siang hari, karena paparan terkuat sinar UV dari matahari berlangsung pada jam 10 pagi hingga 4 sore.\n" + "Gunakan tabir surya secara rutin, untuk mencegah penyerapan sinar UV ke dalam kulit dan mengurangi risiko kerusakan kulit akibat sinar matahari.\n" + "Kenakan pakaian yang menutupi tubuh, seperti baju lengan panjang dan celana panjang, untuk melindungi kulit dari sinar matahari.\n" + "Gunakan pula topi dan kacamata hitam saat keluar rumah, untuk memberikan perlindungan lebih terhadap kepala dan mata dari radiasi sinar matahari."
            ), Disease(
                "Kudis",
                "Kudis atau scabies merupakan penyakit yang mudah menular, baik melalui kontak langsung maupun tidak langsung.",
                R.drawable.kudis,
                "Kudis disebabkan oleh tungau Sarcoptes scabiei, yang mengeluarkan air liur, telur, dan kotoran, memicu respons imun yang menyebabkan gatal.\n" + "\n" + "Siklus perkembangan tungau:\n" + "\n" + "Masuknya tungau betina: Tungau betina masuk ke kulit manusia dan membuat terowongan sebagai sarang.\n" + "Perkawinan: Tungau jantan masuk ke sarang untuk kawin dengan tungau betina, kemudian mati.\n" + "Bertelur: Tungau betina bertelur di dalam sarang. Telur menetas setelah 3–4 hari.\n" + "Pertumbuhan tungau muda: Tungau muda keluar ke permukaan kulit selama 1–2 minggu hingga menjadi dewasa.\n" + "Siklus berulang: Tungau jantan menetap di permukaan kulit, sedangkan tungau betina kembali masuk ke kulit untuk membuat sarang baru dan mengulang siklus.\n" + "Tungau kudis tinggal di lapisan kulit yang dalam, membuatnya kebal terhadap sabun dan air panas. Tanpa penanganan tepat, siklus perkembangan tungau akan terus berlanjut.",
                "Cara paling ampuh untuk mencegah kudis adalah dengan menjaga diri agar tidak terpapar tungau Sarcoptes scabiei, baik melalui kontak langsung maupun tidak langsung. Jika Anda baru kontak dekat dengan penderita kudis, sebaiknya lakukan pemeriksaan agar segera mendapat penanganan.\n" + "\n" + "Sedangkan bagi penderita kudis, upaya yang dapat dilakukan untuk menghindari penyebaran scabies pada orang lain adalah:\n" + "\n" + "Bersihkan sprei, pakaian, handuk, dan barang pribadi lainnya menggunakan sabun dan air hangat, kemudian keringkan di udara yang panas atau di bawah terik matahari selama sekitar 1 hari.\n" + "Bungkus barang yang berpotensi terpapar tungau tetapi tidak bisa dicuci dengan plastik, kemudian letakkan di tempat yang jauh dari jangkauan.\n" + "Jangan berhubungan seksual atau melakukan kontak fisik erat dengan orang lain sampai perawatan scabies tuntas."
            ), Disease(
                "Kurap",
                "Kurap adalah infeksi jamur pada kulit yang menimbulkan ruam melingkar berwarna merah.",
                R.drawable.kurap,
                "Kurap disebabkan oleh infeksi jamur pada kulit. Jamur ini dapat menular melalui kontak langsung dengan penderita atau kontak tidak langsung dengan benda atau tanah yang terkontaminasi.\n" + "\n" + "Udara panas dan lembap, berbagi pemakaian barang pribadi, dan memakai pakaian yang ketat bisa membuat seseorang lebih rentan terkena kurap.\n" + "\n" + "Kurap ditandai dengan munculnya ruam bersisik berwarna kemerahan di permukaan kulit.Ruam kulit ini dapat meluas. Meski demikian, gejala kurap dapat berbeda-beda pada tiap orang, tergantung pada lokasi kurap.",
                "dicegah dengan menjaga kebersihan. Di samping itu, hindari berbagi pemakaian barang pribadi dengan orang lain, serta mandi, cuci rambut, dan ganti baju setiap hari atau segera setelah berkeringat."
            ), Disease(
                "Molluscum",
                "Moluskum kontagiosum adalah infeksi virus yang menyebabkan tumbuhnya bintil di kulit.",
                R.drawable.molluscum,
                "Moluskum kontagiosum disebabkan oleh virus Molluscum contagiosum. Seseorang dapat tertular virus ini bila bersentuhan langsung dengan kulit penderita.\n" + "Penularan juga bisa terjadi akibat menyentuh atau memakai barang yang digunakan oleh penderita, misalnya pakaian atau handuk. Moluskum kontagiosum juga dapat menular melalui hubungan seks.\n" + "\n" + "Virus ini juga dapat menginfeksi area tubuh lain, ketika seseorang menggaruk bintil kemudian menyentuh bagian tubuh lain. Akibatnya, akan muncul bintil baru di bagian tubuh yang disentuh tadi.",
                "Moluskum kontagiosum dapat menyebar ke area tubuh lain dan ke orang lain. Oleh karena itu, penting untuk mengetahui cara mencegah penularannya, yaitu dengan:\n" + "\n" + "Hindari menyentuh, menggaruk, atau memencet bintil.\n" + "Rajin mencuci tangan, terutama bila tidak sengaja menyentuh bintil.\n" + "Selalu tutupi bintil dengan pakaian, atau dengan perban bila perlu.\n" + "Hindari berbagi penggunaan barang pribadi, seperti pakaian, handuk, dan sisir.\n" + "Hindari berhubungan seksual, terutama bila terdapat bintil yang tumbuh di kelamin atau area sekitarnya."
            ), Disease(
                "Panu",
                "Panu adalah infeksi jamur pada kulit yang terbilang sangat umum. Pada sebagian besar kasus, panu atau tinea versicolor lebih sering menyerang remaja dan usia muda. ",
                R.drawable.panu,
                "Penyebab utama panu adalah perkembangan jamur malassezia pada kulit. Jamur penyebab panu bisa ditemukan pada kulit yang sehat, dan merupakan flora yang normal.\n" + "\n" + "Jamur ini baru akan menyebabkan masalah saat tumbuh secara abnormal. Misalnya, dipicu karena lemahnya sistem kekebalan tubuh atau perubahan hormon. ",
                "Cara mencegah panu paling utama adalah menjaga kebersihan kulit agar tidak lembap dan memperkuat sistem kekebalan tubuh.\n" + "\n" + "Untuk membantu mencegah tinea versikolor kembali, dokter dapat meresepkan perawatan kulit atau mulut yang digunakan satu atau dua kali sebulan. "
            ), Disease(
                "Kusta",
                "Kusta atau lepra adalah penyakit infeksi bakteri kronis yang menyerang jaringan kulit, saraf tepi, dan saluran pernapasan.",
                R.drawable.kusta,
                "Kusta atau lepra disebabkan oleh infeksi bakteri Mycobacterium leprae. Bakteri ini dapat menular dari satu orang ke orang lainnya melalui percikan cairan dari saluran pernapasan (droplet), yaitu ludah atau dahak, yang keluar saat batuk atau bersin.\n" + "\n" + "Seseorang dapat tertular kusta jika terkena percikan droplet dari penderitanya secara terus-menerus dalam waktu yang lama. Dengan kata lain, bakteri penyebab lepra tidak dapat menular kepada orang lain dengan mudah. Selain itu, bakteri ini juga membutuhkan waktu lama untuk berkembang biak di dalam tubuh penderita.\n" + "\n" + "Perlu dicatat, kusta bisa menular jika terjadi kontak dalam waktu yang lama. Kusta tidak akan menular hanya karena bersalaman, duduk bersama, atau berhubungan seksual dengan penderita. Kusta juga tidak menular dari ibu ke janinnya.\n" + "\n" + "Selain penyebab di atas, ada beberapa faktor lain yang bisa meningkatkan risiko seseorang terkena kusta, di antaranya:\n" + "\n" + "Bersentuhan dengan hewan penyebar bakteri kusta, seperti armadillo\n" + "Menetap atau berkunjung ke kawasan endemik kusta\n" + "Memiliki gangguan sistem kekebalan tubuh",
                "Sampai saat ini, belum ada vaksin untuk mencegah kusta. Diagnosis dini dan pengobatan yang tepat merupakan upaya terbaik untuk mencegah komplikasi dan penularan kusta. Selain itu, menghindari kontak dengan hewan pembawa bakteri kusta juga penting untuk mencegah kusta.\n" + "\n" + "Gerakan terpadu untuk memberikan informasi mengenai penyakit kusta kepada masyarakat, terutama di daerah endemik, merupakan langkah penting agar para penderita mau memeriksakan diri dan mendapatkan pengobatan.\n" + "\n" + "Pemberian informasi ini juga diharapkan dapat menghilangkan stigma negatif tentang kusta dan diskriminasi terhadap penderita kusta."
            )
        )

        adapter = DiseaseAdapter(this, diseaseList)
        recyclerView.adapter = adapter

    }
}