package com.ozioma.dindinandroidtest.home.foodmenu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ozioma.dindinandroidtest.data.FoodMenuPage

class MenuViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var foodMenuPages = listOf<FoodMenuPage>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getCount(): Int = foodMenuPages.size

    override fun getItem(position: Int): Fragment =
        FoodMenuFragment.newInstance(foodMenuPages[position].type)
}