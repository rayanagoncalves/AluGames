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
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()

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

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    companion object { // alternativa para os métodos estáticos do java
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome: ")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? S/N")
            val opcao = leitura.nextLine()

            if(opcao.equals("s", true)) {
                println("Digite seu usuário:")
                val usuario = leitura.nextLine()
                println("Digite sua data de nascimento: (DD/MM/AAAA)")
                val dataNascimento = leitura.nextLine()

                return Gamer(nome, email, dataNascimento, usuario)
            }

            return Gamer(nome, email)
        }
    }
}
