package com.w.buscador.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.w.buscador.R
import com.w.buscador.view.activitie.BuscadorMainActivity
import kotlinx.android.synthetic.main.fragment_buscador.*

class BuscadorFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buscador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    fun setOnClickListeners(){
        buscadorConstraint.setOnClickListener{
            iniciarBuscador()
        }
    }

    fun iniciarBuscador(){
        val intent = Intent (activity,  BuscadorMainActivity::class.java)
        startActivity(intent)
    }


}
