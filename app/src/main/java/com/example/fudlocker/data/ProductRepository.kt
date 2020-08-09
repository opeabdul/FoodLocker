package com.example.fudlocker.data

import androidx.lifecycle.LiveData
import com.example.fudlocker.model.CategoriesResponse
import com.example.fudlocker.model.LocationResponse
import com.example.fudlocker.model.ProductsResponse
import com.example.fudlocker.network.ServiceApi
import com.example.fudlocker.network.ServiceRequests
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ProductRepository (apiServiceRequests: ServiceRequests,
                         private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO){

    companion object{
        private var instance: ProductRepository? = null

        fun getInstance(): ProductRepository{
            return instance ?: ProductRepository(ServiceApi.retrofitService).also {
                instance = it
            }
        }
    }

    private val productRequest = apiServiceRequests.getProductsDetails(ALL_PRODUCTS)
    private val categoriesRequest = apiServiceRequests.getCategories(ALL_CATEGORIES)
    private val locationRequest = apiServiceRequests.getLocations(ALL_LOCATIONS)

    suspend fun getAllProducts(): ProductsResponse = productRequest.await()
    suspend fun getAllCategories(): CategoriesResponse = categoriesRequest.await()
    suspend fun getAllLocations(): LocationResponse = locationRequest.await()

}