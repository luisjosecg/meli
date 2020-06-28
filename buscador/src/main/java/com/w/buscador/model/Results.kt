package com.w.buscador.model


import com.google.gson.annotations.SerializedName


data class Results (@SerializedName("results") val results : List<Result>)