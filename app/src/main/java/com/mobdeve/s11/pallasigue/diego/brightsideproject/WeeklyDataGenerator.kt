package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color

class WeeklyDataGenerator {
    companion object {
        fun loadData(): ArrayList<WeeklyModel>{
            val data = ArrayList<WeeklyModel>()
            data.add(
                WeeklyModel(
                    "March 6, 2023 - Monday",
                    MoodModel("Anxious", R.drawable.nervous, adjectives = arrayOf<String>("Fidgety", "Panicky", "Worried"),
                        color = Color.parseColor("#F3F7FA")),
                    "I have not prepared for my exam this Monday"))
            data.add(
                WeeklyModel(
                    "March 7, 2023 - Tuesday",
                    MoodModel("Sad", R.drawable.anxious, adjectives = arrayOf<String>("Blue", "Depressed", "Somber", "Miserable"),
                        color = Color.parseColor("#DAEDFC")),
                    "I failed my exam"))
            data.add(
                WeeklyModel(
                    "March 8, 2023 - Wednesday",
                    "Confused",
                    R.drawable.confused,
                    adjectives = arrayOf<String>("Puzzled", "Disoriented"),
                    "I am overwhelmed with the things I need to do"))
            data.add(
                WeeklyModel(
                    "March 9, 2023 - Thursday",
                    "Happy",
                    R.drawable.happy,
                    adjectives = arrayOf<String>("Cheerful", "Ecstatic", "Grateful"),
                    "There will be a makeup test this Friday!"))
            data.add(
                WeeklyModel(
                    "March 10, 2023 - Friday",
                    "In Love",
                    R.drawable.inlove,
                    adjectives = arrayOf<String>("Enamored", "Enchanted", "Amorous"),
                    "I got a perfect score! WHOO!"))
            data.add(
                WeeklyModel(
                    "March 11, 2023 - Saturday",
                    "Bored",
                    R.drawable.bored,
                    adjectives = arrayOf<String>("Monotonous",  "Uninspired"),
                    "What to do? :/"))
            data.add(
                WeeklyModel(
                    "March 12, 2023 - Sunday",
                    "Angry",
                    R.drawable.angry,
                    adjectives = arrayOf<String>("Seething", "Enraged", "Fuming"),
                    "It's Monday again tomorrow!"))
            return data
        }
    }
}