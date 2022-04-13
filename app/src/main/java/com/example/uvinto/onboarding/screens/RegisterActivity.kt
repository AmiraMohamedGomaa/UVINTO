package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitkotlin.RegisterViewModel
import com.example.retrofitkotlin.RegisterViewModelFactory
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivityRegisterBinding
import com.example.uvinto.onboarding.models.UserData
import com.example.uvinto.onboarding.repository.Repository

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)




        val repository = Repository()
        val viewModelFactory = RegisterViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegisterViewModel::class.java)

        registerBinding.buttonSignup.setOnClickListener {
            assignRegisteredUser()

        }




    }

    fun assignRegisteredUser(){
        val user = UserData(registerBinding.edittxtFirstName.text.toString()
            ,registerBinding.edittxtLastname.text.toString()
            ,registerBinding.edittxtEmail.text.toString()
            , registerBinding.edittxtPassword.text.toString()
            ,registerBinding.edittxtConfirmpassword.text.toString(),"android")

        viewModel.addRegisteredUser(user)
        viewModel.registerResponse.observe(this, Observer { response ->
            if(response.body()?.success==true){
                Toast.makeText(this,"Register completed successfully",Toast.LENGTH_LONG).show()
                val intent = Intent(this, InterestsActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(this,response.body()?.errors?.email,Toast.LENGTH_LONG).show()
            }
        })
    }



}