package com.example.approom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.examenpedrojesus.R
import com.example.examenpedrojesus.entidades.PedidoEntity

class CafeteriaAdapter(
    val pedidos: List<PedidoEntity>,
    val checkPedidos: (PedidoEntity) -> Unit,
    val borrarPedidos: (PedidoEntity) -> Unit) : RecyclerView.Adapter<CafeteriaAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pedidos[position]
        holder.bind(item, checkPedidos, borrarPedidos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.tercera_vista, parent, false))
    }

    override fun getItemCount(): Int {
        return pedidos.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun bind(pedidos: PedidoEntity, checkTask: (PedidoEntity) -> Unit, deleteTask: (PedidoEntity) -> Unit) {

        }
    }
}

