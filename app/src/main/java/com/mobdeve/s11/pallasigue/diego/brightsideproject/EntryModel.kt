package com.mobdeve.s11.pallasigue.diego.brightsideproject

import java.time.LocalDate
import java.util.*
/* Entry model is the individual entries of the users */
class EntryModel {
    var date: LocalDate
    private set
    var model: MoodModel
    private set
    var notes: String
    private set
    var id: Long = 0


    constructor(date: LocalDate, model: MoodModel, notes: String){
        this.date = date
        this.model = model
        this.notes = notes
    }

    constructor(date: LocalDate, model: MoodModel, notes: String, id: Long){
        this.date = date
        this.model = model
        this.notes = notes
        this.id = id
    }
}