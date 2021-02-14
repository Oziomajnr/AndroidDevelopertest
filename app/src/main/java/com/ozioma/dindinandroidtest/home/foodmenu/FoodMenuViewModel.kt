package com.ozioma.dindinandroidtest.home.foodmenu

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.ozioma.dindinandroidtest.FoodStoreApplication
import com.ozioma.dindinandroidtest.home.promo.PromoRepository

class FoodMenuViewModel(
    initialState: FoodMenuState,
    private val promoRepository: PromoRepository
) : BaseMvRxViewModel<FoodMenuState>(initialState) {

//    fun getFoodMenuItems(type: String) {
//        promoRepository.getFoodMenuItems("Pizza").execute {
//            copy(foodMenuItems = it)
//        }
//    }

    init {
        promoRepository.getFoodMenuItems("Pizza").execute {
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
