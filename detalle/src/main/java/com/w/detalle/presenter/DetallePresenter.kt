package com.w.detalle.presenter

import com.w.detalle.model.Item

interface DetallePresenter {

    fun callItemAPI(itemId: String)
    fun showItem(item : Item)
}