package com.mobdeve.s11.pallasigue.diego.brightsideproject

import java.time.LocalDate
import java.util.*

class EntryModel {
    var date: LocalDate

    var model: MoodModel

    var notes: String


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