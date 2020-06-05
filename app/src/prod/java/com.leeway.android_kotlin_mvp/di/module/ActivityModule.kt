package com.leeway.android_kotlin_mvp.di.module

import android.app.Activity
import android.content.Context
import com.leeway.android_kotlin_mvp.di.ActivityContext
import com.leeway.android_kotlin_mvp.di.PerActivity
import com.leeway.android_kotlin_mvp.ui.main.MainContract
import com.leeway.android_kotlin_mvp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Lee Lorz on 7/14/2017.
 */

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @PerActivity
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    fun provideMainPresenter(presenter: MainPresenter<MainContract.View>)
            : MainContract.Presenter<MainContract.View> {
        return presenter
    }
}