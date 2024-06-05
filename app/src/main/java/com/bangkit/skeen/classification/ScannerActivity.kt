package com.bangkit.skeen.classification

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skeen.MainActivity
import com.bangkit.skeen.R
import java.io.IOException

class ScannerActivity : AppCompatActivity() {

    private lateinit var classifier: Classifier
    private lateinit var bitmap: Bitmap

    private val cameraRequestCode = 0
    private val galleryRequestCode = 2
    private val inputSize = 224
    private val modelPath = "model.tflite"
    private val labelPath = "label.txt"
    private val samplePath = "ic_virus.png"

    private lateinit var photoImageView: ImageView
    private lateinit var cameraButton: Button
    private lateinit var galleryButton: Button
    private lateinit var detectButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initClassifier()
        initViews()
        loadSampleImage()

        setupListeners()
    }

    private fun initClassifier() {
        classifier = Classifier(assets, modelPath, labelPath, inputSize)
    }

    private fun initViews() {
        photoImageView = findViewById(R.id.mPhotoImageView)
        cameraButton = findViewById(R.id.mCameraButton)
        galleryButton = findViewById(R.id.mGalleryButton)
        detectButton = findViewById(R.id.mDetectButton)
        resultTextView = findViewById(R.id.mResultTextView)
    }

    private fun loadSampleImage() {
        assets.open(samplePath).use {
            bitmap = BitmapFactory.decodeStream(it)
            bitmap = Bitmap.createScaledBitmap(bitmap, inputSize, inputSize, true)
            photoImageView.setImageBitmap(bitmap)
        }
    }

    private fun setupListeners() {
        findViewById<ImageView>(R.id.imageBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        cameraButton.setOnClickListener {
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(callCameraIntent, cameraRequestCode)
        }

        galleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, galleryRequestCode)
        }

        detectButton.setOnClickListener {
            val results = classifier.recognizeImage(bitmap).firstOrNull()
            resultTextView.text = "${results?.title}\nConfidence: ${results?.confidence}"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            cameraRequestCode -> handleCameraResult(resultCode, data)
            galleryRequestCode -> handleGalleryResult(resultCode, data)
            else -> Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()
        }
    }

    private fun handleCameraResult(resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            bitmap = data.extras!!.get("data") as Bitmap
            bitmap = scaleImage(bitmap)
            showToast("Image crop to: w=${bitmap.width} h=${bitmap.height}")
            photoImageView.setImageBitmap(bitmap)
            resultTextView.text = "Your photo image set now."
        } else {
            showToast("Camera cancel..")
        }
    }

    private fun handleGalleryResult(resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {
            val uri = data.data
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                bitmap = scaleImage(bitmap)
                photoImageView.setImageBitmap(bitmap)
                resultTextView.text = "Your photo image set now."
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            showToast("Gallery selection canceled")
        }
    }

    private fun scaleImage(bitmap: Bitmap): Bitmap {
        val scaleWidth = inputSize.toFloat() / bitmap.width
        val scaleHeight = inputSize.toFloat() / bitmap.height
        val matrix = Matrix().apply { postScale(scaleWidth, scaleHeight) }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM, 0, 20)
        toast.show()
    }
}
