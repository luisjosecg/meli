package com.w.buscador.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.w.buscador.R
import com.w.buscador.view.fragments.BuscadorResulltadoFragment.BuscadorResulltadoFragmentCompanion.buscadorViewModel
import com.w.buscador.view.fragments.BuscadorResulltadoFragment.BuscadorResulltadoFragmentCompanion.queryParamsValueOffset
import kotlinx.android.synthetic.main.fragment_buscador_toolbar.*

/**
 * A simple [Fragment] subclass.
 */
class BuscadorToolbarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buscador_toolbar, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        setFocus()
    }

    companion object BuscadorToolbarFragmentCompanion {
        @JvmStatic
        fun newInstance() = BuscadorToolbarFragment().apply {}
        var textQuery : String = ""
    }

    private fun setOnClickListeners(){
        image_back.setOnClickListener{
            activity!!.finish()
        }

        image_close.setOnClickListener{
            search_view.setText("")
            image_close.visibility = View.GONE
        }

        search_view.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textQuery = p0.toString()
                queryParamsValueOffset = 0
                buscadorViewModel?.callProducts(textQuery, queryParamsValueOffset)
                image_close.visibility = View.VISIBLE
                ocultarClose(p0)
            }
        })

    }

    private fun setFocus(){
        search_view.requestFocus()
    }
    private fun ocultarClose(p0: CharSequence?){
        if(p0!!.isEmpty()){
            image_close.visibility = View.GONE
        }
    }

}
