package com.leeway.android_kotlin_mvp.di.component

import android.app.Application
import android.content.Context
import com.leeway.android_kotlin_mvp.MainApplication
import com.leeway.android_kotlin_mvp.data.DataManager
import com.leeway.android_kotlin_mvp.di.ApplicationContext
import com.leeway.android_kotlin_mvp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: MainApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager
}