package com.ozioma.dindinandroidtest.home.foodmenu

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.ozioma.dindinandroidtest.data.FoodMenuItem

data class FoodMenuState(
    val foodMenuItems: Async<List<FoodMenuItem>> = Uninitialized
) : MavericksState