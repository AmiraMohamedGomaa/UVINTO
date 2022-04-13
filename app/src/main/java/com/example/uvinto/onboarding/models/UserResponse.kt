package com.example.uvinto.onboarding.models

class UserResponse(
    val success:Boolean,
    val message: String,
    val errors:Error,
    val data:Data
)

class Error {
    val email: String?=null
    val password: String?=null
    val device_type: String?=null
}
class Data{
    val user:UserData? = null
}