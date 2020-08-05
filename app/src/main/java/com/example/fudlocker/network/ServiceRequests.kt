package com.example.fudlocker.network

import com.example.fudlocker.model.Product
import com.example.fudlocker.model.User
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

private const val BASE_URL = "http://v2.foodlocker.com.ng/apiv1/"

interface ServiceRequests {



    @GET("assessment/filter.json")
    fun getAllProductsCatergoryLocations(@Query("action") action: String ): Deferred<List<Product>>

    @POST("action=login")
    fun login(email: String, password: String)

    @POST("action=register")
    fun register(@Body user: User)

    @POST("")
    fun 
}

private val moshi= Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()