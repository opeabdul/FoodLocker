package com.example.fudlocker.ui.main.locations

import android.util.Log
import androidx.lifecycle.*
import com.example.fudlocker.data.ProductRepository
import com.example.fudlocker.model.Location
import com.example.fudlocker.model.LocationResponse
import com.example.fudlocker.ui.main.categories.CategoriesViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class LocationsViewModel : ViewModel() {
    private val TAG = LocationsViewModel::class.java.simpleName
    private val _index = MutableLiveData<Int>()

    private val _locationResponse = MutableLiveData<LocationResponse>()

    var job: Job? = null
    private var repository = ProductRepository.getInstance()

    val locationList: LiveData<List<Location>> = Transformations.map(_locationResponse){
            locationResponse ->
        locationResponse?.locations ?: listOf()
    }

    init {
        getLocations()
    }

    private fun getLocations(){
        job?.cancel()
        job = viewModelScope.launch {
            try{
                _locationResponse.value = repository.getAllLocations()
            }catch (e: IOException){
                Log.e(TAG, e.message, e)
                _locationResponse.value = null
            }
        }
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}