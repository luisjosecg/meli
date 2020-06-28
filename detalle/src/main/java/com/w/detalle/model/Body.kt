package com.w.detalle.model

import com.google.gson.annotations.SerializedName

data class Body (
	@SerializedName("title") val title : String,
	@SerializedName("price") val price : Int,
	@SerializedName("pictures") val pictures : List<Pictures>,
	@SerializedName("attributes") val attributes : List<Attribute>
)