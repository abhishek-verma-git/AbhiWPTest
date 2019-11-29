package com.abhi.wp.ui.activityviewmodel

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.abhi.wp.R
import com.abhi.wp.base.BaseViewModel
import com.abhi.wp.model.FeedDC
import com.abhi.wp.network.DataApi
import com.abhi.wp.ui.activity.MainActivity
import com.abhi.wp.ui.adapter.FeedAdapter
import com.abhi.wp.utils.Helper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ActivityViewModel(var context: MainActivity):BaseViewModel() {

    @Inject
    lateinit var dataApi:DataApi

    val feedAdapter:FeedAdapter=FeedAdapter()
    private lateinit var subscription:Disposable
    val loadingVisibility:ObservableInt= ObservableInt(GONE)
    val errorMessage: ObservableField<String> = ObservableField()
    var title:ObservableField<String> = ObservableField()
    val isLoading:ObservableBoolean = ObservableBoolean(false)
    var size:Int = 0

    init{loadData()}

  private fun loadData()
    {
        if(Helper.isOnline(context))
        {
            subscription = dataApi.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({onRetrievePostListStart()})
                .doOnTerminate({onRetrievePostListFinish()})
                .subscribe({result->onRetrievePostListSuccess(result)},{onRetrievePostListError()})
        }else
        {
            loadingVisibility.set(GONE)
            isLoading.set(false)
            Toast.makeText(context,R.string.no_internet_connection,Toast.LENGTH_LONG).show()
        }

    }

    private fun onRetrievePostListStart(){
        loadingVisibility.set(VISIBLE)
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.set(GONE)
        isLoading.set(false)
    }

    private fun onRetrievePostListSuccess(feedData:FeedDC){
        isLoading.set(false)
        title.set(feedData.title)
        var feedlist:MutableList<FeedDC.Feeddata> = feedData.rows
        size = feedlist.size
        feedAdapter.updateFeedList(feedlist)
    }

    private fun onRetrievePostListError(){
        Toast.makeText(context, R.string.feed_error,Toast.LENGTH_LONG).show()
        loadingVisibility.set(GONE)
        isLoading.set(false)
    }

    fun onRefresh()
    {
        isLoading.set(true)
        loadData()
    }

}