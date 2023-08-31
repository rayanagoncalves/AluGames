package br.com.rayanagoncalves.alugames.modelo

import br.com.rayanagoncalves.alugames.utilitario.formatoComDuasCasasDecimais
import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo(@Expose val titulo: String,
                @Expose val capa: String): Recomendavel { // construtor
    var descricao:String? = null
    var preco = BigDecimal("0.0")
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if(!validarNota(nota)) {
            println("Nota inválida. A nota precisa ser entre 1 e 10.")
        } else {
            listaNotas.add(nota)
        }
    }

    constructor(titulo: String, capa: String, preco: BigDecimal, descricao: String):
            this(titulo, capa) {
                 this.preco = preco.formatoComDuasCasasDecimais()
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