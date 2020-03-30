package org.kuykuy.kuynote.service

import android.content.Context
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.NoteRepository

class NoteService (context: Context)  {
    private val noteRepository = NoteRepository(context)

    fun findAll():ArrayList<Note>{
        return noteRepository.findAll()
    }

    fun insert(note: Note) {
        noteRepository.add(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }

    fun delete(note: Note){
        noteRepository.delete(note)
    }


}