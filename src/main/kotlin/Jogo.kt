import com.google.gson.annotations.SerializedName

class Jogo(@SerializedName("title") val titulo: String,
           @SerializedName("thumb") val capa: String) { // construtor
    val descricao = ""

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descrição: $descricao \n"
    }
}