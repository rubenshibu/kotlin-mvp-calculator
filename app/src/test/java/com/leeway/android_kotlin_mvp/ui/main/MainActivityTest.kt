package com.leeway.android_kotlin_mvp.ui.main

import com.leeway.android_kotlin_mvp.BuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.Matchers.notNullValue
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

/**
 * Created by Lee Lorz on 7/29/2017.
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,
        sdk = intArrayOf(21))
class MainActivityTest {
    lateinit var activityController: ActivityController<MainActivity>
    lateinit var activity: MainActivity
    lateinit var currentAmount: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        activityController = Robolectric.buildActivity(MainActivity::class.java).create()
        activity = activityController.get()
        currentAmount = activity.tvAmount.text.toString()
    }

    @Test
    @Throws(Exception::class)
    fun testActivityIsNotNull() {
        assertThat(activity, `is`(notNullValue()))
    }

    @Test
    @Throws(Exception::class)
    fun testOnCreate() {
        assertThat(activity.mainPresenter, `is`(notNullValue()))
        verify(activity.mainPresenter).onAttach(activity)
    }

    @Test
    @Throws(Exception::class)
    fun testHaveButtons() {
        assertThat(activity.btnCalC , `is`(notNullValue()))
        assertThat(activity.btnCalZero , `is`(notNullValue()))
        assertThat(activity.btnCalTripleZero, `is`(notNullValue()))
        assertThat(activity.btnCalOne , `is`(notNullValue()))
        assertThat(activity.btnCalTwo , `is`(notNullValue()))
        assertThat(activity.btnCalThree , `is`(notNullValue()))
        assertThat(activity.btnCalFour , `is`(notNullValue()))
        assertThat(activity.btnCalFive , `is`(notNullValue()))
        assertThat(activity.btnCalSix , `is`(notNullValue()))
        assertThat(activity.btnCalSeven , `is`(notNullValue()))
        assertThat(activity.btnCalEight , `is`(notNullValue()))
        assertThat(activity.btnCalNine , `is`(notNullValue()))
        assertThat(activity.btnCalDot , `is`(notNullValue()))
        assertThat(activity.btnCalDelete , `is`(notNullValue()))
        assertThat(activity.btnCalPlus , `is`(notNullValue()))
        assertThat(activity.btnCalMinus , `is`(notNullValue()))
        assertThat(activity.btnCalMultiple , `is`(notNullValue()))
        assertThat(activity.btnCalDivide , `is`(notNullValue()))
        assertThat(activity.btnCalEqual , `is`(notNullValue()))
        assertThat(activity.tvAmount, `is`(notNullValue()))
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalCClick() {
        activity.btnCalC.performClick()
        verify(activity.mainPresenter).onCalCPress()
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalZeroClick() {
        activity.btnCalZero.performClick()
        verify(activity.mainPresenter).onCalZeroPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalTripleZeroClick() {
        activity.btnCalTripleZero.performClick()
        verify(activity.mainPresenter).onCalTripleZeroPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalOneClick() {
        activity.btnCalOne.performClick()
        verify(activity.mainPresenter).onCalOnePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalTwoClick() {
        activity.btnCalTwo.performClick()
        verify(activity.mainPresenter).onCalTwoPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalThreeClick() {
        activity.btnCalThree.performClick()
        verify(activity.mainPresenter).onCalThreePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalFourClick() {
        activity.btnCalFour.performClick()
        verify(activity.mainPresenter).onCalFourPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalFiveClick() {
        activity.btnCalFive.performClick()
        verify(activity.mainPresenter).onCalFivePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalSixClick() {
        activity.btnCalSix.performClick()
        val currentAmount = activity.tvAmount.text.toString()
        verify(activity.mainPresenter).onCalSixPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalSevenClick() {
        activity.btnCalSeven.performClick()
        verify(activity.mainPresenter).onCalSevenPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalEightClick() {
        activity.btnCalEight.performClick()
        verify(activity.mainPresenter).onCalEightPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalNineClick() {
        activity.btnCalNine.performClick()
        verify(activity.mainPresenter).onCalNinePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalDotClick() {
        activity.btnCalDot.performClick()
        verify(activity.mainPresenter).onCalDotPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalDeleteClick() {
        activity.btnCalDelete.performClick()
        verify(activity.mainPresenter).onCalDeletePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalPlusClick() {
        activity.btnCalPlus.performClick()
        verify(activity.mainPresenter).onCalPlusPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalMinusClick() {
        activity.btnCalMinus.performClick()
        verify(activity.mainPresenter).onCalMinusPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalMultipleClick() {
        activity.btnCalMultiple.performClick()
        verify(activity.mainPresenter).onCalMultiplePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalDivideClick() {
        activity.btnCalDivide.performClick()
        verify(activity.mainPresenter).onCalDividePress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnCalEqualClick() {
        activity.btnCalEqual.performClick()
        verify(activity.mainPresenter).onCalEqualPress(currentAmount)
    }

    @Test
    @Throws(Exception::class)
    fun testOnDestroy() {
        activity = activityController.destroy().get()
        verify(activity.mainPresenter).onDetach()
    }
}