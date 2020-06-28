package com.w.detalle.view

import com.w.detalle.model.Item

interface DetalleView {

    fun showItem(item : Item)
    fun callItemAPI(itemId: String)

}