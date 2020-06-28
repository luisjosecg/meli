package com.w.buscador.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Service {
    @GET
    fun getItems(@Url product : String): Call<JsonObject>
}