package com.ozioma.dindinandroidtest

import android.app.Application
import com.airbnb.mvrx.Mavericks

class FoodStoreApplication: Application() {
    val promoRepository = FoodStoreRepository()

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}