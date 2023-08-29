import br.com.rayanagoncalves.alugames.modelo.InfoJogo
import br.com.rayanagoncalves.alugames.modelo.Jogo
import br.com.rayanagoncalves.alugames.servicos.ConsumoApi
import com.google.gson.Gson
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()

    val response = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val json = response.body()

        val gson = Gson()
        val informacaoJogo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()

        if(opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso.")
    }

}