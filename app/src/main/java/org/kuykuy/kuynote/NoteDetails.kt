package org.kuykuy.kuynote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.kuykuy.kuynote.domain.ADD_MODE
import org.kuykuy.kuynote.domain.EDIT_MODE
import org.kuykuy.kuynote.domain.MODE_EXTRA

class NoteDetails : AppCompatActivity() {

    private var mode:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
        mode = savedInstanceState?.getString(MODE_EXTRA, ADD_MODE)
        initialize()
    }

    private fun initialize() {

    }
}
