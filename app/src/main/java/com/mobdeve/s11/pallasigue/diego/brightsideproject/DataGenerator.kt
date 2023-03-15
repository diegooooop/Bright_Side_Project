package com.mobdeve.s11.pallasigue.diego.brightsideproject

class DataGenerator {
        companion object {
            fun loadData(): ArrayList<MoodModel> {
                val data = ArrayList<MoodModel>()
                data.add(MoodModel(
                    "Happy",
                    R.drawable.happy,
                    adjectives = arrayOf<String>("Joyful", "Cheerful", "Delighted", "Pleased", "Ecstatic", "Blissful", "Elated", "Grateful", "Content", "Overjoyed"),
                    textColor =
                ))
                data.add(MoodModel(
                    "sad",
                    R.drawable.sad,
                    adjectives = arrayOf<String>("Miserable", "Gloomy", "Melancholy", "Somber", "Depressed", "Sorrowful", "Blue", "Despondent", "Rejected", "Heartbroken")))
                data.add(MoodModel(
                    "Angry",
                    R.drawable.angry,
                    adjectives = arrayOf<String>("Furious", "Enraged", "Livid", "Irritated", "Incensed", "Fuming", "Seething", "Hostile", "Resentful", "Aggravated")))
                data.add(MoodModel(
                    "Bored",
                    R.drawable.bored,
                    adjectives = arrayOf<String>("")))
                data.add(MoodModel(
                    "Anxious",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("")))
                data.add(MoodModel(
                    "Confused",
                    R.drawable.confused,
                    adjectives = arrayOf<String>("")))
                data.add(MoodModel(
                    "Inlove",
                    R.drawable.inlove,
                    adjectives = arrayOf<String>("")))
                data.add(MoodModel(
                    "Nervous",
                    R.drawable.nervous,
                    adjectives = arrayOf<String>("")))







                return data
            }
        }
    }
}