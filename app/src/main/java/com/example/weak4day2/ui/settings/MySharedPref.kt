package com.example.weak4day2.ui.settings

import android.content.Context


class MySharedPref(context: Context) {
    companion object {
        private const val FILE_KEY = "SET"
        private const val FONT_SIZE = "font_size"

    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)

    fun saveFont(size:Float){
        sharedPref.edit()
            .putString(FONT_SIZE,size.toString())
            .apply()
    }
    fun getFont():String {
        return sharedPref.getString(FONT_SIZE, "12").toString()
    }
}