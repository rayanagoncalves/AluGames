package br.com.rayanagoncalves.alugames.modelo

sealed class Plano(val tipo: String) { // sealed class segue o mesmo conceito da classe abstrata, ou seja, nao pode ser instanciada, mas a diferença é que ela só pode ser herdada por classes que estejam no mesmo pacote

    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}