package com.abhi.wp.ui.adapterviewmodel

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.abhi.wp.base.BaseViewModel
import com.abhi.wp.model.FeedDC
import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.abhi.wp.R
import com.squareup.picasso.Picasso


class FeedViewModel:BaseViewModel() {

    private val feedTitle = MutableLiveData<String>()
    private val feedDescription = MutableLiveData<String>()
    private var feedImage= MutableLiveData<String>()

    fun bind(feed:FeedDC.feeddata)
    {
        feedTitle.value = if(TextUtils.isEmpty(feed.title))
        {
            "No Data"
        }else
        {
            feed.title
        }
        feedDescription.value = if(TextUtils.isEmpty(feed.description))
        {
            "No Data"
        }else
        {
            feed.description
        }
        feedImage.value = feed.imageHref
    }

    fun getFeedTitle():MutableLiveData<String>
    {
        return feedTitle
    }

    fun getFeedDescription():MutableLiveData<String>
    {
        return feedDescription
    }

    fun getImageUrl(): MutableLiveData<String> {
        return feedImage
    }

    object DataBindingAdapter {
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(view);
            }
        }
    }

}