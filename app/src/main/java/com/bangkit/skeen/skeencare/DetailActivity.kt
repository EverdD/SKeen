package com.bangkit.skeen.skeencare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bangkit.skeen.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nameTextView: TextView = findViewById(R.id.tvDiseaseName)
        val descriptionTextView: TextView = findViewById(R.id.tvDiseaseDescription)
        val photoImageView: ImageView = findViewById(R.id.imgDiseasePhoto)
        val causesTextView: TextView = findViewById(R.id.tvDiseaseCauses)
        val preventionTextView: TextView = findViewById(R.id.tvDiseasePrevention)

        val diseaseName = intent.getStringExtra("DISEASE_NAME")
        val diseaseDescription = intent.getStringExtra("DISEASE_DESCRIPTION")
        val diseasePhoto = intent.getIntExtra("DISEASE_PHOTO", 0)
        val diseaseCauses = intent.getStringExtra("DISEASE_CAUSES")
        val diseasePrevention = intent.getStringExtra("DISEASE_PREVENTION")

        nameTextView.text = diseaseName
        descriptionTextView.text = diseaseDescription
        photoImageView.setImageResource(diseasePhoto)
        causesTextView.text = diseaseCauses
        preventionTextView.text = diseasePrevention
    }
}
