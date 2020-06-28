package com.w.buscador.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.w.detalle.util.ConstantsUtil.PRODUCT_ID
import com.w.detalle.view.DetalleActivity

object FragmentUtil {


    fun replaceFragment (savedInstanceState: Bundle?, supportFragmentManager: FragmentManager, contendor : Int, fragment: Fragment){
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .replace(contendor, fragment)
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss()
        }
    }

    fun irADetalleActivity(producto_id : String, context: Context, activity: Class<DetalleActivity>){
        val intent = Intent (context,  activity)
        intent.putExtra(PRODUCT_ID, producto_id)
        context.startActivity(intent)
    }

}