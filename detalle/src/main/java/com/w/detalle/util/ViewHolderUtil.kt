package com.w.detalle.util

object ViewHolderUtil {

    fun setString(attributesValue: String?) : String{
        if(attributesValue == null){
            return "-"
        }
        return attributesValue
    }

}