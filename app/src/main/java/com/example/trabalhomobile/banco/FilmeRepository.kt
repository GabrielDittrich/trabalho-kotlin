    package com.example.trabalhomobile.banco

    import androidx.lifecycle.LiveData

    class FilmeRepository(private val filmeDao: FilmeDao) {

        // Função para obter todos os filmes
        val todosOsFilmes: LiveData<List<Filme>> = filmeDao.getAllFilmes()

        // Função para adicionar um filme
        suspend fun inserir(filme: Filme) {
            filmeDao.inserir(filme)
        }

        // Função para deletar um filme
        suspend fun deletar(filme: Filme) {
            filmeDao.deletar(filme)
        }

        // Função para atualizar um filme
        suspend fun atualizar(filme: Filme) {
            filmeDao.atualizar(filme)
        }
    }
