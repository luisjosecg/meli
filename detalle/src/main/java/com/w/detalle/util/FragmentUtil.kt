package com.w.detalle.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentUtil {

    fun replaceFragment (savedInstanceState : Bundle?, supportFragmentManager: FragmentManager, contendor : Int, fragment: Fragment){
        if (savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .replace(contendor, fragment)
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss()
        }

    }




}