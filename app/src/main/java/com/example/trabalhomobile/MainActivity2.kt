package com.example.trabalhomobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var filmeAdapter: FilmeAdapter
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
        val filmes = listOf(
            Filme("\tWall-e", "\t\tPrólogo", "Apresenta a história de um planeta Terra devastado pela poluição e pelo lixo acumulado pela humanidade. A humanidade abandonou o planeta e passou a viver em uma nave, deixando robôs para limpar o local. \n\n" +
                    "O personagem principal, Wall-E, é o último robô do seu modelo e se dedica a compactar o lixo e a coletar objetos curiosos. Até que um dia, uma nave traz Eva, um novo robô, que se apaixona por Wall-E. \n\n" +
                    "O filme Wall-E é uma reflexão sobre o consumismo desenfreado, a poluição, o descarte inadequado de resíduos e o esgotamento dos recursos naturais. Ele também aborda o uso da tecnologia como substituição da mão de obra humana e os reflexos negativos da comunicação exclusiva pelas redes sociais. ", R.drawable.walle),

            Filme("\tMotoqueiros Selvagens", "\t\tPrólogo", "A estrada aberta... um símbolo de liberdade, de aventuras desconhecidas e de sonhos que se escondem além do horizonte. Para muitos, ela representa a fuga do cotidiano, o refúgio de uma vida de responsabilidades e compromissos. Para quatro amigos de meia-idade — Doug, Woody, Bobby e Dudley — a estrada era exatamente o que eles precisavam, embora talvez ainda não soubessem disso.\n" +
                    "\n" +
                    "Cada um deles estava preso em suas próprias rotinas: Doug, o dentista estressado e pai de família, sentia-se engolido pela monotonia do trabalho; Woody, o ex-executivo arrogante, estava falido e fingindo manter seu estilo de vida glamoroso; Bobby, o encanador frustrado, vivia sufocado pelas cobranças de sua esposa; e Dudley, o programador socialmente desajeitado, sonhava em encontrar coragem para viver mais intensamente.\n" +
                    "\n" +
                    "Juntos, eles formavam os \"Wild Hogs\", um grupo de motociclistas amadores que passavam mais tempo fantasiando sobre aventuras do que realmente vivendo-as. Mas quando a crise da meia-idade bate à porta, a decisão de embarcar em uma viagem pelo coração dos Estados Unidos parece a oportunidade perfeita para reencontrar a faísca de suas juventudes perdidas.\n" +
                    "\n" +
                    "O que começa como uma simples viagem de moto logo se transforma em algo maior do que imaginavam. A estrada, com seus desafios e surpresas, os leva não apenas a confrontos com gangues de verdadeiros motoqueiros, mas também ao encontro de suas próprias fragilidades e sonhos esquecidos.\n"
                    , R.drawable.motoqueiros),
            Filme(
                "\tO Poderoso Chefão",
                "\t\tPrólogo",
                "No coração da cidade de Nova York, onde a luz e a escuridão se entrelaçam, a família Corleone reina suprema. Dominando o submundo do crime organizado, Don Vito Corleone, conhecido como \"O Poderoso Chefão\", é um homem de poder e respeito, que conduz seus negócios com uma mistura de firmeza e sabedoria. Para ele, a honra e a lealdade são fundamentais, e sua palavra é lei.\n" +
                        "\n" +
                        "Por trás da fachada de um respeitável proprietário de uma loja de flores, Vito Corleone é, na verdade, o líder de um dos mais temidos e influentes impérios do crime. Sua influência se estende por diversos aspectos da sociedade, desde políticos até empresários, todos lhe devotando respeito e, muitas vezes, gratidão. No entanto, esse mundo de poder é repleto de traições, rivalidades e ambições, onde até mesmo a família mais unida pode ser colocada à prova.\n" +
                        "\n" +
                        "À medida que a história se desenrola, os filhos de Vito — Sonny, Fredo e Michael — enfrentam os desafios de um legado construído sobre o sangue e a violência. Enquanto Sonny é impulsivo e agressivo, Fredo é fraco e inseguro, mas Michael, o filho mais novo, é o mais astuto e determinado. Relutante em se envolver nos negócios da família, Michael logo se vê atraído para o mundo sombrio de seu pai, onde a lealdade é testada e o destino de todos está em jogo.\n" +
                        "\n" +
                        "\"O Poderoso Chefão\" é uma narrativa épica sobre poder, traição e a complexidade dos laços familiares. Em um mundo onde os valores são distorcidos e as alianças mudam rapidamente, a luta pela sobrevivência e pelo respeito é constante. Este é o início de uma saga que mostrará como a ambição e a lealdade podem se entrelaçar em um drama de consequências inimagináveis.",
                R.drawable.chefao
            ),

            Filme(
                "\tO Alquimista",
                "\t\tPrólogo",
                "Durante os anos mais sombrios da Segunda Guerra Mundial, a Europa está envolta em um manto de terror e opressão sob o regime nazista. Enquanto a sombra do Terceiro Reich se espalha, um grupo de soldados americanos conhecido como os \"Bastardos Inglórios\" surge das cinzas da brutalidade e da injustiça. Comandados pelo Tenente Aldo Raine, esses guerreiros não são apenas lutadores; eles são caçadores de nazistas, determinados a infligir terror nas fileiras inimigas.\n" +
                        "\n" +
                        "Aldo Raine, com seu chapéu de cowboy e um histórico de vingança contra os nazistas, lidera sua equipe em uma missão que desafia todas as convenções da guerra. Cada membro do grupo traz consigo um passado sombrio, mas unidos pelo desejo de justiça e pela ânsia de vingança, eles se tornam uma força implacável em um campo de batalha que é tão moral quanto físico.\n" +
                        "\n" +
                        "Enquanto isso, na França ocupada, uma jovem judia chamada Shosanna Dreyfus testemunha o massacre de sua família pelas mãos dos nazistas. Movida por um desejo insaciável de vingança, Shosanna se transforma em uma figura-chave na luta contra a opressão, preparando-se para criar um plano que irá mudar o curso da guerra.\n" +
                        "\n" +
                        "\"Bastardos Inglórios\" é uma narrativa repleta de ação e reviravoltas, onde a guerra se torna um campo de batalha não apenas entre nações, mas entre ideais e moralidades. Em meio a uma teia de traições, alianças improváveis e o anseio por vingança, os caminhos de Aldo Raine e Shosanna Dreyfus eventualmente se cruzam, prometendo um confronto explosivo com consequências inimagináveis.\n"
                        ,
                R.drawable.inglorios
            )
        )


        filmeAdapter = FilmeAdapter(this, filmes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = filmeAdapter

        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
