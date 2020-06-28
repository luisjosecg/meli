package com.w.detalle.repository

import com.w.detalle.model.Item

interface DetalleRepository {

    fun callItemAPI(itemId : String)
    fun showItems(item : Item)
}