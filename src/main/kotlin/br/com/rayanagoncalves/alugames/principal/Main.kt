import br.com.rayanagoncalves.alugames.modelo.Gamer
import br.com.rayanagoncalves.alugames.modelo.InfoJogo
import br.com.rayanagoncalves.alugames.modelo.Jogo
import br.com.rayanagoncalves.alugames.servicos.ConsumoApi
import br.com.rayanagoncalves.alugames.utilitario.transformarEmIdade
import com.google.gson.Gson
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro realizado com sucesso. Dados do gamer:")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())
    do {
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

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("S", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por título: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false // elvis operator
    }

    println("\nJogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\n Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()

        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.")
}