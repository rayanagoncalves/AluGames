package br.com.rayanagoncalves.alugames.modelo

open class Plano( // a palavra reservada open é usada para indicar que a classe está aberta para ser herdada
    val tipo: String
) {

    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}