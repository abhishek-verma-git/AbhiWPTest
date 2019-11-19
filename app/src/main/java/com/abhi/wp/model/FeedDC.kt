package com.abhi.wp.model

data class FeedDC(val title:String, val rows:List<feeddata>) {

data class feeddata(val title:String,val description:String,val imageHref:String)
}