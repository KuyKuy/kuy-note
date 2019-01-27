package org.kuykuy.kuynote.repository.db

import ninja.sakib.pultusorm.core.PultusORM
import org.kuykuy.kuynote.domain.Note

class NoteRepository {
    //val pultus: PultusORM = PultusORM("kuyNote.db")
    val notes = ArrayList<Note>()

    /*fun save (note:Note): Boolean {
        return pultus.save(note)
    }*/

    fun mockData(){
        notes.add(Note("Una nota", "recuerda el pan"))
        notes.add(Note("Otra nota", "entrenar"))
        notes.add(Note("Y otra más", "estudiar android"))
    }

    fun findAll():ArrayList<Note>{
        return notes
    }
}