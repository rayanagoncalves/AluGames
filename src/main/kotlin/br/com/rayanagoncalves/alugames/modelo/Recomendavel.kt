package br.com.rayanagoncalves.alugames.modelo

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)

    fun validarNota(nota:Int): Boolean {
        return nota in 1..10
    }
}