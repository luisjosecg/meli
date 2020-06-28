package com.w.buscador.repository

import androidx.lifecycle.MutableLiveData
import com.w.buscador.model.Result

interface BuscadorRepository {
    fun getProduct() : MutableLiveData<List<Result>>
    fun callProductAPI(item: String, offset : Int)
}