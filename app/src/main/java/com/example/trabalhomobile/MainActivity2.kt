package com.example.trabalhomobile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhomobile.banco.Filme
import com.example.trabalhomobile.banco.FilmeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 1001
        private const val REQUEST_CODE_EDIT_FILME = 2002 // Código para identificar a requisição de edição
    }

    private lateinit var filmeViewModel: FilmeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var filmeAdapter: FilmeAdapter
    private lateinit var filmes: MutableList<Filme>
    private lateinit var btnVoltar: Button
    private var selectedImageUri: Uri? = null
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        filmeViewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        // Inicializar a lista de filmes
        filmes = mutableListOf()

        // Configurar o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        filmeAdapter = FilmeAdapter(this, filmes, { filme -> excluirFilme(filme) }, { filme -> editarFilme(filme) })
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

    private fun excluirFilme(filme: Filme) {
        // Confirmação do usuário antes de excluir
        AlertDialog.Builder(this)
            .setTitle("Excluir Filme")
            .setMessage("Tem certeza que deseja excluir o filme ${filme.nome}?")
            .setPositiveButton("Sim") { dialog, _ ->
                filmeViewModel.deletar(filme)
                filmes.remove(filme) // Remove da lista local
                filmeAdapter.notifyDataSetChanged() // Atualiza o RecyclerView
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun editarFilme(filme: Filme) {
        val intent = Intent(this, AlterarFilmeActivity::class.java).apply {
            putExtra("id_filme", filme.id) // Adiciona o ID do filme
            putExtra("titulo_filme", filme.nome)
            putExtra("ano_filme", filme.ano)
            putExtra("descricao_resumida_filme", filme.descricao)
            putExtra("descricao_detalhada_filme", filme.descricaoDetalhada)
            putExtra("imagem_filme", filme.imagemUri)
        }
        startActivityForResult(intent, REQUEST_CODE_EDIT_FILME)
    }

    private fun showAddMovieDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_movie, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val anoEditText = dialogView.findViewById<EditText>(R.id.editTextYear)
        val shortDescEditText = dialogView.findViewById<EditText>(R.id.editTextShortDescription)
        val detailedDescEditText = dialogView.findViewById<EditText>(R.id.editTextDetailedDescription)
        imageView = dialogView.findViewById(R.id.imageViewSelected)

        val imageButton = dialogView.findViewById<Button>(R.id.buttonSelectImage)
        imageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
        }

        AlertDialog.Builder(this)
            .setTitle("Adicionar Novo Filme")
            .setView(dialogView)
            .setPositiveButton("Adicionar") { dialog, _ ->
                val titulo = titleEditText.text.toString()
                val ano = anoEditText.text.toString()
                val descCurta = shortDescEditText.text.toString()
                val descLong = detailedDescEditText.text.toString()

                if (titulo.isNotEmpty() && ano.isNotEmpty() && selectedImageUri != null) {
                    val novoFilme = Filme(0, titulo, descCurta, descLong, ano, selectedImageUri.toString())
                    filmes.add(novoFilme)
                    filmeAdapter.notifyItemInserted(filmes.size - 1)
                    dialog.dismiss()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                selectedImageUri = uri
                imageView.setImageURI(uri)
            }
        } else if (requestCode == REQUEST_CODE_EDIT_FILME && resultCode == Activity.RESULT_OK) {
            // Aqui você pode lidar com o resultado da edição do filme
            data?.let {
                val id = it.getIntExtra("id_filme", -1) // Obtém o ID do filme editado
                val titulo = it.getStringExtra("titulo_filme")
                val ano = it.getStringExtra("ano_filme")
                val shortDesc = it.getStringExtra("descricao_resumida_filme")
                val detailedDesc = it.getStringExtra("descricao_detalhada_filme")
                val imagemUri = it.getStringExtra("imagem_filme")

                // Atualiza a lista de filmes
                val filme = filmes.find { f -> f.id == id }
                filme?.let {
                    if (titulo != null) {
                        it.nome = titulo
                    }
                    if (ano != null) {
                        it.ano = ano
                    }
                    if (shortDesc != null) {
                        it.descricao = shortDesc
                    }
                    if (detailedDesc != null) {
                        it.descricaoDetalhada = detailedDesc
                    }
                    it.imagemUri = imagemUri
                    filmeAdapter.notifyDataSetChanged() // Atualiza o RecyclerView
                }
            }
        }
    }
}

