package br.com.rayanagoncalves.alugames.principal

import br.com.rayanagoncalves.alugames.modelo.Periodo
import br.com.rayanagoncalves.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()

    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogosJson()

//    println(listaGamers)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidenteVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)

//    println(gamerCaroline)
//    println(jogoResidenteVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alugaJogo(jogoResidenteVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)

    println(gamerCaroline.jogosAlugados)
}