package br.com.rayanagoncalves.alugames.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    val valorDoAluguel = jogo.preco * Period.between(dataInicial, dataFinal).days

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} pelo valor de R$$valorDoAluguel"
    }

}
