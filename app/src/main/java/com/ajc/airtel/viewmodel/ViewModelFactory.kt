package com.ajc.airtel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajc.airtel.repository.AddressRepository

class ViewModelFactory(val repo: AddressRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LocationViewModel(repo) as T
    }
}