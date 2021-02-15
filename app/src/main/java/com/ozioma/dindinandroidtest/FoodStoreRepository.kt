package com.ozioma.dindinandroidtest

import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.data.Promo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class FoodStoreRepository {
    val promos = mutableListOf(
        Promo(
            "",
            "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg"
        ),
        Promo(
            "",
            "https://i1.wp.com/aedownload.com/wp-content/uploads/2020/08/Pre-57.jpg"
        ),
        Promo(
            "",
            "https://i1.wp.com/aedownload.com/wp-content/uploads/2020/08/Pre-57.jpg"
        )
    )

    val foodMenuItems = mutableListOf(
        FoodMenuItem(
            "food_menu_item_1",
            "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
            "Big Pizza",
            "Very good",
            "30 cm",
            "$23"
        ),
        FoodMenuItem(
            "food_menu_item_2",
            "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
            "Big Pizza",
            "Very good",
            "30 cm",
            "$23"
        ),
        FoodMenuItem(
            "food_menu_item_3",
            "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
            "Big Pizza",
            "Very good",
            "30 cm",
            "$23"
        ),
        FoodMenuItem(
            "food_menu_item_4",
            "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
            "Big Pizza",
            "Very good",
            "30 cm",
            "$23"
        )
    )

    fun getPromos() = Observable.fromCallable {
        promos
    }.subscribeOn(Schedulers.io())

    fun getFoodMenuItems(type: String) = Observable.fromCallable {
        foodMenuItems
    }.subscribeOn(Schedulers.io())
}
