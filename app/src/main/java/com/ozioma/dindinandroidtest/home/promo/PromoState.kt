package com.ozioma.dindinandroidtest.home.promo

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.ozioma.dindinandroidtest.data.Promo

data class PromoState(
    val promos: Async<List<Promo>> = Uninitialized
) : MavericksState