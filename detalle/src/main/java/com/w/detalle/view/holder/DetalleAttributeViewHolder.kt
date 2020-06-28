package com.w.detalle.view.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.w.detalle.R
import com.w.detalle.model.Attribute
import com.w.detalle.util.ViewHolderUtil.setString
import kotlinx.android.synthetic.main.detalle_attribute_item.view.*


class DetalleAttributeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.detalle_attribute_item, parent, false)) {


    fun bind(attribute: Attribute) {
        itemView.attribute_name?.text = attribute.name
        itemView.attribute_value_name?.text = setString(attribute.valueName)
    }

}