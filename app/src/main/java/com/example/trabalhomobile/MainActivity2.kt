package com.example.trabalhomobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLivro1: ImageButton = findViewById(R.id.btnLivro1)
        val btnLivro2: ImageButton = findViewById(R.id.btnLivro2)

        val txtTituloNome : TextView = findViewById(R.id.txtTituloNome)
        val btnLogout : Button = findViewById(R.id.btnLogout)


        val nome = intent.getStringExtra("NOME_USUARIO")

        txtTituloNome.text = if (nome.isNullOrEmpty()) {
            "Nenhum nome recebido"
        } else {
            "Bem-vindo, $nome!"
        }

        val novaTela = Intent(this, Epicteto::class.java)


        btnLivro1.setOnClickListener {
            novaTela.putExtra("titulo_livro", "O Manual de Epicteto (ou Enchiridion) ...") // Título do livro
            novaTela.putExtra("nome_livro", "O \"Manual de Epicteto\" (ou Enchiridion) é uma compilação dos ensinamentos de Epicteto, um dos principais filósofos do estoicismo. Ele não escreveu diretamente esse manual; em vez disso, o conteúdo foi registrado por um de seus alunos, Arriano, por volta do século II d.C. O estoicismo, filosofia à qual Epicteto aderiu, busca ensinar o indivíduo a viver de forma virtuosa, independente de circunstâncias externas.\n" +
                    "\n" +
                    "O prólogo do \"Manual de Epicteto\" geralmente estabelece o princípio fundamental do estoicismo: a distinção entre o que está sob nosso controle e o que não está. Epicteto argumenta que devemos focar apenas no que podemos controlar (como nossas ações, pensamentos e emoções) e aceitar serenamente o que não podemos controlar (como eventos externos, a opinião dos outros e a morte). Essa atitude nos permite viver uma vida em paz e de acordo com a natureza.\n" +
                    "\n" +
                    "Um dos pontos centrais do prólogo é a noção de que, ao controlar nossas reações e nos desapegar do que não podemos controlar, encontramos a verdadeira liberdade e felicidade.") // Descrição do livro

            novaTela.putExtra("imagem_livro", R.drawable.epicteto) // Imagem do livro (deve estar no drawable)
            startActivity(novaTela) // Iniciar a nova Activity
        }


        btnLivro2.setOnClickListener {
            novaTela.putExtra("titulo_livro", "Apologia de Sócrates") // Título do livro 2
            novaTela.putExtra("nome_livro", "O prólogo da \"Apologia de Sócrates\", escrita por Platão, é uma introdução ao discurso de defesa que Sócrates faz diante do tribunal ateniense. Ele foi acusado de corromper a juventude e de impiedade, por não acreditar nos deuses da cidade e por introduzir novos deuses.\n" +
                    "\n" +
                    "No início da obra, Sócrates se dirige aos juízes (seus acusadores e o povo ateniense) dizendo que não irá recorrer a discursos artificiais, ornamentos retóricos ou estratégias emocionais para se defender, como era comum nos tribunais da época. Ele afirma que irá falar da maneira simples e honesta com que sempre falou, buscando a verdade, e pede que o julguem pelo conteúdo de suas palavras, não pelo estilo de sua defesa.\n" +
                    "\n" +
                    "Sócrates também destaca que, embora esteja ali para se defender das acusações, sua vida inteira foi dedicada à busca do conhecimento e à filosofia, o que, em sua visão, já é uma espécie de defesa natural. Ele sugere que sua missão é cumprir o oráculo de Delfos, que afirmou que ele era o homem mais sábio de Atenas, justamente porque sabia que nada sabia. Com isso, Sócrates já começa a descontruir a posição de seus acusadores, abrindo caminho para sua argumentação filosófica ao longo da defesa.") // Descrição do livro 2
            novaTela.putExtra("imagem_livro", R.drawable.socrates) // Imagem do livro 2 (deve estar no drawable)
            startActivity(novaTela) // Iniciar a nova Activity
        }

        btnLogout.setOnClickListener {
            finish()
        }
    }
}