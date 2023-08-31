package br.com.rayanagoncalves.alugames.modelo

import java.util.*

data class Gamer(var nome: String, var email: String): Recomendavel {
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
    var plano: Plano = PlanoAvulso("BRONZE")
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if(!validarNota(nota)) {
            println("Nota inválida. A nota precisa ser entre 1 e 10.")
        } else {
            listaNotas.add(nota)
        }
    }

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
        return "Gamer \n" +
                "Nome: $nome \n" +
                "E-mail= $email \n" +
                "Data de nascimento: $dataNascimento \n" +
                "Usuário: $usuario \n" +
                "Id interno: $idInterno \n" +
                "Reputação: $media"
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

    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mes: Int): List<Jogo?> {
        return jogosAlugados.filter {
            it.periodo.dataInicial.monthValue == mes
        }.map { aluguel -> aluguel.jogo}
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
