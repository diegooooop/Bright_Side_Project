package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class AlltimeDataGenerator {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun loadData(): ArrayList<EntryModel>{
            val data = ArrayList<EntryModel>()
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Monday",
                    MoodModel("Happy", R.drawable.happy, adjectives = arrayOf<String>("Cheerful", "Ecstatic", "Grateful"),
                        color = Color.parseColor("#F8EACD")),
                    "There will be a makeup test this Friday!"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Anxious", R.drawable.nervous, adjectives = arrayOf<String>("Fidgety", "Panicky", "Worried"),
                        color = Color.parseColor("#F3F7FA")),
                    "I have not prepared for my exam this Monday"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Sad", R.drawable.anxious, adjectives = arrayOf<String>("Blue", "Depressed", "Somber", "Miserable"),
                        color = Color.parseColor("#DAEDFC")),
                    "I failed my exam"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Confused", R.drawable. confused,adjectives = arrayOf<String>("Puzzled", "Disoriented"),
                        color = Color.parseColor("#C7E1F8")),
                    "I am overwhelmed with the things I need to do"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Happy", R.drawable.happy, adjectives = arrayOf<String>("Cheerful", "Ecstatic", "Grateful"),
                        color = Color.parseColor("#F8EACD")),
                    "There will be a makeup test this Friday!"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("In Love",R.drawable.inlove, adjectives = arrayOf<String>("Enamored", "Enchanted", "Amorous"),
                        color = Color.parseColor("#FFF9C7")),
                    "I got a perfect score! WHOO!"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Bored",R.drawable.bored,  adjectives = arrayOf<String>("Monotonous",  "Uninspired"),
                        color = Color.parseColor("#F7CDD0")),
                    "What to do? :/"))
            data.add(
                EntryModel(
                    LocalDate.of(2023,3,1),
                    "Sunday",
                    MoodModel("Angry", R.drawable.angry, adjectives = arrayOf<String>("Seething", "Enraged", "Fuming"),
                        color = Color.parseColor("#FFE5CF")),
                    "It's Monday again tomorrow!"))
            return data}}}
