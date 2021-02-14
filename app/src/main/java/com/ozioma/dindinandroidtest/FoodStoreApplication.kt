package com.ozioma.dindinandroidtest

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.ozioma.dindinandroidtest.home.promo.PromoRepository

class FoodStoreApplication: Application() {
    val promoRepository = PromoRepository()

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}