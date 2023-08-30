package br.com.rayanagoncalves.alugames.servicos

import br.com.rayanagoncalves.alugames.modelo.Gamer
import br.com.rayanagoncalves.alugames.modelo.InfoGamerJson
import br.com.rayanagoncalves.alugames.utilitario.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String): HttpResponse<String> {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        return client
            .send(request, HttpResponse.BodyHandlers.ofString())
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        val meuGamerTipo = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGamerConvertida
    }
}