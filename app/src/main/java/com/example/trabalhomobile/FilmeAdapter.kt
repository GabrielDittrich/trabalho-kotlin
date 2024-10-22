package com.example.trabalhomobile

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhomobile.banco.Filme

class FilmeAdapter(
    private val context: Context,
    private val filmes: MutableList<Filme>,
    private val onDeleteClick: (Filme) -> Unit, // Função lambda para manipular a exclusão
    private val onEditClick: (Filme) -> Unit // Função lambda para manipular a edição
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false)
        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.bind(filme)

        holder.itemView.findViewById<Button>(R.id.excluirBtn).setOnClickListener {
            onDeleteClick(filme) // Chama a função de exclusão passada como parâmetro
        }

        holder.itemView.findViewById<Button>(R.id.alterarBtn).setOnClickListener {
            onEditClick(filme) // Chama a função de edição passada como parâmetro
        }
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        private val txtAno: TextView = itemView.findViewById(R.id.txtAno)
        private val txtDescricao: TextView = itemView.findViewById(R.id.txtDescricao)
        private val imgFilme: ImageView = itemView.findViewById(R.id.imgFilme)

        fun bind(filme: Filme) {
            txtTitulo.text = filme.nome
            txtDescricao.text = filme.descricao
            txtAno.text = filme.ano
            if (filme.imagemUri != null) {
                imgFilme.setImageURI(Uri.parse(filme.imagemUri)) // Carregar a imagem usando o URI
            }
        }
    }
}
