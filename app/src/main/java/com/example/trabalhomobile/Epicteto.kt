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

        val txtNomeFilme: TextView = findViewById(R.id.txtNomeFilme)
        val imgFilme: ImageView = findViewById(R.id.imgFilme)
        val txtDescricaoFilme: TextView = findViewById(R.id.txtDescricaoFilme)
        val btnVoltar : Button = findViewById(R.id.btnVoltar)

        // Recebe os dados passados pela Intent
        val tituloFilme = intent.getStringExtra("titulo_filme")
        val descricaoFilme = intent.getStringExtra("descricao_filme")
        val imagemFilme = intent.getIntExtra("imagem_filme", R.drawable.ic_launcher_foreground) // Imagem padrão se não vier nada

        // Configura os componentes com os dados recebidos
        txtNomeFilme.text = tituloFilme ?: "Título não disponível"
        txtDescricaoFilme.text = descricaoFilme ?: "Descrição não disponível"
        imgFilme.setImageResource(imagemFilme)

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
