package com.abhi.wp.network

import com.abhi.wp.model.FeedDC
import io.reactivex.Observable
import retrofit2.http.GET


interface DataApi {

    //service method
    @GET("/s/2iodh4vg0eortkl/facts")
    fun getData(): Observable<FeedDC>

}