package com.ajc.airtel.remote.api

import com.ajc.airtel.remote.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiClient {
    //https://digi-api.airtel.in/compassLocation/rest/address/autocomplete?queryString=airtel&city=gurgaon
    @Headers("Accept: application/json")
    @GET("autocomplete")
    suspend fun getLocationFromAPI(
        @Header("Content-type") contentType:String,
        @Query("queryString") queryString:String,
        @Query("city")city:String
    ): Response<ResponseDTO>
}