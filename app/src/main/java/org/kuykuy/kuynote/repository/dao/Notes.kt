package org.kuykuy.kuynote.repository.dao

import android.provider.BaseColumns


object Notes {
    object NoteEntry : BaseColumns{
        const val TABLE_NAME = "notes"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${NoteEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${NoteEntry.COLUMN_TITLE} TEXT," +
                "${NoteEntry.COLUMN_DESCRIPTION} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${NoteEntry.TABLE_NAME}"
}