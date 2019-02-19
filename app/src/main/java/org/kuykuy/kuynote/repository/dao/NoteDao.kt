package org.kuykuy.kuynote.repository.dao

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

class NoteDao(dbHelper: KuyNoteDbHelper) {
    var dbHelper: KuyNoteDbHelper? = dbHelper

    fun insert(values: ContentValues) : Long?{
        val db = dbHelper?.writableDatabase

        return db?.insert(Notes.NoteEntry.TABLE_NAME, null, values)
    }

    fun findAll(projection:Array<String>, selection:String, selectionArgs:Array<String>) : Cursor?{
        val db = dbHelper?.readableDatabase

        return db?.query(Notes.NoteEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
    }

    fun delete(selection:String, selectionArgs:Array<String>) : Int?{
        val db = dbHelper?.writableDatabase

        return db?.delete(Notes.NoteEntry.TABLE_NAME, selection, selectionArgs)
    }

    fun update(id:String, values:ContentValues) : Int?{
        val db = dbHelper?.writableDatabase
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(id)

        return db?.update(Notes.NoteEntry.TABLE_NAME, values, selection, selectionArgs)
    }



}