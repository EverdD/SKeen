package com.bangkit.skeen

import SessionManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var cvLogout: CardView
    private lateinit var cvScanner: CardView
    private lateinit var cvSkeenCare: CardView
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_user)
        cvLogout = findViewById(R.id.cv_logout)
        cvScanner = findViewById(R.id.cv_scanner)
        cvSkeenCare = findViewById(R.id.cv_skeencare)
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        sessionManager = SessionManager(this)

        val authToken = sessionManager.fetchAuthToken()
        val userEmail = sessionManager.fetchUserEmail()
        Log.d("MainActivity", "Fetched token: $authToken")
        Log.d("MainActivity", "Fetched email: $userEmail")

        if (authToken == null) {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            if (userEmail != null) {
                textView.text = "$userEmail"
            } else {
                textView.text = "user@bangkit.com"
            }

            cvLogout.setOnClickListener {
                sessionManager.clearAuthToken()
                sessionManager.clearUserEmail()
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            cvScanner.setOnClickListener {
                val intent = Intent(applicationContext, ScannerActivity::class.java)
                startActivity(intent)
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

            ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
                val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
                view.translationY = -imeInsets.bottom.toFloat()
                insets
            }
        }
    }
}
