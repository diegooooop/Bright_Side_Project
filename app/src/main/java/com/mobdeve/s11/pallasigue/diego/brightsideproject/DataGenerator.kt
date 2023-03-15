package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color

class DataGenerator {
        companion object {
            fun loadData(): ArrayList<MoodModel> {
                val data = ArrayList<MoodModel>()
                data.add(MoodModel(
                    "Happy",
                    R.drawable.happy,
                    adjectives = arrayOf<String>("Joyful", "Cheerful", "Delighted", "Pleased", "Ecstatic", "Blissful", "Elated", "Grateful", "Content", "Overjoyed"),
                    color = Color.YELLOW))

                data.add(MoodModel(
                    "Sad",
                    R.drawable.sad,
                    adjectives = arrayOf<String>("Miserable", "Gloomy", "Melancholy", "Somber", "Depressed", "Sorrowful", "Blue", "Despondent", "Rejected", "Heartbroken"),
                    color = Color.BLUE))

                data.add(MoodModel(
                    "Angry",
                    R.drawable.angry,
                    adjectives = arrayOf<String>("Furious", "Enraged", "Livid", "Irritated", "Incensed", "Fuming", "Seething", "Hostile", "Resentful", "Aggravated"),
                    color = Color.RED))

                data.add(MoodModel(
                    "Bored",
                    R.drawable.bored,
                    adjectives = arrayOf<String>("Uninterested", "Disinterested", "Apathetic", "Uninspired", "Mundane", "Tedious", "Monotonous", "Dull", "Tiresome", "Lethargic"),
                    color = Color.GREEN))

                data.add(MoodModel(
                    "Anxious",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("Nervous", "Worried", "Apprehensive", "Uneasy", "Restless", "Jittery", "Fidgety", "Panicky", "Tense", "Agitated"),
                    color = Color.GREEN))

                data.add(MoodModel(
                    "Confused",
                    R.drawable.confused,
                    adjectives = arrayOf<String>("Perplexed", "Baffled", "Bewildered", "Puzzled", "Disoriented", "Muddled", "Fuddled", "Dazed", "Flustered", "Mixed-up"),
                    color = Color.RED))

                data.add(MoodModel(
                    "Inlove",
                    R.drawable.inlove,
                    adjectives = arrayOf<String>("Smitten", "Enamored", "Adoring", "Devoted", "Infatuated", "Passionate", "Besotted", "Charmed", "Enchanted", "Amorous"),
                    color = Color.BLUE))

                data.add(MoodModel(
                    "Nervous",
                    R.drawable.nervous,
                    adjectives = arrayOf<String>("Anxious", "Apprehensive", "Uneasy", "Jittery", "Tense", "Fidgety", "Worried", "Agitated", "Restless", "Nervous-wreck"),
                    color = Color.YELLOW))
                return data
            }
        }
    }
