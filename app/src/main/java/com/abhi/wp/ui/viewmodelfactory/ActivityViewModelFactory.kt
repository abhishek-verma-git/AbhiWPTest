package com.abhi.wp.ui.viewmodelfactory


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhi.wp.ui.activity.MainActivity
import com.abhi.wp.ui.activityviewmodel.ActivityViewModel
import javax.inject.Inject

class ActivityViewModelFactory @Inject constructor(private val context: MainActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ActivityViewModel::class.java!!)) {
            ActivityViewModel(this.context) as T
        } else {
            throw IllegalArgumentException("ActivityViewModel Not Found")
        }
    }

}




