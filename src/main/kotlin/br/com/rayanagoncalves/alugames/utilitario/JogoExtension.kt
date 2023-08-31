package br.com.rayanagoncalves.alugames.utilitario

import br.com.rayanagoncalves.alugames.modelo.InfoJogoJson
import br.com.rayanagoncalves.alugames.modelo.Jogo
import java.math.BigDecimal

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, BigDecimal(this.preco), this.descricao)
}