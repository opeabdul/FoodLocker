package com.example.fudlocker.ui.main.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.fudlocker.data.ProductRepository
import com.example.fudlocker.model.Product

class ProductsDataSourceFactory(val repository: ProductRepository): DataSource.Factory<Int, Product>() {
    private val _productLiveData = MutableLiveData<ProductDataSource>()
    val productLiveData: LiveData<ProductDataSource>
    get() = _productLiveData

    override fun create(): DataSource<Int, Product> {
        val productDataSource =  ProductDataSource(repository)
        _productLiveData.postValue(productDataSource)
        return productDataSource
    }

}