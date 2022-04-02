package com.example.uvinto.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieImageAsset
import com.example.uvinto.R
import com.example.uvinto.onboarding.models.ScreenIntroModel

class IntroViewpagerAdapter(
           private val mContext:Context,
            private val mlistScreens:List<ScreenIntroModel>
              ) : PagerAdapter() {



    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen: View = inflater.inflate(R.layout.intro_screen, null)
        val gifIntro=layoutScreen.findViewById<LottieAnimationView>(R.id.imageIntro)
        val titleIntro=layoutScreen.findViewById<TextView>(R.id.titleIntro_text)
        val discIntro=layoutScreen.findViewById<TextView>(R.id.discIntro_text)

        gifIntro.setAnimation(mlistScreens[position].screenImg)

        titleIntro.text = mlistScreens[position].title
        discIntro.text = mlistScreens[position].description
        // TODO: Fix dot color of the current position
        container.addView(layoutScreen)
        return layoutScreen
    }



    override fun getCount(): Int {
       return mlistScreens.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}