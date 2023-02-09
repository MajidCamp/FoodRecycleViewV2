package com.example.weak4day2.model

import com.example.weak4day2.ui.Foods

interface FoodInterface {
    fun getFoodList(): List<Foods>
    fun removeItem()
    fun addItem()
    fun removeByIndex(x:Int)


}