package br.com.rayanagoncalves.alugames.modelo

data class Jogo(val titulo: String,
                val capa: String) { // construtor
    var descricao:String? = null
    var preco = 0.0

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
                 this.preco = preco
                 this.descricao = descricao
            }

    override fun toString(): String {
        return "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n" +
                "Preço: $preco \n"
    }
}