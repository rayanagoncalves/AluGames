package br.com.rayanagoncalves.alugames.utilitario

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun Double.formatoComDuasCasasDecimais(): Double {
    val decimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))

    return decimalFormat.format(this).toDouble()
}