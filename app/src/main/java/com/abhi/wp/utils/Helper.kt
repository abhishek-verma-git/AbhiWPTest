package com.abhi.wp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log

class Helper {

    companion object
    {
        fun isOnline(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return connectivityManager.getActiveNetwork() != null
            }
            return false
        }
    }
}