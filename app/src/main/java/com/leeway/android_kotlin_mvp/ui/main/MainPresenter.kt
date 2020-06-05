package com.leeway.android_kotlin_mvp.ui.main

import com.leeway.android_kotlin_mvp.data.DataManager
import com.leeway.android_kotlin_mvp.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by Lee Lorz on 7/15/2017.
 */
class MainPresenter<V: MainContract.View>
@Inject
constructor(dataManager: DataManager,
            compositeDisposable: CompositeDisposable) :
        BasePresenter<V>(dataManager, compositeDisposable), MainContract.Presenter<V> {

    override fun onCalCPress() {
        mvpView!!.setCurrentValue("0")
    }

    override fun onCalZeroPress(currentAmount: String) {
        setCalValue(currentAmount, "0")
    }

    override fun onCalTripleZeroPress(currentAmount: String) {
        setCalValue(currentAmount, "000")
    }

    override fun onCalOnePress(currentAmount: String) {
        setCalValue(currentAmount, "1")
    }

    override fun onCalTwoPress(currentAmount: String) {
        setCalValue(currentAmount, "2")
    }

    override fun onCalThreePress(currentAmount: String) {
        setCalValue(currentAmount, "3")
    }

    override fun onCalFourPress(currentAmount: String) {
        setCalValue(currentAmount, "4")
    }

    override fun onCalFivePress(currentAmount: String) {
        setCalValue(currentAmount, "5")
    }

    override fun onCalSixPress(currentAmount: String) {
        setCalValue(currentAmount, "6")
    }

    override fun onCalSevenPress(currentAmount: String) {
        setCalValue(currentAmount, "7")
    }

    override fun onCalEightPress(currentAmount: String) {
        setCalValue(currentAmount, "8")
    }

    override fun onCalNinePress(currentAmount: String) {
        setCalValue(currentAmount, "9")
    }

    override fun onCalDotPress(currentAmount: String) {
        if (currentAmount.contains(".")) {
            val numberSplitByOp = currentAmount.split("(?<=[-+*/=])".toRegex())
            if (numberSplitByOp.last().isEmpty() &&
                    numberSplitByOp[numberSplitByOp.lastIndex-1].matches(".*[-+*/=].*".toRegex())) {
              mvpView!!.setCurrentValue(currentAmount + "0.")
            } else {
                if (numberSplitByOp.last().contains(".")) {
                    mvpView!!.setCurrentValue(currentAmount)
                } else {
                    mvpView!!.setCurrentValue(currentAmount + ".")
                }
            }
        } else {
            mvpView!!.setCurrentValue(setMoneyStringFormat(currentAmount + "."))
        }
    }

    override fun onCalDeletePress(currentAmount: String) {
        val size = currentAmount.length
        if (size > 1) {
            val newAmount = currentAmount.substring(0, size - 1)
            mvpView!!.setCurrentValue(setMoneyStringFormat(newAmount))
        } else {
            mvpView!!.setCurrentValue("0")
        }
    }

    override fun onCalPlusPress(currentAmount: String) {
        setOperator(currentAmount, '+')
    }

    override fun onCalMinusPress(currentAmount: String) {
        setOperator(currentAmount, '-')
    }

    override fun onCalMultiplePress(currentAmount: String) {
        setOperator(currentAmount, '*')
    }

    override fun onCalDividePress(currentAmount: String) {
        setOperator(currentAmount, '/')
    }

    override fun onCalEqualPress(currentAmount: String) {
        if (currentAmount.matches(".*[*/].*".toRegex())) {
            val numberSplitByOp = currentAmount.replace(",","").split("(?<=[-+*/=])".toRegex())
            val result = calculateMultipleDivideValue(numberSplitByOp)
            mvpView!!.setCurrentValue(result)
        } else if (currentAmount.matches(".*[-+].*".toRegex())){
            val numberSplitByOp = currentAmount.replace(",","").split("(?<=[-+*/=])".toRegex())
            val result = calculatePlusMinusValue(numberSplitByOp)
            mvpView!!.setCurrentValue(result)
        } else {
            mvpView!!.setCurrentValue(currentAmount)
        }
    }

    private fun calculateMultipleDivideValue(numberList: List<String>): String {
        var beforeNum: Double = 1.0
        var currentOp = ""
        val plusMinusNum = ArrayList<String>()
        for (number in numberList) {
            if (number.matches(".*[-+].*".toRegex()) && currentOp == ""
                    || !number.matches(".*[-+*/=].*".toRegex()) && currentOp == "") {
                plusMinusNum.add(number)
                continue
            }

            val curNum = java.lang.Double.parseDouble(number.replace("*", "")
                    .replace("/", "")
                    .replace("+", "")
                    .replace("-", ""))
            if (currentOp != "") {
                if (currentOp == "*") {
                    beforeNum *= curNum
                } else {
                    beforeNum /= curNum
                }
            } else {
                beforeNum = curNum
            }
            currentOp = if (number.contains("*")) "*" else "/"
            if (number.matches(".*[-+].*".toRegex())) {
                currentOp = if (number.contains("+")) "+" else "-"
                plusMinusNum.add(beforeNum!!.toString() + currentOp)
                currentOp = ""
                beforeNum = 1.0
            } else if (!number.matches(".*[-+*/=].*".toRegex())) {
                plusMinusNum.add(beforeNum!!.toString() + "")
            }
        }
        val calculatedValue = calculatePlusMinusValue(plusMinusNum)
        return calculatedValue
    }

    private fun calculatePlusMinusValue(numberList: List<String>): String {
        var beforeNum: Double = 0.0
        var currentOp = ""
        for (number in numberList) {
            if (number == "-") {
                currentOp = "-"
                continue
            }
            val curNum = java.lang.Double.parseDouble(number.replace("+", "").replace("-", ""))
            if (currentOp != "") {
                if (currentOp == "+") {
                    beforeNum += curNum
                } else {
                    beforeNum -= curNum
                }
            } else {
                beforeNum = curNum
            }

            currentOp = if (number.contains("+")) "+" else "-"
        }
        return doubleToFormatString(beforeNum)
    }

    private fun setOperator(currentAmount: String, operator: Char) {
        when (currentAmount.last()) {
            '+','-','*','/' -> {
                val newVal = currentAmount.slice(0..currentAmount.lastIndex-1) + operator
                mvpView!!.setCurrentValue(newVal)
            }
            else -> {
                if (currentAmount == "0" && operator == '-') {
                    mvpView!!.setCurrentValue(operator.toString())
                } else {
                    mvpView!!.setCurrentValue(currentAmount + operator)
                }
            }
        }
    }

    private fun setCalValue(currentAmount: String, setValue: String) {
        if (currentAmount == "0") {
            if (setValue == "000") {
                mvpView!!.setCurrentValue("0")
            } else {
                mvpView!!.setCurrentValue(setMoneyStringFormat(setValue))
            }
        } else {
            mvpView!!.setCurrentValue(setMoneyStringFormat(currentAmount + setValue))
        }
    }

    private fun setMoneyStringFormat(value: String): String {
        var numbers = value.split("(?<=[-+*/=])".toRegex()).toMutableList()
        var lastNumber = numbers.last()
        var lastIndex = numbers.lastIndex
        if (lastNumber.isEmpty()) {
            lastNumber = numbers[numbers.lastIndex-1]
            lastIndex = numbers.lastIndex - 1
        }
        if (!lastNumber.matches(".*[-+*/=].*".toRegex())) {
            numbers[lastIndex] = getNumberFormat(numbers[lastIndex].replace(",", ""))
        }

        var returnValue = ""
        for (number in numbers) {
            returnValue += number
        }

        return returnValue
    }

    private fun getNumberFormat(value: String): String {
        var intValue = value
        var decValue = ""
        if (value.contains(".")) {
            val numValue = value.split("\\.".toRegex())
            intValue = numValue.first()
            if (numValue.size > 1) decValue = numValue[1]
        }

        val doubleValue = intValue.toDouble()
        val formatValue = if (value.contains(".")) doubleToFormatString(doubleValue) + "." + decValue
                          else doubleToFormatString(doubleValue)
        return formatValue
    }

    private fun doubleToFormatString(value: Double): String {
        val decimalFormat = DecimalFormat("#,###,###,###.##")
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(value)
    }
}
