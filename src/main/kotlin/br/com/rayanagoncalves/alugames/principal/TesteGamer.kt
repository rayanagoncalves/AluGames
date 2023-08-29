package br.com.rayanagoncalves.alugames.principal

import br.com.rayanagoncalves.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Rayana", "rayana@email.com")
    println(gamer1)

    val gamer2 = Gamer("Ana", "ana@email.com", "12/12/1998", "ana12")
    println(gamer2)

    gamer1.let { // scope function
        it.dataNascimento = "12/05/1999"
        it.usuario = "rayanacunha"
    }

    println(gamer1)
}