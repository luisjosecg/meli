package com.w.detalle.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiAdapter {

    fun getRetrofit(url: String): Service {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }

}