package com.example.rnotesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(Note::class), version = 1, exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun Dao(): Dao


    companion object {
        public var roomDb: DataBase? = null
        fun getDb(contex: Context): DataBase {
            if (roomDb == null) {
                roomDb =
                    Room.databaseBuilder(contex, DataBase::class.java, "note_database.db").allowMainThreadQueries().build()
            }

            return roomDb!!
        }
    }
}