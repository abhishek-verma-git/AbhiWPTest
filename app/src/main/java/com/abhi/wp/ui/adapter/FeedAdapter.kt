package com.abhi.wp.ui.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abhi.wp.R
import com.abhi.wp.databinding.FeedAdapterBinding
import com.abhi.wp.model.FeedDC
import com.abhi.wp.ui.adapterviewmodel.FeedViewModel



class FeedAdapter:RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    private lateinit var feedList:MutableList<FeedDC.Feeddata>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val feedBinding:FeedAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            com.abhi.wp.R.layout.feed_adapter,parent,false)
        return ViewHolder(feedBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount(): Int {
        if(::feedList.isInitialized)
        for(item in 0..feedList.size-1)
        {
            if(TextUtils.isEmpty(feedList[item].title) && TextUtils.isEmpty(feedList[item].description) && TextUtils.isEmpty(feedList[item].imageHref))
            {
                feedList.removeAt(item)
                return feedList.size
            }
        }
        return if(::feedList.isInitialized)feedList.size else 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun updateFeedList(feedList:MutableList<FeedDC.Feeddata>)
    {
        this.feedList = feedList
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding:FeedAdapterBinding):RecyclerView.ViewHolder(binding.root)
    {
        private val viewmodel = FeedViewModel()
        fun bind(feed:FeedDC.Feeddata)
        {
            viewmodel.bind(feed)
            binding.feedViewModel = viewmodel
        }
    }
}