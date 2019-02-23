package org.kuykuy.kuynote.repository

import android.content.ContentValues
import android.content.Context
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.dao.KuyNoteDbHelper
import org.kuykuy.kuynote.repository.dao.DbManager
import org.kuykuy.kuynote.repository.dao.Notes
import org.kuykuy.kuynote.repository.dao.Notes.NoteEntry.COLUMN_DESCRIPTION
import org.kuykuy.kuynote.repository.dao.Notes.NoteEntry.COLUMN_TITLE

class NoteRepository (context : Context){
    private val kuyNoteDbHelper = KuyNoteDbHelper(context)
    private val dbManager = DbManager(kuyNoteDbHelper)
    private var notes = ArrayList<Note>()

    init {
        //mockData()
        //findAll()
    }

    /*private fun mockData(){
        notes.add(Note(1, "Una nota", "recuerda el pan"))
        notes.add(Note(2, "Otra nota", "entrenar"))
        notes.add(Note(3, "Y otra más", "estudiar android"))
    }*/

    fun findAll():ArrayList<Note>{
        notes = dbManager.findAll()
        return notes
    }

    fun findById(id: Long?): Note? {
        findAll()
        return notes.find { it.id == id }
    }

    fun save(note: Note?) {
        val noteFounded = findById(note?.id)
        val values = ContentValues().apply {
            put(COLUMN_TITLE, note?.title)
            put(COLUMN_DESCRIPTION, note?.description)
        }
        if(noteFounded != null){
            dbManager.update(note?.id, values)
        }
        else{
            dbManager.insert(values)
        }
        dbManager.close()
    }

    fun delete(note: Note?){
        dbManager.delete(note)
        dbManager.close()
    }
}