package com.example.trabalhomobile

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetalheFilmeActivity : AppCompatActivity() {
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_filme)

        // Recuperar os dados do Intent
        val titulo = intent.getStringExtra("titulo_filme")
        val ano = intent.getStringExtra("ano_filme")
        val descricao = intent.getStringExtra("descricao_filme")
        val imagemResId = intent.getIntExtra("imagem_filme", R.drawable.ic_launcher_foreground)

        // Configurar as views com os dados recebidos
        val imgFilme = findViewById<ImageView>(R.id.imgFilmeDetalhe)
        val txtTitulo = findViewById<TextView>(R.id.txtTituloFilme)
        val txtAno = findViewById<TextView>(R.id.txtAnoFilme)
        val txtDescricao = findViewById<TextView>(R.id.txtDescricaoFilme)

        imgFilme.setImageResource(imagemResId)
        txtTitulo.text = titulo
        txtAno.text = ano
        txtDescricao.text = descricao

        btnVoltar = findViewById(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}
