package com.abhi.wp.model

/**
 * create dataclass for hold the data from api
 */
data class FeedDC(val title:String, val rows:List<Feeddata>) {

data class Feeddata(val title:String, val description:String, val imageHref:String)
}