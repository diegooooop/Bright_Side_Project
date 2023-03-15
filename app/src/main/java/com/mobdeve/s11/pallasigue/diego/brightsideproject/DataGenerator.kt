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
                    color = Color.parseColor("#F8EACD")))

                data.add(MoodModel(
                    "Sad",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("Miserable", "Gloomy", "Melancholy", "Somber", "Depressed", "Sorrowful", "Blue", "Despondent", "Rejected", "Heartbroken"),
                    color = Color.parseColor("#DAEDFC")))

                data.add(MoodModel(
                    "Angry",
                    R.drawable.angry,
                    adjectives = arrayOf<String>("Furious", "Enraged", "Livid", "Irritated", "Incensed", "Fuming", "Seething", "Hostile", "Resentful", "Aggravated"),
                    color = Color.parseColor("#FFE5CF")))

                data.add(MoodModel(
                    "Bored",
                    R.drawable.bored,
                    adjectives = arrayOf<String>("Uninterested", "Disinterested", "Apathetic", "Uninspired", "Mundane", "Tedious", "Monotonous", "Dull", "Tiresome", "Lethargic"),
                    color = Color.parseColor("#F7CDD0")))

                data.add(MoodModel(
                    "Anxious",
                    R.drawable.nervous,
                    adjectives = arrayOf<String>("Nervous", "Worried", "Apprehensive", "Uneasy", "Restless", "Jittery", "Fidgety", "Panicky", "Tense", "Agitated"),
                    color = Color.parseColor("#F3F7FA")))

                data.add(MoodModel(
                    "Confused",
                    R.drawable.confused,
                    adjectives = arrayOf<String>("Perplexed", "Baffled", "Bewildered", "Puzzled", "Disoriented", "Muddled", "Fuddled", "Dazed", "Flustered", "Mixed-up"),
                    color = Color.parseColor("#C7E1F8")))

                data.add(MoodModel(
                    "In love",
                    R.drawable.inlove,
                    adjectives = arrayOf<String>("Smitten", "Enamored", "Adoring", "Devoted", "Infatuated", "Passionate", "Besotted", "Charmed", "Enchanted", "Amorous"),
                    color = Color.parseColor("#FFF9C7")))

                data.add(MoodModel(
                    "Nervous",
                    R.drawable.anxious,
                    adjectives = arrayOf<String>("Anxious", "Apprehensive", "Uneasy", "Jittery", "Tense", "Fidgety", "Worried", "Agitated", "Restless", "Nervous-wreck"),
                    color = Color.parseColor("#F8F1FF")))
                return data
            }
        }
    }
