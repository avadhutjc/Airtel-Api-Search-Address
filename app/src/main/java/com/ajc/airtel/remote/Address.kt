package com.ajc.airtel.remote


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("addressString")
    val addressString: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("pinCode")
    val pinCode: String?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("source")
    val source: String?
)