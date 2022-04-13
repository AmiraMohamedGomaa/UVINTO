package com.example.uvinto.onboarding.models

data class UserData(
    val first_name:String,
    val last_name:String,
    val email:String,
    val password:String,
    val password_confirmation:String,
    val device_type:String,

    )