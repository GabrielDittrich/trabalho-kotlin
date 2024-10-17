package com.example.trabalhomobile

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Filme(val titulo: String, val descricao: String, val descricaoDetalhada: String, val imagemResId: Int)


class FilmeAdapter(private val context: Context, private val filmes: List<Filme>) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false)
        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.bind(filme)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Epicteto::class.java)
            intent.putExtra("titulo_filme", filme.titulo)
            intent.putExtra("descricao_filme", filme.descricaoDetalhada)
            intent.putExtra("imagem_filme", filme.imagemResId)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        private val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
        private val imgFilme: ImageView = itemView.findViewById(R.id.imgFilme)

        fun bind(filme: Filme) {
            txtTitulo.text = filme.titulo
            txtDescricao.text = filme.descricao
            imgFilme.setImageResource(filme.imagemResId)
        }

    }
}
