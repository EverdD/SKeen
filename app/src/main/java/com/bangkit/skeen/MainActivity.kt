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
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var user: FirebaseUser

    private lateinit var auth: FirebaseAuth

    private lateinit var textView: TextView

    private lateinit var txtLogout: TextView

    private lateinit var cvScanner: CardView

    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        txtLogout = findViewById(R.id.tv_logout)
        textView = findViewById(R.id.tv_user)
        cvScanner = findViewById(R.id.cv_scanner)
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

        txtLogout.setOnClickListener {
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

        val imageList = listOf(
            R.drawable.banner_skin1,
            R.drawable.banner_skin2
        )
        val adapter = ImagePagerAdapter(imageList)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.customView = layoutInflater.inflate(R.layout.custom_tab, null)
        }.attach()
    }
}