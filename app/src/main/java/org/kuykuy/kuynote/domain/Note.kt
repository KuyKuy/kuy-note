package org.kuykuy.kuynote.domain

class Note {

    var id:Long? = 0
    var title:String? = null
    var description:String? = null

    constructor(id: Long?, title: String?, description: String?) {
        this.id = id
        this.title = title
        this.description = description
    }

    constructor(title: String?, description: String?) {
        this.title = title
        this.description = description
    }

    constructor()

}