package br.com.rayanagoncalves.alugames.utilitario

import br.com.rayanagoncalves.alugames.modelo.InfoJogoJson
import br.com.rayanagoncalves.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}