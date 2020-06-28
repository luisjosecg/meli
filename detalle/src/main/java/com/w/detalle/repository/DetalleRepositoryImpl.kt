package com.w.detalle.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import com.w.detalle.api.Constants.GET_ITEMS_IDS
import com.w.detalle.api.Constants.URL_BASE_API_MERCADO_LIBRE
import com.w.detalle.api.RestApiAdapter
import com.w.detalle.api.Service
import com.w.detalle.model.Item
import com.w.detalle.presenter.DetallePresenter
import retrofit2.Call
import retrofit2.Callback
import java.lang.reflect.Type

class DetalleRepositoryImpl (private var detallePresenter: DetallePresenter): DetalleRepository {


    override fun callItemAPI(itemId: String) {
        val service: Service = RestApiAdapter.getRetrofit(URL_BASE_API_MERCADO_LIBRE)
        val call: Call<JsonArray> = service.getItems( GET_ITEMS_IDS + itemId)
        call.enqueue(object : Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: retrofit2.Response<JsonArray>) {
                if (response.body() != null && response.code() == 200) {
                    val listType: Type = object : TypeToken<ArrayList<Item?>?>() {}.type
                    val result : List<Item> = Gson().fromJson(response.body(), listType)
                    showItems(result[0])
                } else {
                    Log.e("ERROR - RESPONSE- API", response.toString())
                }
            }
            override fun onFailure(call: Call<JsonArray?>, t: Throwable) {
                Log.e("ERROR - CALL - API", t.toString())
            }
        })
    }

    override fun showItems(item : Item) {
        detallePresenter.showItem(item)
    }

}