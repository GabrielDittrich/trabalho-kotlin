package com.example.trabalhomobile.banco

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FilmeRepository
    val todosOsFilmes: LiveData<List<Filme>>

    init {
        val filmeDao = FilmeDatabase.getDatabase(application).filmeDao()
        repository = FilmeRepository(filmeDao)
        todosOsFilmes = repository.todosOsFilmes
    }

    // Função para adicionar um filme
    fun inserir(filme: Filme) = viewModelScope.launch(Dispatchers.IO) {
        repository.inserir(filme)
    }

    // Função para deletar um filme
    fun deletar(filme: Filme) = viewModelScope.launch(Dispatchers.IO) {
        repository.deletar(filme)
    }

    // Função para atualizar um filme
    fun atualizar(filme: Filme) = viewModelScope.launch(Dispatchers.IO) {
        repository.atualizar(filme)
    }
}