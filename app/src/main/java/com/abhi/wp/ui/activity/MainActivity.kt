package com.abhi.wp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhi.wp.R
import com.abhi.wp.databinding.ActivityMainBinding
import com.abhi.wp.ui.activityviewmodel.ActivityViewModel
import com.abhi.wp.ui.viewmodelfactory.ActivityViewModelFactory

class MainActivity : AppCompatActivity() {

 private lateinit var activityMainBinding: ActivityMainBinding
    lateinit var activityViewModel: ActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.feedListRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        viewModel()
    }

    private fun viewModel()
    {
//        val activityViewModel: ActivityViewModel by lazy { ViewModelProviders.of(this).get(ActivityViewModel::class.java) }
//         activityViewModel.loadData()

        //if you want to pass parameter in viewmodel you can use factory otherwise you can use above commented code
        activityViewModel = ViewModelProviders.of(this,
            ActivityViewModelFactory(this)
        ).get(ActivityViewModel::class.java)
        activityMainBinding.activityViewModel = activityViewModel
    }
}
