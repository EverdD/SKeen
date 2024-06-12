package com.bangkit.skeen.api

import com.bangkit.skeen.auth.LoginRequest
import com.bangkit.skeen.auth.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    fun postRegister(
        @Body request: RegisterRequest
    ): Call<PostResponse>

    @POST("login")
    fun postLogin(
        @Body request: LoginRequest
    ): Call<AuthResponse>
}
