package com.ozioma.dindinandroidtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView

abstract class BaseFragment<B : ViewDataBinding> : Fragment(), MavericksView {

    protected lateinit var binding: B

    @get:LayoutRes
    protected abstract val layout: Int

    protected open val dataBindingComponent: DataBindingComponent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<B>(inflater, layout, container, false, dataBindingComponent).also {
            binding = it
            it.lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

}