package br.com.rayanagoncalves.alugames.modelo

import br.com.rayanagoncalves.alugames.utilitario.formatoComDuasCasasDecimais
import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size+1

        return if (totalJogosNoMes <= jogosIncluidos) {
            BigDecimal.ZERO
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if(aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal.multiply(BigDecimal(percentualDescontoReputacao))
            }
            valorOriginal.formatoComDuasCasasDecimais()
        }
    }
}
