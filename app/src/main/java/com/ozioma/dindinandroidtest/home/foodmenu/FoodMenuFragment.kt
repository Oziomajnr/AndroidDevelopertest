package com.ozioma.dindinandroidtest.home.foodmenu

import android.os.Bundle
import android.view.View
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.ozioma.dindinandroidtest.BaseFragment
import com.ozioma.dindinandroidtest.R
import com.ozioma.dindinandroidtest.databinding.FragmentFoodMenuBinding

class FoodMenuFragment : BaseFragment<FragmentFoodMenuBinding>() {
    private lateinit var foodMenuType: String
    private val foodMenuItemViewModel: FoodMenuViewModel by fragmentViewModel()
    val adapter = FoodMenuItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            foodMenuType = it.getString(FOOD_MENU_TYPE) ?: error("Invalid food menu type passed")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menuItemRecyclerView.adapter = adapter

    }

    override fun invalidate() {
        withState(foodMenuItemViewModel) { state ->
            binding.state = state
            adapter.submitList(state.foodMenuItems.invoke())
        }
    }

    companion object {
        val FOOD_MENU_TYPE = "FOOD_MENU_TYPE"

        @JvmStatic
        fun newInstance(foodMenuType: String) =
            FoodMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(FOOD_MENU_TYPE, foodMenuType)
                }
            }
    }

    override val layout = R.layout.fragment_food_menu

    override val mvrxViewId: String = "FoodMenuFragment"
}