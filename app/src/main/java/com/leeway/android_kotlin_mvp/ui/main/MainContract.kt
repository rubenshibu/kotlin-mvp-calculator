package com.leeway.android_kotlin_mvp.ui.main

import com.leeway.android_kotlin_mvp.ui.base.MvpPresenter
import com.leeway.android_kotlin_mvp.ui.base.MvpView

/**
 * Created by Lee Lorz on 7/15/2017.
 */
interface MainContract {

    interface Presenter<V:MainContract.View>: MvpPresenter<V> {
        fun onCalCPress()
        fun onCalZeroPress(currentAmount: String)
        fun onCalOnePress(currentAmount: String)
        fun onCalTwoPress(currentAmount: String)
        fun onCalThreePress(currentAmount: String)
        fun onCalFourPress(currentAmount: String)
        fun onCalFivePress(currentAmount: String)
        fun onCalSixPress(currentAmount: String)
        fun onCalSevenPress(currentAmount: String)
        fun onCalEightPress(currentAmount: String)
        fun onCalNinePress(currentAmount: String)
        fun onCalTripleZeroPress(currentAmount: String)
        fun onCalDotPress(currentAmount: String)
        fun onCalDeletePress(currentAmount: String)
        fun onCalPlusPress(currentAmount: String)
        fun onCalMinusPress(currentAmount: String)
        fun onCalMultiplePress(currentAmount: String)
        fun onCalDividePress(currentAmount: String)
        fun onCalEqualPress(currentAmount: String)

    }

    interface View: MvpView {
        fun setCurrentValue(value: String)

    }
}