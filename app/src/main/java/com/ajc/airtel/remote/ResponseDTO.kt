package com.ajc.airtel.remote


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("requestId")
    val requestId: String?
)