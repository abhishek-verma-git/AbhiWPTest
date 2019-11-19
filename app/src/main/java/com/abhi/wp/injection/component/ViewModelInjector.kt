package com.abhi.wp.injection.component

import com.abhi.wp.injection.module.NetworkModule
import com.abhi.wp.ui.activityviewmodel.ActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(activityViewModel: ActivityViewModel)

    @Component.Builder
    interface Builder
    {
        fun build():ViewModelInjector

        fun networkModule(networkModule: NetworkModule):Builder
    }
}