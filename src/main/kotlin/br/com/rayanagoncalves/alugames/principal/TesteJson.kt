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
    val periodo4 = Periodo(LocalDate.of(2023,7,2), LocalDate.of(2023,7,15))

    gamerCaroline.alugarJogo(jogoResidenteVillage, periodo1)
    gamerCaroline.alugarJogo(jogoSpider, periodo2)
    gamerCaroline.alugarJogo(jogoTheLastOfUs, periodo3)
    gamerCaroline.alugarJogo(jogoSpider, periodo4)

    println(gamerCaroline.jogosDoMes(7))

   // println(gamerCaroline.jogosAlugados)
}