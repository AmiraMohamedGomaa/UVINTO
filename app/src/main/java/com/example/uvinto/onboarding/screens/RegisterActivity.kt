package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityRegisterBinding
    private lateinit var signUpButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)

        signUpButton = findViewById(R.id.button_signup)
        signUpButton.setOnClickListener {
            val intent = Intent(this, InterestsActivity::class.java)
            startActivity(intent)
        }
    }
}