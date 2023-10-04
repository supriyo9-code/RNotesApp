package com.example.rnotesapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.rnotesapp.database.DataBase
import com.example.rnotesapp.database.Note

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
   lateinit var notesList : LiveData<List<Note>>

   init {
       notesList = DataBase.getDb(application).Dao().getAllNotes()
   }
}