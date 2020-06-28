package com.w.detalle.util

import java.text.DecimalFormat
import java.text.NumberFormat

object FormatUtil {


    fun getNumberFormat(price : Int) : String{
        val formatter: NumberFormat = DecimalFormat("#,###")
        return "$" + formatter.format(price).replace(',', '.')
    }
}