package br.com.rayanagoncalves.alugames.utilitario

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.formatoComDuasCasasDecimais(): BigDecimal {
    return this.setScale(2, RoundingMode.HALF_EVEN)
}