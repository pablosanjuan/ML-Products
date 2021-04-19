package com.pabloSanjuan.listadoproductos.presentation.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment <V : ViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelClass: Class<V>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    //protected lateinit var binding: B
    private lateinit var viewModel: V


    protected fun setAndBindContentView(@LayoutRes layoutResID: Int) {
        //binding = DataBindingUtil.setContentView(this, layoutResID)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }
}