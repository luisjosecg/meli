package com.w.buscador.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w.buscador.R
import com.w.buscador.model.Result
import com.w.buscador.view.adapter.BuscadorAdapter

class BuscadorViewModel : ViewModel() {

    private var buscadorObservable : BuscadorObservable =
        BuscadorObservable()
    private var recyclerProductsAdapter = BuscadorAdapter(this, R.layout.buscador_list_item)

    fun callProducts(item : String, offset : Int){
        buscadorObservable.callProducts(item, offset)
    }

    fun getProducts() : MutableLiveData<List<Result>> {
        return buscadorObservable.getProducts()
    }

    fun setProductsInRecyclerAdapter(products: List<Result>){
        recyclerProductsAdapter.setProductList(products)
        recyclerProductsAdapter.notifyDataSetChanged()
    }

    fun getRecyclerProductsAdapter() : BuscadorAdapter {
        return recyclerProductsAdapter
    }

    fun getProductAt(position: Int) : Result?{
        val products : List<Result>? = buscadorObservable.getProducts().value
        return products?.get(position)
    }


}