package org.kuykuy.kuynote.service

import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.NoteRepository

class NoteService {
    private val noteRepository = NoteRepository()

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