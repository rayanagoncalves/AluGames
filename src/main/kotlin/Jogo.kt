data class Jogo(val titulo: String,
           val capa: String) { // construtor
    val descricao = ""

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n"
    }
}