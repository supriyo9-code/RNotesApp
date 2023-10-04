package com.example.rnotesapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Note(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var title: String,
    var disp: String


):Serializable {
}