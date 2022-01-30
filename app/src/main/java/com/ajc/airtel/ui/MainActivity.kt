package com.ajc.airtel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.ajc.airtel.R
import com.ajc.airtel.remote.Address
import com.ajc.airtel.remote.ResponseDTO
import com.ajc.airtel.remote.SuggestionsList
import com.ajc.airtel.remote.api.ApiClient
import com.ajc.airtel.remote.api.Network
import com.ajc.airtel.repository.AddressRepository
import com.ajc.airtel.ui.adapter.ResultAdapter
import com.ajc.airtel.viewmodel.LocationViewModel
import com.ajc.airtel.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var newViewModel: LocationViewModel
    private lateinit var repository: AddressRepository
    private val addressList = ArrayList<Address>()
    private lateinit var addressAdapter: ResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userApi = Network.getInstance().create(ApiClient::class.java)
        repository = AddressRepository(userApi)
        val wishlistFactory = ViewModelFactory(repository)
        newViewModel = ViewModelProviders.of(this, wishlistFactory).get(LocationViewModel::class.java)
        
        search_view.setOnQueryChangeListener(FloatingSearchView.OnQueryChangeListener { oldQuery, newQuery ->
            newViewModel.getLocationData(oldQuery, "")
            newViewModel.user.observe(this, Observer {

                search_view.swapSuggestions(getSuggestions(it))
                addressList.clear()
                addressList.addAll(it.data?.addressList!!)
                setRecycler()
            })
        })
    }

    private fun getSuggestions(it: ResponseDTO?): MutableList<out SearchSuggestion>? {
        val suggestionsList = ArrayList<SuggestionsList>()
        val list = it?.data?.addressList

        list?.forEach {
            val suggestion =
                SuggestionsList(it.addressString)
            suggestionsList.add(suggestion)
        }
        return suggestionsList
    }

    private fun setRecycler() {
        addressAdapter = ResultAdapter(this, addressList)
        recycler.adapter = addressAdapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}