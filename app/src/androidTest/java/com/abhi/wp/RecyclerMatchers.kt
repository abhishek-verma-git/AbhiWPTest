package com.taingmeng.espresso.recyclerviewassertions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class RecyclerMatchers {
  companion object {
    fun withItemCount(count: Int): Matcher<View> {
      return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

        override fun describeTo(description: Description?) {
          description?.appendText("RecyclerView with item count: $count")
        }

        override fun matchesSafely(item: RecyclerView?): Boolean {
          return item?.adapter?.itemCount == count
        }
      }
    }
  }
}
