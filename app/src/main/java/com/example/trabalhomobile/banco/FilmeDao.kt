package com.example.trabalhomobile.banco

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FilmeDao {

    //  meuLivro = new Livro();
    //  meuLivro.nome = "Marvel";
    //  meuLivro.ano = 2022;

    //FilmeDao.addLivro(meuLivro);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFilme(filme: Filme)

    @Update
    fun atualizarFilme(filme: Filme)

    @Delete
    fun deletarFilme(filme: Filme)

    @Query("SELECT * FROM filme_table")
    fun listarFilme():LiveData<List<Filme>>

    @Query("SELECT * FROM filme_table ORDER BY id ASC")
    fun listarFilmeEmOrdem() : LiveData<List<Filme>>

}