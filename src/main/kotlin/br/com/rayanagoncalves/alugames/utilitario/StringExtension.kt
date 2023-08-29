package br.com.rayanagoncalves.alugames.utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0

    val resultado = kotlin.runCatching {
        val dataNascimento = LocalDate.parse(this, formatador)
        val hoje = LocalDate.now()

        idade = Period.between(dataNascimento, hoje).years
    }

    resultado.onFailure {
        return idade
    }

    return idade
}