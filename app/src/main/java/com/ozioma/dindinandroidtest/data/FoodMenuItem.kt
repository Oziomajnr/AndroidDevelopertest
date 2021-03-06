package com.ozioma.dindinandroidtest.data

data class FoodMenuItem(
    val id: String, val imageUrl: String,
    val name: String, val description: String,
    val size: String, val price: String,
    var addedToCard: Boolean = false
) : StableItem {
    override val stableId = id

}