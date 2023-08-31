package br.com.rayanagoncalves.alugames.modelo

import br.com.rayanagoncalves.alugames.utilitario.formatoComDuasCasasDecimais
import java.math.BigDecimal

class PlanoAvulso(
    tipo: String): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        var valorOriginal = super.obterValor(aluguel)

        if(aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal.multiply(BigDecimal(0.1))
        }

        return valorOriginal.formatoComDuasCasasDecimais()
    }

}
