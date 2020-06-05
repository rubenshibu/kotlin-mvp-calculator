package com.leeway.android_kotlin_mvp.ui.base

import android.support.annotation.StringRes

/**
 * Created by Lee Lorz on 7/14/2017.
 */

interface MvpView {
    fun showLoading()
    fun hideLoading()
    fun onError(@StringRes resId: Int)
    fun onError(message: String?)
    fun isNetworkConnected(): Boolean
    fun hideKeyBoard()
}