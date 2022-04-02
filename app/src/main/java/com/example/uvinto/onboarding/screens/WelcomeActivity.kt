package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uvinto.R

class WelcomeActivity : AppCompatActivity() {
    private lateinit var loginButton : Button
    private lateinit var signUpButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        loginButton = findViewById(R.id.login_button)
        signUpButton = findViewById(R.id.signup_button)

        loginButton.setOnClickListener {
            val finish = Intent(applicationContext, LoginActivity::class.java)
            startActivity(finish)
        }

        signUpButton.setOnClickListener {
            val finish = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(finish)
        }
    }
}