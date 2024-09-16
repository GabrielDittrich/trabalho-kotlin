package com.example.trabalhomobile

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Epicteto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epicteto) // Certifique-se de que o layout XML está configurado corretamente

        val txtNomeLivro: TextView = findViewById(R.id.txtNomeLivro)
        val imgLivro: ImageView = findViewById(R.id.imgLivro)
        val txtDescricaoLivro: TextView = findViewById(R.id.txtDescricaoLivro)
        val btnVoltar : Button = findViewById(R.id.btnVoltar)

        // Recebe os dados passados pela Intent
        val tituloLivro = intent.getStringExtra("titulo_livro")
        val descricaoLivro = intent.getStringExtra("nome_livro")
        val imagemLivro = intent.getIntExtra("imagem_livro", R.drawable.ic_launcher_foreground) // Imagem padrão se não vier nada

        // Configura os componentes com os dados recebidos
        txtNomeLivro.text = tituloLivro ?: "Título não disponível"
        txtDescricaoLivro.text = descricaoLivro ?: "Descrição não disponível"
        imgLivro.setImageResource(imagemLivro)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
