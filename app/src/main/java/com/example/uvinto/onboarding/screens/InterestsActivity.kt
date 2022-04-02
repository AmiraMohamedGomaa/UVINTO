package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.uvinto.R

class InterestsActivity : AppCompatActivity() {

    private lateinit var getStartedButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interests)

        getStartedButton = findViewById(R.id.button_get_started)
        getStartedButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}