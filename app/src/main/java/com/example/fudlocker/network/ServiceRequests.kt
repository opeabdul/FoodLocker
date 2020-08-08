package com.example.fudlocker.network

import com.example.fudlocker.model.User
import com.example.fudlocker.model.ProductsResponse
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

private const val BASE_URL = "http://v2.foodlocker.com.ng/"

interface ServiceRequests {



    @GET("apiv1?action=all_products")
    fun getProductsDetails(
//        @Query("action") action: String
    ): Deferred<ProductsResponse>

    @POST("apiv1/action=login")
    fun login(email: String, password: String)

    @POST("apiv1/action=register")
    fun register(@Body user: User)


}

private val moshi= Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

object ServiceApi{
    val retrofitService: ServiceRequests by lazy { retrofit.create(ServiceRequests::class.java) }
}