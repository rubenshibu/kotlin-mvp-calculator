package com.leeway.android_kotlin_mvp.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Lee Lorz on 7/15/2017.
 */

object NetworkUtil {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}