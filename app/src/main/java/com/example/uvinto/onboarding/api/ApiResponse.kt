package com.example.uvinto.onboarding.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResponse {
   private val retrofit by lazy {
       Retrofit.Builder()
           .baseUrl("https://uivnto.herokuapp.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
   }

   val api:AuthenticationApiInterface by lazy {
        retrofit.create(AuthenticationApiInterface::class.java)
    }
}