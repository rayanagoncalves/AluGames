package br.com.rayanagoncalves.alugames.utilitario

import br.com.rayanagoncalves.alugames.modelo.Gamer
import br.com.rayanagoncalves.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}