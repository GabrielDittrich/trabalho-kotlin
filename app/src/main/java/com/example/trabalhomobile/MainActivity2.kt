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
            Livro("O Manual de Epicteto", "Descrição do livro sobre Epicteto", R.drawable.epicteto),
            Livro("Apologia de Sócrates", "Descrição do livro sobre Sócrates", R.drawable.socrates)
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
