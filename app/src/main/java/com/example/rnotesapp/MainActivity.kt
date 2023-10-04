package com.example.rnotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rnotesapp.database.Note
import com.example.rnotesapp.databinding.ActivityMainBinding
import com.example.rnotesapp.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var noteList : List<Note>
    lateinit var viweModel:MainActivityViewModel
    lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        noteList=ArrayList()
        viweModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var observer= Observer<List<Note>>{
            noteList=it

            adapter= RvAdapter(noteList,this)
            binding.rv.layoutManager=LinearLayoutManager(this)
            binding.rv.adapter=adapter
        }
        viweModel.notesList.observe(this,observer)

        adapter= RvAdapter(noteList,this)
        binding.rv.layoutManager=LinearLayoutManager(this)
        binding.rv.adapter=adapter

        binding.floatingActionButton.setOnClickListener {
            var intent=Intent(this@MainActivity,AddEditActivity::class.java)
            startActivity(intent)
        }
        registerForContextMenu(binding.rv)
        binding.rv.setOnClickListener {
            openContextMenu(binding.rv)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.floating_contextual_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}

