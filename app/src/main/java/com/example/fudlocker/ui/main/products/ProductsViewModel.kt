package com.example.fudlocker.ui.main.products

import android.util.Log
import androidx.lifecycle.*
import com.example.fudlocker.data.ProductRepository
import com.example.fudlocker.model.Product
import com.example.fudlocker.model.ProductsResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class ProductsViewModel : ViewModel() {

    private val TAG = ProductsViewModel::class.java.simpleName

    private val repository =  ProductRepository.getInstance()
    private val _productResponseLiveData = MutableLiveData<ProductsResponse>()
    private var job: Job? = null


    val productList: LiveData<List<Product>> = Transformations.map(_productResponseLiveData){ productResponse ->
        productResponse?.products
    }

    private val _index = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        _index.value = index
    }

    init{
        getAllProducts()
    }

    private fun getAllProducts(){
        job?.cancel()
        job = viewModelScope.launch {
            try {
               _productResponseLiveData.value =  repository.getAllProducts()
            }catch (e: IOException){
                Log.e(TAG, e.message, e)
                _productResponseLiveData.value = null
            }
        }
    }

}