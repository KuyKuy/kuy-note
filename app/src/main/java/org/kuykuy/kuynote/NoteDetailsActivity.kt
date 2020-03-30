package org.kuykuy.kuynote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_details.*
import kotlinx.android.synthetic.main.content_note_details.*
import org.kuykuy.kuynote.domain.*
import org.kuykuy.kuynote.service.NoteService

class NoteDetailsActivity : AppCompatActivity() {

    private val noteService: NoteService = NoteService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
        setSupportActionBar(toolbarDetails)
        initialize()
    }

    private fun initialize() {
        val note = Note()
        val mode = intent.getStringExtra(MODE_EXTRA)
        if(mode == EDIT_MODE) {
            note.id = intent.getLongExtra(NOTE_ID, -1)
            note.title = intent.getStringExtra(NOTE_TITLE)
            note.description = intent.getStringExtra(NOTE_DESCRIPTION)
            titleEt.setText(note.title)
            descEt.setText(note.description)
            addNoteBtn.text = getString(R.string.save)
        }
        addNoteBtn.setOnClickListener {
            saveNote(mode, note)
        }
    }

    private fun saveNote(mode: String, note: Note) {
        if (validateFields()) {
            note.title = titleEt.text.toString()
            note.description = descEt.text.toString()
            if(mode == ADD_MODE) {
                noteService.insert(note)
            } else {
                noteService.update(note)
            }
            backToMain()
        } else {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateFields() = titleEt.text.isNotEmpty() && descEt.text.isNotEmpty()

    private fun backToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
