package br.com.rayanagoncalves.alugames.modelo

import java.util.*

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
    var idInterno: String? = null

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email) {
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                criarIdInterno()
            }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        var numero = Random().nextInt(10000)
        var tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }
}
