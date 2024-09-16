package com.example.trabalhomobile

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Livro(val titulo: String, val descricao: String, val imagemResId: Int)

class LivroAdapter(private val context: Context, private val livros: List<Livro>) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.bind(livro)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Epicteto::class.java).apply {
                putExtra("titulo_livro", livro.titulo)
                putExtra("nome_livro", livro.descricao)
                putExtra("imagem_livro", livro.imagemResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return livros.size
    }

    class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        private val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
        private val imgLivro: ImageView = itemView.findViewById(R.id.imgLivro)

        fun bind(livro: Livro) {
            txtTitulo.text = livro.titulo
            txtDescricao.text = livro.descricao
            imgLivro.setImageResource(livro.imagemResId)
        }
    }
}
