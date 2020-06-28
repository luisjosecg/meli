package com.w.detalle.api

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Service {
    @GET
    fun getItems(@Url product : String): Call<JsonArray>
}