package com.example.trabalhomobile.banco

import androidx.lifecycle.LiveData

class FilmeRepository(private val filmeDao: FilmeDao) {

    val listaFilmes: LiveData<List<Filme>> = filmeDao.listarFilme()

    suspend fun addFilme(filme: Filme){
        filmeDao.addFilme(filme)
    }

    suspend fun atualizarFilme(filme: Filme){
        filmeDao.atualizarFilme(filme)
    }

    suspend fun deletarFilme(filme: Filme){
        filmeDao.deletarFilme(filme)
    }
}