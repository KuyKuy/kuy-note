package org.kuykuy.kuynote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.db.NoteRepository

class MainActivity : AppCompatActivity() {

    var listNotes = ArrayList<Note>()
    val noteRepository:NoteRepository = NoteRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initialize()
    }

    private fun initialize(){
        noteRepository.mockData()
        listNotes = noteRepository.findAll()
        val noteAdapter = NoteAdapter(this, listNotes)
        val noteListView = findViewById<ListView>(R.id.notesLv)
        noteListView.adapter = noteAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
