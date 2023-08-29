package br.com.rayanagoncalves.alugames.modelo

import java.util.*

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value // pega o value e seta no usuário
            if(idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo>()

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email) {
                this.dataNascimento = dataNascimento
                this.usuario = usuario
                criarIdInterno()
            }

    init {
        if(this.nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco.")
        }
        this.email = this.validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criarIdInterno() {
        var numero = Random().nextInt(10000)
        var tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")

        if(!regex.matches(email)) {
            throw IllegalArgumentException("E-mail inválido.")
        }

       return email
    }
}
