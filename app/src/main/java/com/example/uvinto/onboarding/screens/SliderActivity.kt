package com.example.uvinto.onboarding.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.uvinto.R
import com.example.uvinto.databinding.ActivitySliderBinding
import com.example.uvinto.onboarding.adapter.IntroViewpagerAdapter
import com.example.uvinto.onboarding.models.ScreenIntroModel
import com.google.android.material.tabs.TabLayout

class SliderActivity : AppCompatActivity() {
   private lateinit var sliderBinding : ActivitySliderBinding
   private lateinit var introAdapter : IntroViewpagerAdapter
   private lateinit var list :List<ScreenIntroModel>
  private var position=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sliderBinding= ActivitySliderBinding.inflate(layoutInflater)
        val view = sliderBinding.root


        //  check if its openened before or not
        if (restorePrefData()) {
            skipFunction()
        }
        setContentView(view)

        setIntroItems()


    }

    private fun setIntroItems() {
        list= listOf(
            ScreenIntroModel(
                "Find Nearby Events",
                "Uvinto offers an opportunity to be an organizer who can share events in a professional way or be an active subscriber who can easily ongoing in any event with a high level of safety.",
                R.raw.calendar_booking),

            ScreenIntroModel(
                "Create Your Event",
                "Uvinto is the best choice for you if you want to be an effective organizer or to be up to date with events in Egypt." ,
                R.raw.calendario_morado),

            ScreenIntroModel(
                "Follow Organizers",
                "Uvinto is the best choice for you if you want to be an effective organizer or to be up to date with events in Egypt.",
                R.raw.event_venue)

        )
        introAdapter= IntroViewpagerAdapter(applicationContext, list)

        val introViewPager=sliderBinding.viewPager
        introViewPager.adapter=introAdapter

        sliderBinding.tabIndicator.setupWithViewPager(introViewPager)

        sliderBinding.nextIntroBtn.setOnClickListener {
            position = introViewPager.currentItem
            if (position < list.size) {
                position++
                introViewPager.currentItem = position
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
            introViewPager.currentItem = list.size
            skipFunction()
        }



    sliderBinding.finishIntroBtn.setOnClickListener {
        skipFunction()
    }

    }

    fun skipFunction() {
        val finish = Intent(applicationContext, WelcomeActivity::class.java)
        startActivity(finish)
        savePrefsData()
        finish()
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
        sliderBinding.nextIntroBtn.visibility = View.GONE
        sliderBinding.finishIntroBtn.visibility = View.VISIBLE
        sliderBinding.tabIndicator.visibility = View.INVISIBLE
        sliderBinding.tvSkip.visibility = View.INVISIBLE

    }

}