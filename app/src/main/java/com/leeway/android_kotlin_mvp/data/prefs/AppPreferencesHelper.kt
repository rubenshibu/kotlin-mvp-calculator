package com.leeway.android_kotlin_mvp.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.leeway.android_kotlin_mvp.di.ApplicationContext
import com.leeway.android_kotlin_mvp.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/12/2017.
 */
@Singleton
class AppPreferencesHelper
@Inject
constructor(@ApplicationContext context: Context,
            @PreferenceInfo prefFileName: String) : PreferencesHelper {

    var pref: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

}