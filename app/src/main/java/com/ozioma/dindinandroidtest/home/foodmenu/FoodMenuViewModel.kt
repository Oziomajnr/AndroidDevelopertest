package com.ozioma.dindinandroidtest.home.foodmenu

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.ozioma.dindinandroidtest.FoodStoreApplication
import com.ozioma.dindinandroidtest.FoodStoreRepository

class FoodMenuViewModel(
    initialState: FoodMenuState,
    private val foodStoreRepository: FoodStoreRepository
) : BaseMvRxViewModel<FoodMenuState>(initialState) {

    fun getFoodMenuItems(type: String) {
        foodStoreRepository.getFoodMenuItems(type).execute {
            copy(foodMenuItems = it)
        }
    }


    companion object : MavericksViewModelFactory<FoodMenuViewModel, FoodMenuState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: FoodMenuState
        ): FoodMenuViewModel {
            val promoRepository = viewModelContext.app<FoodStoreApplication>().promoRepository
            return FoodMenuViewModel(state, promoRepository)
        }
    }
}
