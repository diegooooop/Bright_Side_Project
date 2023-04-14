package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.graphics.Color
/*This data generator is for the moods that will be used in the main activity*/
class DataGenerator {
        companion object {
            fun loadData(): ArrayList<MoodModel> {
                val data = ArrayList<MoodModel>()
                data.add(MoodModel(
                    "Happy",
                    R.drawable.happy,
                    adjectives = arrayOf<String>("Joyful", "Cheerful", "Delighted", "Pleased", "Ecstatic", "Blissful", "Elated", "Grateful", "Content", "Overjoyed"),
                    color = Color.parseColor("#FCB53A")))

                data.add(MoodModel(
                    "Sad",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("Miserable", "Gloomy", "Melancholy", "Somber", "Depressed", "Sorrowful", "Blue", "Despondent", "Rejected", "Heartbroken"),
                    color = Color.parseColor("#C069D7")))

                data.add(MoodModel(
                    "Angry",
                    R.drawable.angry,
                    adjectives = arrayOf<String>("Furious", "Enraged", "Livid", "Irritated", "Incensed", "Fuming", "Seething", "Hostile", "Resentful", "Aggravated"),
                    color = Color.parseColor("#E64646")))

                data.add(MoodModel(
                    "Bored",
                    R.drawable.bored,
                    adjectives = arrayOf<String>("Uninterested", "Disinterested", "Apathetic", "Uninspired", "Mundane", "Tedious", "Monotonous", "Dull", "Tiresome", "Lethargic"),
                    color = Color.parseColor("#58BB71")))

                data.add(MoodModel(
                    "Anxious",
                    R.drawable.nervous,
                    adjectives = arrayOf<String>("Nervous", "Worried", "Apprehensive", "Uneasy", "Restless", "Jittery", "Fidgety", "Panicky", "Tense", "Agitated"),
                    color = Color.parseColor("#B65BD1")))

                data.add(MoodModel(
                    "Confused",
                    R.drawable.confused,
                    adjectives = arrayOf<String>("Perplexed", "Baffled", "Bewildered", "Puzzled", "Disoriented", "Muddled", "Fuddled", "Dazed", "Flustered", "Mixed-up"),
                    color = Color.parseColor("#FC8A3A")))

                data.add(MoodModel(
                    "In love",
                    R.drawable.inlove,
                    adjectives = arrayOf<String>("Smitten", "Enamored", "Adoring", "Devoted", "Infatuated", "Passionate", "Besotted", "Charmed", "Enchanted", "Amorous"),
                    color = Color.parseColor("#ED5D5F")))

                data.add(MoodModel(
                    "Nervous",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("Anxious", "Apprehensive", "Uneasy", "Jittery", "Tense", "Fidgety", "Worried", "Agitated", "Restless", "Nervous-wreck"),
                    color = Color.parseColor("#B65BD1")))
                return data
            }
        }
    }
