package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivityForgetPasswordStepOneBinding
import com.example.uvinto.databinding.ActivitySplashBinding

class ForgetPasswordStepOneActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var nextButton: Button
    private lateinit var mainBinding: ActivityForgetPasswordStepOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_forget_password_step_one)

        editTextEmail = findViewById(R.id.edittxt_email)
        nextButton = findViewById(R.id.button_next)

        nextButton.setOnClickListener {
            // TODO: Check the mail if exists
            // TODO: Send email of a link to reset the password (ForgetPasswordStepTwo Activity)
            val intent = Intent(this, ForgetPasswordStepTwoActivity::class.java)
            startActivity(intent)
        }
    }
}