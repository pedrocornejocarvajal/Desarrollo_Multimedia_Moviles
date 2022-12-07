package com.example.approom

import androidx.room.*
import com.example.examenpedrojesus.entidades.ConfiguracionEntity
import com.example.examenpedrojesus.entidades.PedidoEntity

@Dao
interface CafeteriaDao {

    //Metodos Para Pedidos
    @Query("SELECT * FROM tPedido")
    suspend fun obtenerTodosLosPedidos(): MutableList<PedidoEntity>

    @Query("SELECT * FROM tPedido WHERE id = :id")
    suspend fun obtenerPedidoPorId(id: Long): PedidoEntity

    @Insert
    suspend fun addPedido (pedidoEntity: PedidoEntity):Long

    @Update
    suspend fun actualizarPedido(pedidoEntity: PedidoEntity)

    @Delete
    suspend fun borrarPedido(pedidoEntity: PedidoEntity)


    //Metodos para Configuracion
    @Query("SELECT * FROM tConf")
    suspend fun obtenerConfiguracion(): MutableList<ConfiguracionEntity>

    @Insert
    suspend fun addConfiguracion (configuracionEntity: ConfiguracionEntity):Long

    @Update
    suspend fun actualizarConfiguracion(configuracionEntity: ConfiguracionEntity)

    @Delete
    suspend fun borrarConfiguracion(configuracionEntity: ConfiguracionEntity)
}
