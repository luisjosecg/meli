package com.w.detalle.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.w.detalle.R
import com.w.detalle.util.ConstantsUtil.PICTURE_URL
import kotlinx.android.synthetic.main.detalle_fragment_image.*

class DetalleImageFragment : Fragment() {

    private var urlPicture : String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detalle_fragment_image, container, false)
    }

    companion object {
        fun newInstance(url: String) : DetalleImageFragment {
            val detalleImageFragment = DetalleImageFragment()
            val args = Bundle()
            args.putString(PICTURE_URL, url)
            detalleImageFragment.arguments = args
            return detalleImageFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        urlPicture = arguments?.get(PICTURE_URL).toString()
        loadPicture()
    }



    private fun loadPicture(){
        Glide.with(this)
            .load(urlPicture)
            .into(image_view)
    }






}