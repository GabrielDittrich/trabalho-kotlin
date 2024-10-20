package com.example.trabalhomobile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhomobile.banco.FilmeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    lateinit var filmeViewModel: FilmeViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var filmeAdapter: FilmeAdapter
    private lateinit var filmes: MutableList<Filme>
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        filmeViewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        // Inicializar a lista de filmes
        filmes = mutableListOf(
                Filme("\tWall-e", "27 de junho de 2008", "\t\tPrólogo","Apresenta a história de um planeta Terra devastado pela poluição e pelo lixo acumulado pela humanidade. A humanidade abandonou o planeta e passou a viver em uma nave, deixando robôs para limpar o local.   \n\n" +
                        "\"O personagem principal, Wall-E, é o último robô do seu modelo e se dedica a compactar o lixo e a coletar objetos curiosos. Até que um dia, uma nave traz Eva, um novo robô, que se apaixona por Wall-E. \n\n" +
                        "\"O filme Wall-E é uma reflexão sobre o consumismo desenfreado, a poluição, o descarte inadequado de resíduos e o esgotamento dos recursos naturais. Ele também aborda o uso da tecnologia como substituição da mão de obra humana e os reflexos negativos da comunicação exclusiva pelas redes sociais. ", R.drawable.walle),

                Filme("\tMotoqueiros Selvagens", "27 de fevereiro de 2007", "\t\tPrólogo","A estrada aberta... um símbolo de liberdade, de aventuras desconhecidas e de sonhos que se escondem além do horizonte. Para muitos, ela representa a fuga do cotidiano, o refúgio de uma vida de responsabilidades e compromissos. Para quatro amigos de meia-idade — Doug, Woody, Bobby e Dudley — a estrada era exatamente o que eles precisavam, embora talvez ainda não soubessem disso.\n" +
                "\"Cada um deles estava preso em suas próprias rotinas: Doug, o dentista estressado e pai de família, sentia-se engolido pela monotonia do trabalho; Woody, o ex-executivo arrogante, estava falido e fingindo manter seu estilo de vida glamoroso; Bobby, o encanador frustrado, vivia sufocado pelas cobranças de sua esposa; e Dudley, o programador socialmente desajeitado, sonhava em encontrar coragem para viver mais intensamente.\n\n" +
                "Juntos, eles formavam os \\\"Wild Hogs\\\", um grupo de motociclistas amadores que passavam mais tempo fantasiando sobre aventuras do que realmente vivendo-as.\n", R.drawable.motoqueiros),

                Filme("\tO Poderoso Chefão","7 de julho de 1972","\t\tPrólogo","No coração da cidade de Nova York, onde a luz e a escuridão se entrelaçam, a família Corleone reina suprema. Dominando o submundo do crime organizado, Don Vito Corleone, conhecido como \"O Poderoso Chefão\", é um homem de poder e respeito, que conduz seus negócios com uma mistura de firmeza e sabedoria. Para ele, a honra e a lealdade são fundamentais, e sua palavra é lei.\n\n" +
                    "Por trás da fachada de um respeitável proprietário de uma loja de flores, Vito Corleone é, na verdade, o líder de um dos mais temidos e influentes impérios do crime. Sua influência se estende por diversos aspectos da sociedade, desde políticos até empresários, todos lhe devotando respeito e, muitas vezes, gratidão. No entanto, esse mundo de poder é repleto de traições, rivalidades e ambições, onde até mesmo a família mais unida pode ser colocada à prova.\n\n",R.drawable.chefao),

            Filme("\tO Alquimista", "1988","\t\tPrólogo", "Durante os anos mais sombrios da Segunda Guerra Mundial, a Europa está envolta em um manto de terror e opressão sob o regime nazista. Enquanto a sombra do Terceiro Reich se espalha, um grupo de soldados americanos conhecido como os \"Bastardos Inglórios\" surge das cinzas da brutalidade e da injustiça. Comandados pelo Tenente Aldo Raine, esses guerreiros não são apenas lutadores; eles são caçadores de nazistas, determinados a infligir terror nas fileiras inimigas.\n\n" +
                    "Aldo Raine, com seu chapéu de cowboy e um histórico de vingança contra os nazistas, lidera sua equipe em uma missão que desafia todas as convenções da guerra. Cada membro do grupo traz consigo um passado sombrio, mas unidos pelo desejo de justiça e pela ânsia de vingança, eles se tornam uma força implacável em um campo de batalha que é tão moral quanto físico.\n\n" +
                    "Enquanto isso, na França ocupada, uma jovem judia chamada Shosanna Dreyfus testemunha o massacre de sua família pelas mãos dos nazistas.\n", R.drawable.inglorios)
        )

        val txtTituloNome: TextView = findViewById(R.id.txtTituloNome)
        val nome = intent.getStringExtra("NOME_USUARIO")

        txtTituloNome.text = if (nome.isNullOrEmpty()) {
            "Nenhum nome recebido"
        } else {
            "Bem-vindo, $nome!"
        }

        // Configurar o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        filmeAdapter = FilmeAdapter(this, filmes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = filmeAdapter

        // Configurar o botão para adicionar filmes
        val btnAddFilme = findViewById<FloatingActionButton>(R.id.btnAddFilme)
        btnAddFilme.setOnClickListener {
            showAddMovieDialog()
        }

        // Botão de voltar/logout
        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }

    // Método para exibir o diálogo de adição de filme
    private fun showAddMovieDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_movie, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val anoEditText = dialogView.findViewById<EditText>(R.id.editTextYear)
        val shortDescEditText = dialogView.findViewById<EditText>(R.id.editTextShortDescription)
        val detailedDescEditText = dialogView.findViewById<EditText>(R.id.editTextDetailedDescription)

        AlertDialog.Builder(this)
            .setTitle("Adicionar Novo Filme")
            .setView(dialogView)
            .setPositiveButton("Adicionar") { dialog, _ ->
                val title = titleEditText.text.toString()
                val year = anoEditText.text.toString()
                val shortDesc = shortDescEditText.text.toString()
                val detailedDesc = detailedDescEditText.text.toString()

                if (title.isNotEmpty() && year.isNotEmpty()) {
                    // Adicionar novo filme à lista
                    val newMovie = Filme(title, year, shortDesc, detailedDesc, R.drawable.ic_launcher_foreground)
                    filmes.add(newMovie)
                    filmeAdapter.notifyItemInserted(filmes.size - 1) // Notificar o adapter que o item foi adicionado

                    dialog.dismiss()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()
            .show()
    }
}
