package com.bangkit.skeen.auth

import SessionManager
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skeen.MainActivity
import com.bangkit.skeen.R
import com.bangkit.skeen.api.ApiConfig
import com.bangkit.skeen.api.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLog: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = SessionManager(this)

        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.password)
        buttonLog = findViewById(R.id.btn_login)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.tv_register)

        textView.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonLog.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@LoginActivity, "Enter Email", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this@LoginActivity, "Enter Password", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
                return@setOnClickListener
            }

            val apiService = ApiConfig.getApiService()
            val loginRequest = LoginRequest(email, password)
            val call = apiService.postLogin(loginRequest)
            call.enqueue(object : Callback<AuthResponse> {
                override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val authResponse = response.body()
                        Log.d("Auth Response", authResponse.toString())
                        if (authResponse != null && !authResponse.error) {
                            Log.d("LoginActivity", "Token received: ${authResponse.userCredential.user.stsTokenManager.accessToken}")
                            Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()

                            // Save email and token
                            sessionManager.saveUserEmail(email)
                            sessionManager.saveAuthToken(authResponse.userCredential.user.stsTokenManager.accessToken)

                            navigateToMainActivity()
                        } else {
                            Toast.makeText(this@LoginActivity, authResponse?.message ?: "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@LoginActivity, "Authentication failed. Error code: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
