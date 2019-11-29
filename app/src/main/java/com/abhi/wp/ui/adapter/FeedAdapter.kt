package com.abhi.wp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.abhi.wp.R
import com.abhi.wp.databinding.FeedAdapterBinding
import com.abhi.wp.model.FeedDC
import com.abhi.wp.ui.adapterviewmodel.FeedViewModel

class FeedAdapter:RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    private lateinit var feedList:List<FeedDC.Feeddata>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val feedBinding:FeedAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.feed_adapter,parent,false)
        return ViewHolder(feedBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount(): Int {
        return if(::feedList.isInitialized)feedList.size else 0
    }

    fun updateFeedList(feedList:List<FeedDC.Feeddata>)
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