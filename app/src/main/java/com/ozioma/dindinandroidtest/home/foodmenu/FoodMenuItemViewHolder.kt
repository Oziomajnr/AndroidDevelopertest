package com.ozioma.dindinandroidtest.home.foodmenu

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ozioma.dindinandroidtest.R
import com.ozioma.dindinandroidtest.databinding.ViewFoodMenuItemBinding
import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.viewutils.HashItemCallback
import com.ozioma.dindinandroidtest.viewutils.LayoutViewHolder

class FoodMenuItemViewHolder(parent: ViewGroup) :
    LayoutViewHolder(parent, R.layout.view_food_menu_item) {
    val binding = ViewFoodMenuItemBinding.bind(itemView)
}

class FoodMenuItemAdapter :
    ListAdapter<FoodMenuItem, FoodMenuItemViewHolder>(HashItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodMenuItemViewHolder {
        return FoodMenuItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: FoodMenuItemViewHolder, position: Int) {
        holder.binding.foodMenuItem = getItem(position)
    }
}