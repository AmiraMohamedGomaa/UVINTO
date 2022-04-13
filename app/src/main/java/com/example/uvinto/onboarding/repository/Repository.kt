package com.example.uvinto.onboarding.repository


import com.example.uvinto.onboarding.api.ApiResponse
import com.example.uvinto.onboarding.models.UserData
import com.example.uvinto.onboarding.models.UserResponse


class Repository {
    suspend fun setRegisteredUser(user: UserData): retrofit2.Response<UserResponse>{
        return ApiResponse.api.setRegisteredUser(user)
    }
}