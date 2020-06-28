package com.w.buscador.viewModel

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.w.buscador.model.Result
import com.w.buscador.repository.BuscadorRepository
import com.w.buscador.repository.BuscadorRepositoryImpl

class BuscadorObservable : BaseObservable() {

    private var  buscadorRepository : BuscadorRepository = BuscadorRepositoryImpl()

    fun  callProducts(item : String, offset : Int){
        buscadorRepository.callProductAPI(item, offset)
    }

    fun getProducts() : MutableLiveData<List<Result>> {
        return buscadorRepository.getProduct()
    }
}