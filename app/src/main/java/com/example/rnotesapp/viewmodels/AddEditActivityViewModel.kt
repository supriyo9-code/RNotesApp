package com.example.rnotesapp.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.rnotesapp.database.DataBase
import com.example.rnotesapp.database.Note

class AddEditActivityViewModel(application: Application) : AndroidViewModel(application) {



    fun insert(note: Note,context: Context){
        DataBase.getDb(context).Dao().insert(note)
    }
    fun update(note: Note,context: Context){
        DataBase.getDb(context).Dao().update(note)
    }


}