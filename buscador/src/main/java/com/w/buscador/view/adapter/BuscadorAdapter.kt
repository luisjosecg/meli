package com.w.buscador.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.w.buscador.model.Result
import com.w.buscador.view.holder.BuscadorViewHolder
import com.w.buscador.viewModel.BuscadorViewModel

class BuscadorAdapter(private var buscadorViewModel: BuscadorViewModel, private var resource: Int)
    : RecyclerView.Adapter<BuscadorViewHolder>() {

    private var products: List<Result>? = null

    fun setProductList(products : List<Result>){
        this.products = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuscadorViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return  BuscadorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuscadorViewHolder, position: Int) {
       holder.setDataProduct(buscadorViewModel, position )
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition()
    }

    private fun getLayoutIdForPosition() : Int{
        return resource
    }

    override fun getItemCount(): Int {
        return  products?.size ?: 0
    }

}