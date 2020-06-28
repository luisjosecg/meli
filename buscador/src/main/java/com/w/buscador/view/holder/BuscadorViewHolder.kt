package com.w.buscador.view.holder

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.w.buscador.BR
import com.w.buscador.viewModel.BuscadorViewModel
import com.w.buscador.util.FragmentUtil.irADetalleActivity
import com.w.detalle.view.DetalleActivity
import kotlin.Exception


class BuscadorViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

    private var binding : ViewDataBinding? = null

    init { this.binding = binding }

    fun setDataProduct(buscadorViewModel: BuscadorViewModel, position : Int){
        binding?.setVariable(BR.model, buscadorViewModel)
        binding?.setVariable(BR.position, position)
        binding?.executePendingBindings()



        binding?.root?.setOnClickListener {
            try {
                val productId : String = buscadorViewModel.getProductAt(position)!!.id
                val context : Context = binding?.root?.context!!
                irADetalleActivity(productId, context, DetalleActivity::class.java)
            }catch (e : Exception){
                e.printStackTrace()
            }
        }

    }

}