        package com.example.trabalhomobile

        import android.app.AlertDialog
        import android.content.Intent
        import android.net.Uri
        import android.os.Bundle
        import android.widget.Button
        import android.widget.EditText
        import android.widget.ImageView
        import androidx.activity.enableEdgeToEdge
        import androidx.appcompat.app.AppCompatActivity
        import androidx.core.view.ViewCompat
        import androidx.core.view.WindowInsetsCompat

        class AlterarFilmeActivity : AppCompatActivity() {
            private lateinit var editTextTitle: EditText
            private lateinit var editTextYear: EditText
            private lateinit var editTextShortDescription: EditText
            private lateinit var editTextDetailedDescription: EditText
            private lateinit var imageView: ImageView
            private lateinit var btnAlterar: Button
            private var selectedImageUri: Uri? = null // Para armazenar a URI da imagem

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_alterar_filme)
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }

                // Recuperar os dados do Intent
                val titulo = intent.getStringExtra("titulo_filme")
                val ano = intent.getStringExtra("ano_filme")
                val shortDesc = intent.getStringExtra("descricao_resumida_filme")
                val detailedDesc = intent.getStringExtra("descricao_detalhada_filme")
                val imagemUri = intent.getStringExtra("imagem_filme") // Supondo que você armazene o URI da imagem

                // Inicializar as views
                editTextTitle = findViewById(R.id.editTextTitle)
                editTextYear = findViewById(R.id.editTextYear)
                editTextShortDescription = findViewById(R.id.editTextShortDescription)
                editTextDetailedDescription = findViewById(R.id.editTextDetailedDescription)
                imageView = findViewById(R.id.imageViewSelected)
                btnAlterar = findViewById(R.id.buttonAlterar)

                // Configurar as views com os dados recebidos
                editTextTitle.setText(titulo)
                editTextYear.setText(ano)
                editTextShortDescription.setText(shortDesc)
                editTextDetailedDescription.setText(detailedDesc)
                imageView.setImageURI(Uri.parse(imagemUri)) // Definir a imagem a partir do URI

                // Botão para selecionar uma nova imagem
                findViewById<Button>(R.id.buttonSelectImage).setOnClickListener {
                    // Abrir a galeria
                    val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE) // Define um código de solicitação
                }

                // Botão para alterar o filme
                btnAlterar.setOnClickListener {
                    // Aqui você pode adicionar lógica para salvar as alterações
                    val novoTitulo = editTextTitle.text.toString()
                    val novoAno = editTextYear.text.toString()
                    val novaDescricaoCurta = editTextShortDescription.text.toString()
                    val novaDescricaoDetalhada = editTextDetailedDescription.text.toString()
                    // Lógica para atualizar o filme na lista ou no banco de dados

                    // Exibir um diálogo de confirmação
                    AlertDialog.Builder(this)
                        .setTitle("Alteração Concluída")
                        .setMessage("Filme alterado com sucesso!")
                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()
                }
            }

            // Manipular o resultado da seleção da imagem
            override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                super.onActivityResult(requestCode, resultCode, data)
                if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK) {
                    data?.data?.let { uri ->
                        selectedImageUri = uri
                        imageView.setImageURI(uri) // Atualiza a ImageView com a nova imagem selecionada
                    }
                }
            }

            companion object {
                private const val REQUEST_CODE_PICK_IMAGE = 100 // Código para identificação da requisição
            }
        }
