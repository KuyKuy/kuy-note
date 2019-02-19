package org.kuykuy.kuynote.service

import android.content.Context
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.NoteRepository

class NoteService (context: Context)  {
    private val noteRepository = NoteRepository(context)

    fun findById(id:Long?): Note? {
        return noteRepository.findById(id)
    }

    fun findAll():ArrayList<Note>{
        return noteRepository.findAll()
    }

    fun save(note: Note?) {
        noteRepository.save(note)
    }


}