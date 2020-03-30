package org.kuykuy.kuynote.repository

import android.content.ContentValues
import android.content.Context
import org.kuykuy.kuynote.domain.Note
import org.kuykuy.kuynote.repository.dao.KuyNoteDbHelper
import org.kuykuy.kuynote.repository.dao.DbManager
import org.kuykuy.kuynote.repository.dao.Notes.NoteEntry.COLUMN_DESCRIPTION
import org.kuykuy.kuynote.repository.dao.Notes.NoteEntry.COLUMN_TITLE

class NoteRepository(context: Context) {
    private val kuyNoteDbHelper = KuyNoteDbHelper(context)
    private val dbManager = DbManager(kuyNoteDbHelper)

    fun findAll(): ArrayList<Note> {
        return dbManager.findAll()
    }

    fun add(note: Note?) {
        val values = buildContentValues(note)

        dbManager.insert(values)
        dbManager.close()
    }

    fun update(note: Note?) {
        val values = buildContentValues(note)

        dbManager.update(note?.id, values)
        dbManager.close()
    }

    fun delete(note: Note?) {
        dbManager.delete(note)
        dbManager.close()
    }

    private fun buildContentValues(note: Note?): ContentValues {
        return ContentValues().apply {
            put(COLUMN_TITLE, note?.title)
            put(COLUMN_DESCRIPTION, note?.description)
        }
    }
}