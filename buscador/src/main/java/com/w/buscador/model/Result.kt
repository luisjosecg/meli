package com.w.buscador.model

import com.google.gson.annotations.SerializedName

data class Result (@SerializedName("id") val id : String,
					@SerializedName("title") val title : String)