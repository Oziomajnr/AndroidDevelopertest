package com.ozioma.dindinandroidtest.home

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.ozioma.dindinandroidtest.FoodStoreApplication
import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.FoodStoreRepository

class HomeViewModel(
    initialState: CartState,
    private val foodStoreRepository: FoodStoreRepository
) : BaseMvRxViewModel<CartState>(initialState) {

    init {
        foodStoreRepository.getPromos().execute {
            copy(promos = it)
        }
    }

    fun addItemToCart(foodItem: FoodMenuItem) {
        setState {
            val items = mutableListOf<FoodMenuItem>()
            items.addAll(this.cartItems)
            items.add(foodItem)
            copy(cartItems = items)
        }
    }


    companion object : MavericksViewModelFactory<HomeViewModel, CartState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: CartState
        ): HomeViewModel {
            val promoRepository = viewModelContext.app<FoodStoreApplication>().promoRepository
            return HomeViewModel(state, promoRepository)
        }
    }
}
