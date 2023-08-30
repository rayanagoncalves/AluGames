package br.com.rayanagoncalves.alugames.principal

import br.com.rayanagoncalves.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()

    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}