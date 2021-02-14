package com.ozioma.dindinandroidtest.home.promo

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.ozioma.dindinandroidtest.FoodStoreApplication

class PromoViewModel(
    initialState: PromoState,
    private val promoRepository: PromoRepository
) : BaseMvRxViewModel<PromoState>(initialState) {
    init {
        promoRepository.getPromos().execute {
            copy(promos = it)
        }
    }


    companion object : MavericksViewModelFactory<PromoViewModel, PromoState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: PromoState
        ): PromoViewModel {
            val promoRepository = viewModelContext.app<FoodStoreApplication>().promoRepository
            return PromoViewModel(state, promoRepository)
        }
    }

}