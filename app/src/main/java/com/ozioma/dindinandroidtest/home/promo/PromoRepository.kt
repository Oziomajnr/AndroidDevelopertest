package com.ozioma.dindinandroidtest.home.promo

import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.data.Promo
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class PromoRepository {
    fun getPromos() = Observable.fromCallable {
        Thread.sleep(2000L)
        listOf(
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
    }.subscribeOn(Schedulers.io())

    fun getFoodMenuItems(type: String) = Observable.fromCallable {
        Thread.sleep(2000L)
        listOf(
            FoodMenuItem(
                "food_menu_item_1",
                "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
                "Big Pizza",
                "Very good",
                "30 cm",
                "$23"
            ),
            FoodMenuItem(
                "food_menu_item_1",
                "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
                "Big Pizza",
                "Very good",
                "30 cm",
                "$23"
            ),
            FoodMenuItem(
                "food_menu_item_1",
                "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
                "Big Pizza",
                "Very good",
                "30 cm",
                "$23"
            ),
            FoodMenuItem(
                "food_menu_item_1",
                "https://wp-search.com/wp-content/uploads/2020/05/1590124050_maxresdefault.jpg",
                "Big Pizza",
                "Very good",
                "30 cm",
                "$23"
            )
        )
    }.subscribeOn(Schedulers.io())
}
