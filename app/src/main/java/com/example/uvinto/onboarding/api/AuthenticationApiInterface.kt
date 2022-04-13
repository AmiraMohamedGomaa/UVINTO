package com.example.uvinto.onboarding.api


import com.example.uvinto.onboarding.models.UserData
import com.example.uvinto.onboarding.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApiInterface {

    @Headers(
        "Accept: application/json",
        "Accept-Language: ar",
        "api-password: j3I6ZIGgacWTQYhaQs="
    )
    @POST("api/v1/users/register")
    suspend fun setRegisteredUser(@Body userData : UserData):Response<UserResponse>


}