package br.com.rayanagoncalves.alugames.modelo

data class Jogo(val titulo: String,
                val capa: String) { // construtor
    var descricao:String? = null

    override fun toString(): String {
        return "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n"
    }
}