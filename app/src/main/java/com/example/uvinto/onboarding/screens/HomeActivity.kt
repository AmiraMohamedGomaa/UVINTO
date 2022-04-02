package com.example.uvinto.onboarding.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.uvinto.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Initialize the bottom navigation view
        //create bottom navigation view object
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}