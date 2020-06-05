package com.leeway.android_kotlin_mvp.di.component

import com.leeway.android_kotlin_mvp.di.PerActivity
import com.leeway.android_kotlin_mvp.di.module.ActivityModule
import com.leeway.android_kotlin_mvp.ui.main.MainActivity
import dagger.Component

/**
 * Created by Lee Lorz on 7/14/2017.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
            modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)
}