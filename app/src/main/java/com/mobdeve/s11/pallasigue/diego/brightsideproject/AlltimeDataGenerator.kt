package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color

class AlltimeDataGenerator {
    companion object {
        fun loadData(): ArrayList<EntryModel>{
            val data = ArrayList<EntryModel>()
            data.add(
                EntryModel(
                    "March 5, 2023 - Sunday",
                    MoodModel("Happy", R.drawable.happy, adjectives = arrayOf<String>("Fidgety", "Panicky", "Worried"),
                        color = Color.parseColor("#F3F7FA")),
                    "I have not prepared for my exam this Monday"))
            data.add(
                EntryModel(
                    "March 6, 2023 - Monday",
                    MoodModel("Anxious", R.drawable.nervous, adjectives = arrayOf<String>("Fidgety", "Panicky", "Worried"),
                        color = Color.parseColor("#F3F7FA")),
                    "I have not prepared for my exam this Monday"))
            data.add(
                EntryModel(
                    "March 7, 2023 - Tuesday",
                    MoodModel("Sad", R.drawable.anxious, adjectives = arrayOf<String>("Blue", "Depressed", "Somber", "Miserable"),
                        color = Color.parseColor("#DAEDFC")),
                    "I failed my exam"))
            data.add(
                EntryModel(
                    "March 8, 2023 - Wednesday",
                    MoodModel("Confused", R.drawable. confused,adjectives = arrayOf<String>("Puzzled", "Disoriented"),
                        color = Color.parseColor("#C7E1F8")),
                    "I am overwhelmed with the things I need to do"))
            data.add(
                EntryModel(
                    "March 9, 2023 - Thursday",
                    MoodModel("Happy", R.drawable.happy, adjectives = arrayOf<String>("Cheerful", "Ecstatic", "Grateful"),
                        color = Color.parseColor("#F8EACD")),
                    "There will be a makeup test this Friday!"))
            data.add(
                EntryModel(
                    "March 10, 2023 - Friday",
                    MoodModel("In Love",R.drawable.inlove, adjectives = arrayOf<String>("Enamored", "Enchanted", "Amorous"),
                        color = Color.parseColor("#FFF9C7")),
                    "I got a perfect score! WHOO!"))
            data.add(
                EntryModel(
                    "March 11, 2023 - Saturday",
                    MoodModel("Bored",R.drawable.bored,  adjectives = arrayOf<String>("Monotonous",  "Uninspired"),
                        color = Color.parseColor("#F7CDD0")),
                    "What to do? :/"))
            data.add(
                EntryModel(
                    "March 12, 2023 - Sunday",
                    MoodModel("Angry", R.drawable.angry, adjectives = arrayOf<String>("Seething", "Enraged", "Fuming"),
                        color = Color.parseColor("#FFE5CF")),
                    "It's Monday again tomorrow!"))
            return data
        }
<<<<<<< HEAD
    }
}
=======
    }}
>>>>>>> f5db0955df962569337490fef82d2c43d6e21d67
