package com.w.buscador.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.w.buscador.api.Constants.GET_SEARCH
import com.w.buscador.api.Constants.GET_SITES
import com.w.buscador.api.Constants.GET_SITE_ID
import com.w.buscador.api.Constants.QUERY_PARAMS_KEY_Q
import com.w.buscador.api.Constants.QUERY_PARAMS_OFFSET
import com.w.buscador.api.Constants.URL_BASE_API_MERCADO_LIBRE
import com.w.buscador.api.RestApiAdapter
import com.w.buscador.api.Service
import com.w.buscador.model.Result
import com.w.buscador.model.Results
import com.w.buscador.util.RepositoryUtil.implementOffset
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscadorRepositoryImpl : BuscadorRepository {


    private var mutableList = arrayListOf<Result>()
    private var products = MutableLiveData<List<Result>>()

    override fun callProductAPI (item : String, offset : Int){
        val service: Service = RestApiAdapter.getRetrofit(URL_BASE_API_MERCADO_LIBRE + GET_SITES + GET_SITE_ID )
        val call: Call<JsonObject> = service.getItems(  GET_SEARCH + QUERY_PARAMS_OFFSET + offset + QUERY_PARAMS_KEY_Q + item)
        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.body() != null && response.code() == 200) {
                    val result = Gson().fromJson(response.body(), Results::class.java)
                    implementOffset(offset,products, mutableList, result)

                } else {
                    Log.e("Error response API", response.toString())
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Log.e("Error call API", t.toString())
            }
        })
    }

    override fun getProduct() : MutableLiveData<List<Result>>{
        return products
    }
}