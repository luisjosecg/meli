package com.w.detalle.presenter

import com.w.detalle.model.Item
import com.w.detalle.repository.DetalleRepositoryImpl
import com.w.detalle.view.DetalleView

class DetallePresenterImpl (private val detallleView : DetalleView) : DetallePresenter {

    private var detalleRepository = DetalleRepositoryImpl(this)


    override fun callItemAPI(itemId: String) {
        detalleRepository.callItemAPI(itemId)
    }

    override fun showItem(item : Item) {
        detallleView.showItem(item)
    }


}