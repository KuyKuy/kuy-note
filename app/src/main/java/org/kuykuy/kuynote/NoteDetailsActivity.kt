package org.kuykuy.kuynote

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_note_details.*
import kotlinx.android.synthetic.main.content_note_details.*
import org.kuykuy.kuynote.domain.*
import org.kuykuy.kuynote.service.NoteService

class NoteDetailsActivity : AppCompatActivity() {

    private var mode:String? = ""
    private var note:Note? = Note()
    private val noteService: NoteService = NoteService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
        setSupportActionBar(toolbarDetails)
        initialize()
    }

    private fun initialize() {
        mode = intent.getStringExtra(MODE_EXTRA)
        if(mode == EDIT_MODE) {
            val id = intent.getLongExtra(NOTE_ID, -1)
            note = noteService.findById(id)
            titleEt.setText(note?.title)
            descEt.setText(note?.description)
            addNoteBtn.text = getString(R.string.save)
            addNoteBtn.setOnClickListener {
                noteService.save(note)
                backToMain()
            }

        }
        else{
            addNoteBtn.setOnClickListener {
                note?.title = titleEt.text.toString()
                note?.description = descEt.text.toString()
                noteService.save(note)
                backToMain()
            }
        }
    }

    private fun backToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
