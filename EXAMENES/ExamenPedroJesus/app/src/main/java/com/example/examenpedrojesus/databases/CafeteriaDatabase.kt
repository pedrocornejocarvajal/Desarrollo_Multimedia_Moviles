package com.example.examenpedrojesus.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.approom.CafeteriaDao
import com.example.examenpedrojesus.entidades.ConfiguracionEntity
import com.example.examenpedrojesus.entidades.PedidoEntity

@Database(entities = arrayOf(PedidoEntity::class, ConfiguracionEntity::class),version=1)
abstract class CafeteriaDatabase: RoomDatabase() {
    abstract fun CafeteriaDao(): CafeteriaDao
}