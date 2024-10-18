package com.example.trabalhomobile.banco

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmeViewModel(application: Application): AndroidViewModel(application) {

    val listaFilmes: LiveData<List<Filme>>
    private val repository : FilmeRepository

    init {
        var filmeDao = FilmeDatabase.getDatabase(application).filmeDao()
        repository = FilmeRepository(filmeDao)
        listaFilmes = repository.listaFilmes
    }

    fun addFilme(filme: Filme){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFilme(filme)
        }
    }

    fun updateFilme(filme: Filme){
        viewModelScope.launch (Dispatchers.IO){
            repository.deletarFilme(filme)
        }
    }
}