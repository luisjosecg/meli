package com.w.buscador.util

import androidx.lifecycle.MutableLiveData
import com.w.buscador.model.Result
import com.w.buscador.model.Results

object RepositoryUtil {


    fun implementOffset(offset : Int , products: MutableLiveData<List<Result>>, mutableList : ArrayList<Result>, result : Results){
        if(result.results.isNotEmpty()){
            if(offset == 0){
                products.value = result.results
                mutableList.clear()
                mutableList.addAll(result.results)
            }else{
                mutableList.addAll(result.results)
                products.value =  mutableList
            }
        }
    }
}