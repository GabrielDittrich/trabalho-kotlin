package com.example.trabalhomobile.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Filme::class], version = 1, exportSchema = false)

abstract class FilmeDatabase: RoomDatabase() {

    abstract fun filmeDao(): FilmeDao

    companion object {
        @Volatile
        private var INSTANCE: FilmeDatabase? = null


        fun getDatabase(context: Context): FilmeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance

            } else {

                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmeDatabase::class.java,
                        "filme_table"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}


