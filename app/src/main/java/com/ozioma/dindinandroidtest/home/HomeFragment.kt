package com.ozioma.dindinandroidtest.home

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingComponent
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.ozioma.dindinandroidtest.BaseFragment
import com.ozioma.dindinandroidtest.R
import com.ozioma.dindinandroidtest.data.FoodMenuItem
import com.ozioma.dindinandroidtest.data.FoodMenuPage
import com.ozioma.dindinandroidtest.databinding.FragmentHomeBinding
import com.ozioma.dindinandroidtest.home.foodmenu.MenuViewPagerAdapter
import com.ozioma.dindinandroidtest.home.promo.PromoPagerAdapter
import com.ozioma.dindinandroidtest.home.promo.PromoViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by activityViewModel()
    lateinit var pagerAdapter: PromoPagerAdapter
    lateinit var menuPagerAdapter: MenuViewPagerAdapter

    override fun invalidate() {
        withState(homeViewModel) { state ->
            pagerAdapter.promos = state.promos.invoke() ?: emptyList()
            binding.cartFab.count = state.cartItems.size
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter =
            PromoPagerAdapter(requireContext())
        menuPagerAdapter = MenuViewPagerAdapter(childFragmentManager)
        binding.menuViewPager.adapter = menuPagerAdapter
        binding.promoViewPager.adapter = pagerAdapter
        binding.tabDots.setupWithViewPager(binding.promoViewPager, true)
        binding.bottomPagerIndicator.setupWithViewPager(binding.menuViewPager)
        val menu = listOf(FoodMenuPage("Pizza"), FoodMenuPage("Beef"))
        menuPagerAdapter.foodMenuPages = menu
        binding.bottomPagerIndicator.removeAllTabs()
        menu.forEach {
            binding.bottomPagerIndicator.addTab(
                binding.bottomPagerIndicator.newTab().setText(it.type)
            )
        }
        binding.cartFab.setOnClickListener {

        }
    }

    override val layout = R.layout.fragment_home
    override val dataBindingComponent: DataBindingComponent?
        get() = super.dataBindingComponent

    override val mvrxViewId: String = "HomeFragment"
}