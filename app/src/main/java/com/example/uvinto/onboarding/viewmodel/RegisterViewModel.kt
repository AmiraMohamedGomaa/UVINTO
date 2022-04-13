package com.example.retrofitkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uvinto.onboarding.models.UserData
import com.example.uvinto.onboarding.models.UserResponse
import com.example.uvinto.onboarding.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class RegisterViewModel(val repository: Repository) : ViewModel() {
    var registerResponse=MutableLiveData<Response<UserResponse>>()

    fun addRegisteredUser(userData: UserData){
        viewModelScope.launch {

            val response=repository.setRegisteredUser(userData)
            registerResponse.value=response
        }
    }
}