package org.kuykuy.kuynote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_details.*
import kotlinx.android.synthetic.main.content_note_details.*
import kotlinx.android.synthetic.main.item_note.*
import org.kuykuy.kuynote.domain.*
import org.kuykuy.kuynote.service.NoteService

class NoteDetailsActivity : AppCompatActivity() {

    private var mode:String? = ""
    private var note:Note? = Note()
    private val noteService: NoteService = NoteService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
        setSupportActionBar(toolbarDetails)
        mode = savedInstanceState?.getString(MODE_EXTRA, ADD_MODE)
        if(mode == EDIT_MODE) {
            val id = savedInstanceState?.getLong(NOTE_ID, -1)
                note = noteService.findById(id)
        }
        initialize()
    }

    private fun initialize() {
        if(mode == EDIT_MODE) {
            titleEt.setText(note?.title)
            descEt.setText(note?.description)
            addNoteBtn.text = "Guardar"
            addNoteBtn.setOnClickListener {
                noteService.save(note)
            }
        }
        else{
            addNoteBtn.setOnClickListener {
                note?.title = titleEt.text.toString()
                note?.description = descEt.text.toString()
                noteService.save(note)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
