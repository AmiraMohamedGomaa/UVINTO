package com.example.uvinto.onboarding.screens

import android.content.Intent
import android.content.SharedPreferences
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivitySliderBinding
import com.example.uvinto.onboarding.IntroViewpagerAdapter
import com.example.uvinto.onboarding.models.ScreenIntroModel
import com.google.android.material.tabs.TabLayout

class SliderActivity : AppCompatActivity() {
   private lateinit var sliderBinding : ActivitySliderBinding
   private lateinit var introAdapter :IntroViewpagerAdapter
   private lateinit var list :List<ScreenIntroModel>
  private var position=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sliderBinding= ActivitySliderBinding.inflate(layoutInflater)
        val view = sliderBinding.root


        //  check if its openened before or not
        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
        setContentView(view)

        setIntroItems()


    }

    private fun setIntroItems() {
        list= listOf(
            ScreenIntroModel(
                "Find Nearby Events",
                "Uvinto offers an opportunity to be an organizer who can share events in a professional way or be an active subscriber who can easily ongoing in any event with a high level of safety.",
                R.drawable.slider2),

            ScreenIntroModel(
                "Create Your Event",
                "Uvinto is the best choice for you if you want to be an effective organizer or to be up to date with events in Egypt." ,
                R.drawable.slider1),

            ScreenIntroModel(
                "Follow Organizers",
                "Uvinto is the best choice for you if you want to be an effective organizer or to be up to date with events in Egypt.",
                R.drawable.event)

        )
        introAdapter= IntroViewpagerAdapter(applicationContext, list)

        val introViewPager=sliderBinding.viewPager
        introViewPager.adapter=introAdapter

        sliderBinding.tabIndicator.setupWithViewPager(introViewPager)

        sliderBinding.nextIntroBtn.setOnClickListener {
            position = introViewPager.getCurrentItem()
            if (position < list.size) {
                position++
                introViewPager.setCurrentItem(position)
            }

            if (position == list.size- 1) {
                loaddLastScreen()

            }
        }
            sliderBinding.tabIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.position == list.size - 1) {
                        loaddLastScreen()

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {

                }

                override fun onTabReselected(tab: TabLayout.Tab) {

                }
            })

        sliderBinding.tvSkip.setOnClickListener {
              introViewPager.setCurrentItem(list.size)
        }



    sliderBinding.finishIntroBtn.setOnClickListener {
        val finish = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(finish)
        savePrefsData()
        finish()
    }



    }

    fun restorePrefData(): Boolean {
        val pref =
            applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        return pref.getBoolean("isIntroOpnend", false)
    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean("isIntroOpnend", true)
        editor.commit()
    }

    // show the GETSTARTED Button and hide the indicator and the next button
    private fun loaddLastScreen() {
        sliderBinding.nextIntroBtn.setVisibility(View.GONE)
        sliderBinding.finishIntroBtn.setVisibility(View.VISIBLE)
        sliderBinding.tabIndicator.setVisibility(View.INVISIBLE)
        sliderBinding.tvSkip.setVisibility(View.INVISIBLE)

    }

}