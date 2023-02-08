package com.example.weak4day2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weak4day2.model.FoodInterface
import com.example.weak4day2.model.FoodInterfaceImpl
import com.example.weak4day2.ui.Foods


class FoodViewModel :ViewModel(){
    private var _foodList: MutableLiveData<List<Foods>> = MutableLiveData(emptyList())
    val foodList:LiveData<List<Foods>> get() = _foodList
    private val foodinterface: FoodInterface = FoodInterfaceImpl() //Error inter -> class

    init {
        getListOfFood()
    }
    fun getListOfFood(){
        _foodList.value=foodinterface.getFoodList()
    }


}