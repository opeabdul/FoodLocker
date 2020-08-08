package com.example.fudlocker.ui.main.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.fudlocker.data.ProductRepository
import com.example.fudlocker.model.Product

class ProductDataSource(val repository: ProductRepository): PageKeyedDataSource<Int, Product>() {
    private val _progressLiveStatus = MutableLiveData<String>()
    val progressLiveStatus: LiveData<String>
    get() = _progressLiveStatus

    val sourceindex: String? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Product>
    ) {

//        val data = repository.getAllProducts()


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Product>) {

    }

}