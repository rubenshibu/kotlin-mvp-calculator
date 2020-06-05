package com.leeway.android_kotlin_mvp

import android.app.Application
import android.content.Context
import com.leeway.android_kotlin_mvp.data.DataManager
import com.leeway.android_kotlin_mvp.di.component.ApplicationComponent
import com.leeway.android_kotlin_mvp.di.component.DaggerApplicationComponent
import com.leeway.android_kotlin_mvp.di.module.ApplicationModule
import javax.inject.Inject

/**
 * Created by Lee Lorz on 7/10/2017.
 */
class MainApplication : Application() {

    companion object {
        fun get(context: Context): MainApplication {
            return context.applicationContext as MainApplication
        }
    }

    @Inject
    lateinit var dataManager: DataManager

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}