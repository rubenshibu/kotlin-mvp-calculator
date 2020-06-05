package com.leeway.android_kotlin_mvp.di.module

import android.app.Application
import android.content.Context
import com.leeway.android_kotlin_mvp.data.AppDataManager
import com.leeway.android_kotlin_mvp.data.DataManager
import com.leeway.android_kotlin_mvp.data.db.AppDbHelper
import com.leeway.android_kotlin_mvp.data.db.DbHelper
import com.leeway.android_kotlin_mvp.data.network.ApiHelper
import com.leeway.android_kotlin_mvp.data.network.AppApiHelper
import com.leeway.android_kotlin_mvp.data.prefs.AppPreferencesHelper
import com.leeway.android_kotlin_mvp.data.prefs.PreferencesHelper
import com.leeway.android_kotlin_mvp.di.ApplicationContext
import com.leeway.android_kotlin_mvp.di.PreferenceInfo
import com.leeway.android_kotlin_mvp.util.AppConstant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstant.PREF_NAME
    }
}