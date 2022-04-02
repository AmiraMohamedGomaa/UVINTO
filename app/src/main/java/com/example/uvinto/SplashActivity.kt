package com.example.uvinto


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.uvinto.databinding.ActivitySplashBinding
import com.example.uvinto.onboarding.screens.SliderActivity


class SplashActivity : AppCompatActivity() {
   private lateinit var mainBinding: ActivitySplashBinding
   private var splashTimer=6000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash)

        //val animationLogo=AnimationUtils.loadAnimation(this,R.anim.drop_logo_splashscreen)
        //.splashLogo.startAnimation(animationLogo)

        Handler().postDelayed({
            val intent = Intent(this, SliderActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimer.toLong())
    }
}