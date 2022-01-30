package com.ajc.airtel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajc.airtel.remote.ResponseDTO
import com.ajc.airtel.repository.AddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel(private val dataRepository: AddressRepository) : ViewModel() {
    fun getLocationData(stringQuery: String, city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dataRepository.getData(stringQuery, city)
        }
    }

    val user: LiveData<ResponseDTO>
        get() = dataRepository.user
}