package com.bangkit.skeen

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.skeen.auth.LoginActivity
import com.bangkit.skeen.classification.ScannerActivity
import com.bangkit.skeen.skeencare.SkeenCare
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var user: FirebaseUser

    private lateinit var auth: FirebaseAuth

    private lateinit var textView: TextView

    private lateinit var cvLogout: CardView
    private lateinit var cvScanner: CardView
    private lateinit var cvSkeenCare: CardView

    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        cvLogout = findViewById(R.id.cv_logout)
        textView = findViewById(R.id.tv_user)
        cvScanner = findViewById(R.id.cv_scanner)
        cvSkeenCare = findViewById(R.id.cv_skeencare)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        user = auth.currentUser!!
        if (user == null) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            textView.text = user.email
        }

        cvLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        cvScanner.setOnClickListener {
            val intent = Intent(applicationContext, ScannerActivity::class.java)
            startActivity(intent)
            finish()
        }

        cvSkeenCare.setOnClickListener {
            val intent = Intent(applicationContext, SkeenCare::class.java)
            startActivity(intent)
        }

        val imageList = listOf(
            R.drawable.banner_skin1,
            R.drawable.banner_skin2,
            R.drawable.banner_skin3,

        )
        val adapter = ImagePagerAdapter(imageList)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.customView = layoutInflater.inflate(R.layout.custom_tab, null)
        }.attach()
    }
}