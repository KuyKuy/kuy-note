package org.kuykuy.kuynote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.Menu
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import org.kuykuy.kuynote.domain.*
import org.kuykuy.kuynote.service.NoteService

class MainActivity : AppCompatActivity() {

    private var listNotes = ArrayList<Note>()
    private val noteService:NoteService = NoteService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initialize()
    }

    private fun initialize(){
        listNotes = noteService.findAll()
        val noteAdapter = NoteAdapter(this, listNotes)

        val noteListView = findViewById<ListView>(R.id.notesLv)
        noteListView.adapter = noteAdapter

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, NoteDetailsActivity::class.java)
            intent.putExtra(MODE_EXTRA, ADD_MODE)
            startActivity(intent)
            finish()
        }
    }
}
