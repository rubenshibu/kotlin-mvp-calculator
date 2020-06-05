package com.leeway.android_kotlin_mvp.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.leeway.android_kotlin_mvp.MainApplication
import com.leeway.android_kotlin_mvp.R
import com.leeway.android_kotlin_mvp.di.component.ActivityComponent
import com.leeway.android_kotlin_mvp.di.component.DaggerActivityComponent
import com.leeway.android_kotlin_mvp.di.module.ActivityModule
import com.leeway.android_kotlin_mvp.util.CommonUtil
import com.leeway.android_kotlin_mvp.util.NetworkUtil

/**
 * Created by Lee Lorz on 7/14/2017.
 */

abstract class BaseActivity: AppCompatActivity(), MvpView {
    var progressDialog: ProgressDialog? = null
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(MainApplication.get(this).component)
                .build()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (progressDialog != null && progressDialog!!.isShowing()) {
            progressDialog!!.cancel()
        }
    }

    override fun onError(message: String?) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.some_error))
        }
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtil.isNetworkConnected(applicationContext)
    }

    override fun hideKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    protected abstract fun setUp()

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView.findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }
}