package org.kuykuy.kuynote.domain

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.PrimaryKey

class Note {
    @PrimaryKey
    @AutoIncrement
    var id:Long?= 0
    var title:String?= null
    var description:String?= null

    constructor(title: String?, description: String?) {
        this.title = title
        this.description = description
    }

    constructor()

}