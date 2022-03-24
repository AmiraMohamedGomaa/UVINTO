package com.example.uvinto


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.uvinto.databinding.ActivityMainBinding
import com.example.uvinto.onboarding.screens.SliderActivity
import java.io.InputStream


class MainActivity : AppCompatActivity() {
   private lateinit var mainBinding:ActivityMainBinding
   private var splashTimer=5050

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //val animationLogo=AnimationUtils.loadAnimation(this,R.anim.drop_logo_splashscreen)
        //.splashLogo.startAnimation(animationLogo)



        Handler().postDelayed({
            val intent = Intent(this, SliderActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimer.toLong())

    }
}