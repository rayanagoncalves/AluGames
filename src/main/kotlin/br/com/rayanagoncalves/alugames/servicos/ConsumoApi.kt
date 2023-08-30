package br.com.rayanagoncalves.alugames.servicos

import br.com.rayanagoncalves.alugames.modelo.Gamer
import br.com.rayanagoncalves.alugames.modelo.InfoGamerJson
import br.com.rayanagoncalves.alugames.modelo.InfoJogoJson
import br.com.rayanagoncalves.alugames.modelo.Jogo
import br.com.rayanagoncalves.alugames.utilitario.criaGamer
import br.com.rayanagoncalves.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun consomeDados(endereco: String): HttpResponse<String> {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        return client.send(request, HttpResponse.BodyHandlers.ofString())
    }

    fun buscaJogo(id: String): HttpResponse<String> {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        return consomeDados(endereco)
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val response = consomeDados(endereco)

        val json = response.body()

        val gson = Gson()

        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGamerConvertida
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val response = consomeDados(endereco)

        val json = response.body()

        val gson = Gson()

        val meuJogoTipo = object: TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }
}