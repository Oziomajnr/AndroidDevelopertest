package com.ozioma.dindinandroidtest.extension

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.Async
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .applyDefaultRequestOptions(RequestOptions().apply {
            placeholder(ColorDrawable(Color.BLACK))
            error(ColorDrawable(Color.RED))
        })
        .load(url)
        .into(this)
}

@BindingAdapter("asyncList")
fun <T> setListAdapterData(recyclerView: RecyclerView, data: Async<List<T>>?) {
    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as ListAdapter<Any, *>).submitList(data?.invoke() ?: emptyList())
}