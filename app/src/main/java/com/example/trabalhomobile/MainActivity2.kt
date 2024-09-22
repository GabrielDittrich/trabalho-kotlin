package com.example.trabalhomobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var livroAdapter: LivroAdapter
    private lateinit var btnVoltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtTituloNome : TextView = findViewById(R.id.txtTituloNome)
        val nome = intent.getStringExtra("NOME_USUARIO")

        txtTituloNome.text = if (nome.isNullOrEmpty()) {
            "Nenhum nome recebido"
        } else {
            "Bem-vindo, $nome!"
        }

        recyclerView = findViewById(R.id.recyclerView)

        // Criar uma lista de livros para exibir
        val livros = listOf(
            Livro(" \t\tO Manual de Epicteto", "Prólogo Manual de Epicteto", "O \"Manual de Epicteto\" (ou Enchiridion) é uma compilação dos ensinamentos de Epicteto, um dos principais filósofos do estoicismo. Ele não escreveu diretamente esse manual; em vez disso, o conteúdo foi registrado por um de seus alunos, Arriano, por volta do século II d.C. O estoicismo, filosofia à qual Epicteto aderiu, busca ensinar o indivíduo a viver de forma virtuosa, independente de circunstâncias externas.\n" +
                    "\n" +
                    "\t\tO prólogo do \"Manual de Epicteto\" geralmente estabelece o princípio fundamental do estoicismo: a distinção entre o que está sob nosso controle e o que não está. Epicteto argumenta que devemos focar apenas no que podemos controlar (como nossas ações, pensamentos e emoções) e aceitar serenamente o que não podemos controlar (como eventos externos, a opinião dos outros e a morte). Essa atitude nos permite viver uma vida em paz e de acordo com a natureza.\n" +
                    "\n" +
                    "\t\tUm dos pontos centrais do prólogo é a noção de que, ao controlar nossas reações e nos desapegar do que não podemos controlar, encontramos a verdadeira liberdade e felicidade.'.", R.drawable.epicteto),

            Livro(" \t\tApologia de Sócrates", "Prólogo Apologia de Sócrates", "O prólogo da \"Apologia de Sócrates\", escrita por Platão, é uma introdução ao discurso de defesa que Sócrates faz diante do tribunal ateniense. Ele foi acusado de corromper a juventude e de impiedade, por não acreditar nos deuses da cidade e por introduzir novos deuses.\n" +
                    "\n" +
                    "\t\tNo início da obra, Sócrates se dirige aos juízes (seus acusadores e o povo ateniense) dizendo que não irá recorrer a discursos artificiais, ornamentos retóricos ou estratégias emocionais para se defender, como era comum nos tribunais da época. Ele afirma que irá falar da maneira simples e honesta com que sempre falou, buscando a verdade, e pede que o julguem pelo conteúdo de suas palavras, não pelo estilo de sua defesa.\n" +
                    "\n" +
                    "\t\tSócrates também destaca que, embora esteja ali para se defender das acusações, sua vida inteira foi dedicada à busca do conhecimento e à filosofia, o que, em sua visão, já é uma espécie de defesa natural. Ele sugere que sua missão é cumprir o oráculo de Delfos, que afirmou que ele era o homem mais sábio de Atenas, justamente porque sabia que nada sabia. Com isso, Sócrates já começa a descontruir a posição de seus acusadores, abrindo caminho para sua argumentação filosófica ao longo da defesa.'.", R.drawable.socrates)
        )


        livroAdapter = LivroAdapter(this, livros)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = livroAdapter

        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
