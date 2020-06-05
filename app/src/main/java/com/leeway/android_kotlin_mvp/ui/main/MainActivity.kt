package com.leeway.android_kotlin_mvp.ui.main

import android.os.Bundle
import android.view.View
import com.leeway.android_kotlin_mvp.R
import com.leeway.android_kotlin_mvp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, View.OnClickListener {

    @Inject
    lateinit var mainPresenter: MainContract.Presenter<MainContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        mainPresenter.onAttach(this)
        setUp()
    }

    override fun onDestroy() {
        mainPresenter.onDetach()
        super.onDestroy()
    }

    override fun setUp() {
        btnCalC.setOnClickListener(this)
        btnCalZero.setOnClickListener(this)
        btnCalTripleZero.setOnClickListener(this)
        btnCalOne.setOnClickListener(this)
        btnCalTwo.setOnClickListener(this)
        btnCalThree.setOnClickListener(this)
        btnCalFour.setOnClickListener(this)
        btnCalFive.setOnClickListener(this)
        btnCalSix.setOnClickListener(this)
        btnCalSeven.setOnClickListener(this)
        btnCalEight.setOnClickListener(this)
        btnCalNine.setOnClickListener(this)
        btnCalDot.setOnClickListener(this)
        btnCalDelete.setOnClickListener(this)
        btnCalPlus.setOnClickListener(this)
        btnCalMinus.setOnClickListener(this)
        btnCalMultiple.setOnClickListener(this)
        btnCalDivide.setOnClickListener(this)
        btnCalEqual.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val currentAmount = tvAmount.text.toString()
        when (view) {
            btnCalC -> mainPresenter.onCalCPress()
            btnCalZero -> mainPresenter.onCalZeroPress(currentAmount)
            btnCalTripleZero -> mainPresenter.onCalTripleZeroPress(currentAmount)
            btnCalOne -> mainPresenter.onCalOnePress(currentAmount)
            btnCalTwo -> mainPresenter.onCalTwoPress(currentAmount)
            btnCalThree -> mainPresenter.onCalThreePress(currentAmount)
            btnCalFour -> mainPresenter.onCalFourPress(currentAmount)
            btnCalFive -> mainPresenter.onCalFivePress(currentAmount)
            btnCalSix -> mainPresenter.onCalSixPress(currentAmount)
            btnCalSeven -> mainPresenter.onCalSevenPress(currentAmount)
            btnCalEight -> mainPresenter.onCalEightPress(currentAmount)
            btnCalNine -> mainPresenter.onCalNinePress(currentAmount)
            btnCalDot -> mainPresenter.onCalDotPress(currentAmount)
            btnCalDelete -> mainPresenter.onCalDeletePress(currentAmount)
            btnCalPlus -> mainPresenter.onCalPlusPress(currentAmount)
            btnCalMinus -> mainPresenter.onCalMinusPress(currentAmount)
            btnCalMultiple -> mainPresenter.onCalMultiplePress(currentAmount)
            btnCalDivide -> mainPresenter.onCalDividePress(currentAmount)
            btnCalEqual -> mainPresenter.onCalEqualPress(currentAmount)
        }
    }

    override fun setCurrentValue(value: String) {
        tvAmount.text = value
    }
}
