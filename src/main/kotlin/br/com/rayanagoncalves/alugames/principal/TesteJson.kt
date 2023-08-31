package br.com.rayanagoncalves.alugames.principal

import br.com.rayanagoncalves.alugames.modelo.Periodo
import br.com.rayanagoncalves.alugames.modelo.PlanoAssinatura
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

 //   println(gamerCaroline.jogosDoMes(7))

  //  println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugarJogo(jogoResidenteVillage, periodo1)
    gamerCamila.alugarJogo(jogoSpider, periodo2)
    gamerCamila.alugarJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugarJogo(jogoTheLastOfUs, periodo3)

 //   println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)

   // println(gamerCamila)

    gamerCamila.alugarJogo(jogoResidenteVillage, periodo1)
 //   println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidenteVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerCaroline.recomendarJogo(jogoResidenteVillage, 8)
    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

    println("Recomendações da Camila")
    println(gamerCamila.jogosRecomendados)
    println("Recomendações da Caroline")
    println(gamerCaroline.jogosRecomendados)
}
