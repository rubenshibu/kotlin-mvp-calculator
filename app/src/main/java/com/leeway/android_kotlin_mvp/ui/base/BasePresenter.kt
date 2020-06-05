package com.leeway.android_kotlin_mvp.ui.base

import com.leeway.android_kotlin_mvp.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Lee Lorz on 7/15/2017.
 */
open class BasePresenter<V: MvpView>
@Inject
constructor(val dataManager: DataManager,
            val compositeDisposable: CompositeDisposable) : MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        this.mvpView = null
        this.compositeDisposable.dispose()
    }

    fun isViewAttached(): Boolean {
        return mvpView != null
    }


}