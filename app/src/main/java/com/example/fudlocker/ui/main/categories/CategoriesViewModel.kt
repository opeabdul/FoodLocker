package com.example.fudlocker.ui.main.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.*
import com.example.fudlocker.data.ProductRepository
import com.example.fudlocker.model.CategoriesResponse
import com.example.fudlocker.model.Category
import com.example.fudlocker.model.Product
import com.example.fudlocker.model.ProductsResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class CategoriesViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()


    fun setIndex(index: Int) {
        _index.value = index
    }



    private val repository =  ProductRepository.getInstance()
    private val TAG = CategoriesViewModel::class.java.simpleName
    private var job: Job? = null


    private val _categoriesResponseLiveData = MutableLiveData<CategoriesResponse>()
    val categoryList: LiveData<List<Category>> = Transformations.map(_categoriesResponseLiveData){ productResponse ->
        productResponse?.categories ?: listOf()
    }


    init{
        getAllProducts()
    }

    private fun getAllProducts(){
        job?.cancel()
        job = viewModelScope.launch {
            try {
                _categoriesResponseLiveData.value =  repository.getAllCategories()
            }catch (e: IOException){
                Log.e(TAG, e.message, e)
                _categoriesResponseLiveData.value = null
            }
        }
    }

}