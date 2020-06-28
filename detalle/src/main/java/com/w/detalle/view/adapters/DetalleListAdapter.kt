package com.w.detalle.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.w.detalle.model.Attribute
import com.w.detalle.view.holder.DetalleAttributeViewHolder


class DetalleListAdapter(private val list: List<Attribute>)
    : RecyclerView.Adapter<DetalleAttributeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleAttributeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DetalleAttributeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DetalleAttributeViewHolder, position: Int) {
        val movie: Attribute = list[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

}