package com.example.trabalhomobile.banco

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "filme_table")
data class Filme(
    @PrimaryKey(autoGenerate = true) // auto increment
    val id: Int,
    var nome: String,
    var descricao: String,
    var descricaoDetalhada: String,
    var ano: String,
    var imagemUri: String? // Adicione este campo para armazenar o URI da imagem
): Parcelable
