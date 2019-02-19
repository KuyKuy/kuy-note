package org.kuykuy.kuynote.repository.dao

import android.content.ContentValues

class NoteDao(dbHelper: KuyNoteDbHelper) {
    var dbHelper: KuyNoteDbHelper? = dbHelper
    val db = dbHelper.writableDatabase

    fun insert(values: ContentValues) : Long?{
        return db?.insert(Notes.NoteEntry.TABLE_NAME, null, values)
    }

}