package com.w.mercadolibre

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object HomeUtil {

    fun replaceFragment (supportFragmentManager: FragmentManager, contendor : Int, fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(contendor, fragment)
            .commitAllowingStateLoss()
    }



}