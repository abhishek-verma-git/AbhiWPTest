package com.abhi.wp.base

import androidx.lifecycle.ViewModel
import com.abhi.wp.injection.module.NetworkModule
import com.abhi.wp.injection.component.DaggerViewModelInjector
import com.abhi.wp.injection.component.ViewModelInjector
import com.abhi.wp.ui.activityviewmodel.ActivityViewModel

abstract class BaseViewModel: ViewModel() {

    private var injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule).build()

    init  {
        inject()
    }


    private fun inject()
    {
        when(this)
        {
            is ActivityViewModel -> injector.inject(this)
        }
    }
}