package com.example.rnotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rnotesapp.database.Note
import com.example.rnotesapp.databinding.ActivityAddEditBinding
import com.example.rnotesapp.viewmodels.AddEditActivityViewModel

class AddEditActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityAddEditBinding.inflate(layoutInflater)
    }
    lateinit var addEditActivityViewModel:AddEditActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addEditActivityViewModel=ViewModelProvider(this).get(AddEditActivityViewModel::class.java)

        if (intent.hasExtra("NOTE_EDIT")){
            var note: Note=intent.getSerializableExtra("NOTE_EDIT") as Note

            binding.title.setText(note.title)
            binding.disp.setText(note.disp)
            binding.AddEdit.setOnClickListener {
                var title = binding.title.text.toString()
                var disp = binding.disp.text.toString()


                note.title = title
                note.disp = disp

                addEditActivityViewModel.update(note,this)
                finish()
            }
        }else{
            binding.AddEdit.setOnClickListener {
                var title = binding.title.text.toString()
                var disp = binding.disp.text.toString()


                var note = Note(title=title,disp=disp)

                addEditActivityViewModel.insert(note,this)
                finish()
            }
        }

    }
}