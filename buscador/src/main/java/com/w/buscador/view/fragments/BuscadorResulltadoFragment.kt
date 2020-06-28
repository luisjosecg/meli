package com.w.buscador.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.w.buscador.R
import com.w.buscador.view.fragments.BuscadorToolbarFragment.BuscadorToolbarFragmentCompanion.textQuery
import com.w.buscador.viewModel.BuscadorViewModel
import com.w.buscador.databinding.FragmentBuscadorResulltadoBinding
import com.w.buscador.util.FragmentUtil

class BuscadorResulltadoFragment : Fragment(){

    private lateinit var fragmentbuscadorBinding : FragmentBuscadorResulltadoBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buscador_resulltado, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentUtil.replaceFragment(savedInstanceState, activity!!.supportFragmentManager,  R.id.buscador_frame_layout_toolbar, BuscadorToolbarFragment.newInstance())
        prepararBindings()
        setOnClickListeners()
    }

    companion object BuscadorResulltadoFragmentCompanion {
        @JvmStatic
        fun newInstance() = BuscadorResulltadoFragment().apply {}
        var buscadorViewModel :  BuscadorViewModel? = null
        var queryParamsValueOffset : Int = 0
    }

    private fun prepararBindings(){
        fragmentbuscadorBinding = DataBindingUtil.setContentView(activity!!, R.layout.fragment_buscador_resulltado)
        buscadorViewModel = ViewModelProvider.NewInstanceFactory().create(BuscadorViewModel::class.java)
        fragmentbuscadorBinding.model = buscadorViewModel
        setUpListUpdate()
    }

    private fun setUpListUpdate(){
        buscadorViewModel?.getProducts()?.observe(activity!!, Observer {
            buscadorViewModel?.setProductsInRecyclerAdapter(it)
        })
    }

    private fun setOnClickListeners(){
        fragmentbuscadorBinding.listRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()/2){
                    queryParamsValueOffset += 1
                    buscadorViewModel?.callProducts(textQuery, queryParamsValueOffset)
                }
            }
        })
    }

}
