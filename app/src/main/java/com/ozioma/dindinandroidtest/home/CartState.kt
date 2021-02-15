package com.ozioma.dindinandroidtest.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.data.Promo

data class CartState(
    val cartItems: List<FoodMenuItem> = listOf(),
    val promos: Async<List<Promo>> = Uninitialized
) : MavericksState