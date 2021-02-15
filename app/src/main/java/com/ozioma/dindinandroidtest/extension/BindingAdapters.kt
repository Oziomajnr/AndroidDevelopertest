package com.ozioma.dindinandroidtest.extension

import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.annotation.RequiresApi
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

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
@BindingAdapter("addRoundedCorners")
fun View.addRoundedCorners(
    radius: Float
) {
    clipToOutline = true
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, radius)
        }
    }
}