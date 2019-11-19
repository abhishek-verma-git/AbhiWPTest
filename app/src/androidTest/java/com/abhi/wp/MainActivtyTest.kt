package com.abhi.wp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.abhi.wp.ui.activity.MainActivity
import com.taingmeng.espresso.recyclerviewassertions.AssertionsInRecycler.Companion.hasItemCount
import com.taingmeng.espresso.recyclerviewassertions.RecyclerMatchers.Companion.withItemCount
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java)

    @Test
    fun countProgramsWithViewAssertion() {
        onView(withId(R.id.feed_list_rv))
            .check(hasItemCount(activityRule.activity.activityViewModel.size))
    }

    @Test
    fun countPrograms() {
        onView(withId(R.id.feed_list_rv))
            .check(matches(withItemCount(12)))
    }
}