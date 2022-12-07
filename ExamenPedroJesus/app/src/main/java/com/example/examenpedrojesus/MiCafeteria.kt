package com.example.approom

import android.app.Application
import androidx.room.Room
import com.example.examenpedrojesus.databases.CafeteriaDatabase

class MiCafeteria: Application() {
    companion object {
        lateinit var database: CafeteriaDatabase
    }


    override fun onCreate() {
        super.onCreate()
        MiCafeteria.database =  Room.databaseBuilder(this, CafeteriaDatabase::class.java, "cafeteria-db").build()
    }
}