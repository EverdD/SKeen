package com.bangkit.skeen.api

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("userCredential") val userCredential: UserCredential
)
data class UserCredential(
    @SerializedName("user") val user: User
)
data class User(
    @SerializedName("stsTokenManager") val stsTokenManager: StsTokenManager,
    @SerializedName("email") val email: String
)
data class StsTokenManager(
    @SerializedName("accessToken") val accessToken: String
)

data class PostResponse(
    @SerializedName("error") val error: Boolean,
    @SerializedName("message") val message: String
)