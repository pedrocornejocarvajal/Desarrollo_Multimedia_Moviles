package com.example.examenpedrojesus.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tConf")
data class ConfiguracionEntity (

    var numMesas:Int,
    var numAsientos:Int,
    var precioCafe:Float,
    var precioInfusion:Float,
    var precioTostada:Float,
    var precioCroissant:Float,

)
