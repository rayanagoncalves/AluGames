package br.com.rayanagoncalves.alugames.modelo

data class Jogo(val titulo: String,
                val capa: String): Recomendavel { // construtor
    var descricao:String? = null
    var preco = 0.0
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

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
                 this.preco = preco
                 this.descricao = descricao
            }

    override fun toString(): String {
        return "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n" +
                "Preço: $preco \n" +
                "Reputação: $media"
    }
}