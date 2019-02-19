package org.kuykuy.kuynote.repository

import android.content.Context
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.dao.KuyNoteDbHelper
import org.kuykuy.kuynote.repository.dao.NoteDao

class NoteRepository (context : Context){
    private val kuyNoteDbHelper = KuyNoteDbHelper(context)
    private val noteDAO = NoteDao(kuyNoteDbHelper)
    private val notes = ArrayList<Note>()

    init {
        mockData()
    }

    private fun mockData(){
        notes.add(Note(1, "Una nota", "recuerda el pan"))
        notes.add(Note(2, "Otra nota", "entrenar"))
        notes.add(Note(3, "Y otra más", "estudiar android"))
    }

    fun findAll():ArrayList<Note>{
        return notes
    }

    fun findById(id: Long?): Note? {
        return notes.find { it.id == id }
    }

    fun save(note: Note?) {
        val noteFounded = findById(note?.id)
        if(noteFounded != null){
            noteFounded.title = note?.title
            noteFounded.description = note?.description
        }
        else{
            note?.id = notes[notes.size-1].id?.plus(1)
            note?.let { notes.add(it) }
        }
    }
}