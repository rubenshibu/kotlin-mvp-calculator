package com.leeway.android_kotlin_mvp.ui.main

import com.leeway.android_kotlin_mvp.data.DataManager
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.verify

/**
 * Created by Lee Lorz on 7/27/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    lateinit var mainView: MainContract.View

    @Mock
    lateinit var dataManager: DataManager

    lateinit var mainPresenter: MainPresenter<MainContract.View>

    val mockCurrentValue = "10"
    val mockHundredValue = "100"
    val mockZeroValue = "0"

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mainPresenter = MainPresenter(dataManager, compositeDisposable)
        mainPresenter.onAttach(mainView)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun testCalCPress() {
        mainPresenter.onCalCPress()
        verify(mainView).setCurrentValue("0")
    }

    @Test
    fun testCalZeroPress() {
        mainPresenter.onCalZeroPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "0")
    }

    @Test
    fun testCalZeroPressThousandValue() {
        mainPresenter.onCalZeroPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,000")
    }

    @Test
    fun testCalZeroPressOnDotValue() {
        mainPresenter.onCalZeroPress("10.")
        verify(mainView).setCurrentValue("10.0")
    }

    @Test
    fun testCalTripleZeroPress() {
        mainPresenter.onCalTripleZeroPress(mockCurrentValue)
        verify(mainView).setCurrentValue("10,000")
    }

    @Test
    fun testCalOnePress() {
        mainPresenter.onCalOnePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "1")
    }

    @Test
    fun testCalOnePressThousandValue() {
        mainPresenter.onCalOnePress(mockHundredValue)
        verify(mainView).setCurrentValue("1,001")
    }

    @Test
    fun testCalOnePressOnDotValue() {
        mainPresenter.onCalOnePress("10.")
        verify(mainView).setCurrentValue("10.1")
    }

    @Test
    fun testCalTwoPress() {
        mainPresenter.onCalTwoPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "2")
    }

    @Test
    fun testCalTwoPressThousandValue() {
        mainPresenter.onCalTwoPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,002")
    }

    @Test
    fun testCalThreePress() {
        mainPresenter.onCalThreePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "3")
    }

    @Test
    fun testCalThreePressThousandValue() {
        mainPresenter.onCalThreePress(mockHundredValue)
        verify(mainView).setCurrentValue("1,003")
    }

    @Test
    fun testCalFourPress() {
        mainPresenter.onCalFourPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "4")
    }

    @Test
    fun testCalFourPressThousandValue() {
        mainPresenter.onCalFourPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,004")
    }

    @Test
    fun testCalFivePress() {
        mainPresenter.onCalFivePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "5")
    }

    @Test
    fun testCalFivePressThousandValue() {
        mainPresenter.onCalFivePress(mockHundredValue)
        verify(mainView).setCurrentValue("1,005")
    }

    @Test
    fun testCalSixPress() {
        mainPresenter.onCalSixPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "6")
    }

    @Test
    fun testCalSixPressThousandValue() {
        mainPresenter.onCalSixPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,006")
    }

    @Test
    fun testCalSevenPress() {
        mainPresenter.onCalSevenPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "7")
    }

    @Test
    fun testCalSevenPressThousandValue() {
        mainPresenter.onCalSevenPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,007")
    }

    @Test
    fun testCalEightPress() {
        mainPresenter.onCalEightPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "8")
    }

    @Test
    fun testCalEightPressThousandValue() {
        mainPresenter.onCalEightPress(mockHundredValue)
        verify(mainView).setCurrentValue("1,008")
    }

    @Test
    fun testCalNinePress() {
        mainPresenter.onCalNinePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "9")
    }

    @Test
    fun testCalNinePressThousandValue() {
        mainPresenter.onCalNinePress(mockHundredValue)
        verify(mainView).setCurrentValue("1,009")
    }

    @Test
    fun testCalDeletePress() {
        mainPresenter.onCalDeletePress(mockCurrentValue)
        verify(mainView).setCurrentValue("1")
    }

    @Test
    fun testCalDotPress() {
        mainPresenter.onCalDotPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + ".")
    }

    @Test
    fun testCalDotPressOnPlusValueWithDot() {
        mainPresenter.onCalDotPress("50.0+")
        verify(mainView).setCurrentValue("50.0+0.")
    }

    @Test
    fun testCalDotPressOnPlusValue() {
        mainPresenter.onCalDotPress("50.0+0")
        verify(mainView).setCurrentValue("50.0+0.")
    }

    @Test
    fun testCalDotPressOnDoubleDotValue() {
        mainPresenter.onCalDotPress("50.0+0.")
        verify(mainView).setCurrentValue("50.0+0.")
    }

    @Test
    fun testCalPlusPress() {
        mainPresenter.onCalPlusPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "+")
    }

    @Test
    fun testCalPlusPressOnPlusOperator() {
        mainPresenter.onCalPlusPress("10+")
        verify(mainView).setCurrentValue("10+")
    }

    @Test
    fun testCalMinusPress() {
        mainPresenter.onCalMinusPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "-")
    }

    @Test
    fun testCalMinusPressOnZeroValue() {
        mainPresenter.onCalMinusPress(mockZeroValue)
        verify(mainView).setCurrentValue("-")
    }

    @Test
    fun testCalMinusPressOnPlusValue() {
        mainPresenter.onCalMinusPress("10+")
        verify(mainView).setCurrentValue("10-")
    }

    @Test
    fun testCalMultiplePress() {
        mainPresenter.onCalMultiplePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "*")
    }

    @Test
    fun testCalDividePress() {
        mainPresenter.onCalDividePress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue + "/")
    }

    @Test
    fun testCalEqualPress() {
        mainPresenter.onCalEqualPress(mockCurrentValue)
        verify(mainView).setCurrentValue(mockCurrentValue)
    }

    @Test
    fun testCalEqualPressOnPlusMinusValue() {
        mainPresenter.onCalEqualPress("50-50+50")
        verify(mainView).setCurrentValue("50")
    }

    @Test
    fun testCalEqualPressOnMinusValue() {
        mainPresenter.onCalEqualPress("-50-100")
        verify(mainView).setCurrentValue("-150")
    }

    @Test
    fun testCalEqualPressOnMultipleValue() {
        mainPresenter.onCalEqualPress("5*10")
        verify(mainView).setCurrentValue("50")
    }

    @Test
    fun testCalEqualPressOnAllOperatorValue() {
        mainPresenter.onCalEqualPress("50+50*100/100-50")
        verify(mainView).setCurrentValue("50")
    }

    @Test
    fun testCalEqualPressOnThousandValuePlusOp() {
        mainPresenter.onCalEqualPress("2,000+5")
        verify(mainView).setCurrentValue("2,005")
    }

    @Test
    fun testCalEqualPressOnThousandValueMultipleOp() {
        mainPresenter.onCalEqualPress("2,000*5")
        verify(mainView).setCurrentValue("10,000")
    }
 }