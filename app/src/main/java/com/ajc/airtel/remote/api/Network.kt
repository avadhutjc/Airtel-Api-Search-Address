package com.ajc.airtel.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    //https://digi-api.airtel.in/compassLocation/rest/address/autocomplete?queryString=airtel&city=gurgaon
    companion object {
        val BaseUrl = "https://digi-api.airtel.in/compassLocation/rest/address/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}