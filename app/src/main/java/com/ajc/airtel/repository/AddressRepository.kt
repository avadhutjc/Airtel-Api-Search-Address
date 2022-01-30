package com.ajc.airtel.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ajc.airtel.remote.ResponseDTO
import com.ajc.airtel.remote.api.ApiClient

class AddressRepository(private val userApi: ApiClient) {
    private val contentType = "application/json"
    private val userLiveData = MutableLiveData<ResponseDTO>()
    val user: LiveData<ResponseDTO> get() = userLiveData

    suspend fun getData(queryString: String, city: String) {
        val result = userApi.getLocationFromAPI(contentType, queryString = queryString, city = city)
        if (result.body() != null) {
            userLiveData.postValue(result.body())
        }
    }
}