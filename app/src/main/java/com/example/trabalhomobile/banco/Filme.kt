package com.example.trabalhomobile.banco

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "filme_table")
data class Filme(
    @PrimaryKey(autoGenerate = true) // autoincrement
    val id : Int,
    val nome : String,
    val descricao : String,
    val descricaoDetalhada : String,
    val ano : String
): Parcelable
