package com.sd.storedata.sharedpref

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private const val NAME = "name"
    private const val MY_PREF_NAME = "com.sd.storedata"
    fun saveName(context: Context, name: String) {
        val pref: SharedPreferences =
            context.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE)
        pref.edit().apply {
            putString(NAME, name)
            apply()
        }
    }

    fun getName(context: Context): String? {
        val pref: SharedPreferences =
            context.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE)
        return pref.getString(NAME, "")
    }

    fun removeName(context: Context) {
        val pref: SharedPreferences =
            context.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE)
        pref.edit().apply {
            remove(NAME)
            apply()
        }
    }
}