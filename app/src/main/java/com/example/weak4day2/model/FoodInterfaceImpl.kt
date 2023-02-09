package com.example.weak4day2.model

import com.example.weak4day2.ui.Foods
import com.example.weak4day2.R

class FoodInterfaceImpl:FoodInterface {
    val strings2 = listOf("foodADD1","foodADD2","foodADD3","foodADD4")
    val namesList = mutableListOf(

        Foods("Food1", R.drawable.baseline_fastfood_24),
        Foods("Food2", R.drawable.baseline_emoji_food_beverage_24),
        Foods("Food3", R.drawable.baseline_fastfood_24),
        Foods("Food4", R.drawable.baseline_emoji_food_beverage_24),
        Foods("Food5", R.drawable.baseline_fastfood_24),
        Foods("Food6", R.drawable.baseline_emoji_food_beverage_24),
        Foods("Food7", R.drawable.baseline_fastfood_24),
        Foods("Food8", R.drawable.baseline_emoji_food_beverage_24),
        Foods("Food9", R.drawable.baseline_fastfood_24),

        )
    override fun getFoodList(): MutableList<Foods>{
        return namesList
    }
    override fun removeItem() {
        namesList.removeLast()
    }
    override fun addItem() {
        namesList.add(1,Foods(strings2.random(),R.drawable.baseline_catching_pokemon_24))
    }

    override fun removeByIndex(x:Int) {
            namesList.removeAt(x)

    }
}

