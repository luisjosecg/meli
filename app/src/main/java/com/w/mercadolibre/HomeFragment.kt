package com.w.mercadolibre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.w.buscador.view.fragments.BuscadorFragment
import com.w.mercadolibre.HomeUtil.replaceFragment

class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init(){
        replaceFragment(activity!!.supportFragmentManager, R.id.buscadorContentFrame, BuscadorFragment())
    }



}
