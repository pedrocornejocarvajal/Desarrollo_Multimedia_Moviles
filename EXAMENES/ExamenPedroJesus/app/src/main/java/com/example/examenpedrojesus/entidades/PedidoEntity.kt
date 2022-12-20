package com.example.examenpedrojesus.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tPedido")
data class PedidoEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var numMesa:Int,
    var numCafe:Int,
    var numInfusion:Int,
    var numTostada:Int,
    var numCroissant:Int,
    var numAsientos:Int

)
