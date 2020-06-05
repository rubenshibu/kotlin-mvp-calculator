package com.leeway.android_kotlin_mvp.data

import android.content.Context
import com.leeway.android_kotlin_mvp.data.db.DbHelper
import com.leeway.android_kotlin_mvp.data.network.ApiHelper
import com.leeway.android_kotlin_mvp.data.prefs.PreferencesHelper
import com.leeway.android_kotlin_mvp.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Singleton
class AppDataManager
@Inject
constructor(@ApplicationContext val context: Context,
            val dbHelper: DbHelper,
            val preferencesHelper: PreferencesHelper,
            val apiHelper: ApiHelper) : DataManager {

}