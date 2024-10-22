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

    @Query("SELECT * FROM filme_table")
    fun getAllFilmes(): LiveData<List<Filme>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(filme: Filme)

    @Delete
    suspend fun deletar(filme: Filme)

    @Update
    suspend fun atualizar(filme: Filme)
}