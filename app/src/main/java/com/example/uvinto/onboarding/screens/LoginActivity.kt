package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivityLoginBinding
import com.example.uvinto.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityLoginBinding
    private lateinit var textViewSignUp: TextView
    private lateinit var textViewForgetPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        textViewSignUp = findViewById(R.id.txtview_signup)
        textViewForgetPassword = findViewById(R.id.txtview_forget_password)

        textViewSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        textViewForgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordStepOneActivity::class.java)
            startActivity(intent)
        }

    }
}