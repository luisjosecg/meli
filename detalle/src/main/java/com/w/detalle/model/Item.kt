package com.w.detalle.model

import com.google.gson.annotations.SerializedName

data class Item (
	@SerializedName("body") val body : Body
)