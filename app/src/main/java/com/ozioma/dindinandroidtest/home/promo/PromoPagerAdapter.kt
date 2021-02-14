package com.ozioma.dindinandroidtest.home.promo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.ozioma.dindinandroidtest.data.Promo
import com.ozioma.dindinandroidtest.R
import com.ozioma.dindinandroidtest.databinding.PromoViewBinding
import com.ozioma.dindinandroidtest.extension.loadImage


class PromoPagerAdapter(context: Context) : PagerAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    var promos: List<Promo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return promos.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Inflate the layout for the page
        val promoItemBinding: PromoViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.promo_view, container, false)
        val promo = promos[position]
        promoItemBinding.promoImage.loadImage(promo.imageUrl)
        container.addView(promoItemBinding.root)
        // Return the page
        return promoItemBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, item: Any) {
        container.removeView(item as View)
    }
}