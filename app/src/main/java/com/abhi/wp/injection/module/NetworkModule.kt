package com.abhi.wp.injection.module

import com.abhi.wp.utils.BASE_URL
import com.abhi.wp.network.DataApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * module for dependency
 */
@Module
object NetworkModule
{
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDataApi(retrofit: Retrofit):DataApi
    {
      return retrofit.create(DataApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface():Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).build()
    }
}