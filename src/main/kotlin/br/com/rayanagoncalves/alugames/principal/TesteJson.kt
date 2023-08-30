package br.com.rayanagoncalves.alugames.principal

import br.com.rayanagoncalves.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()

    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogosJson()

//    println(listaGamers)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidenteVillage = listaJogos.get(10)

    println(gamerCaroline)
    println(jogoResidenteVillage)

    var aluguel = gamerCaroline.alugaJogo(jogoResidenteVillage)

    println(aluguel)
}