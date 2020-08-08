package com.example.fudlocker.model

import com.squareup.moshi.Json

data class Product(
    val id: Int,
    @Json(name = "image")val image: String,
    @Json(name = "name")val productName: String,
    @Json(name = "description")val description: String,
    @Json(name = "category_id") val catergoryId: Int,
    @Json(name = "slug")val model: String,
    @Json(name = "first_inventory_price")val price: Long
) {

}


data class User(
    val name: String,
    val email: String,
    val phone: String,
    val country: String,
    val password: String
)

data class ProductsResponse (@Json(name = "sort_key")val sortKey: String,
                             @Json(name = "products")val products: List<Product>,
                             @Json(name = "total_products")val totalProducts: String,
                             @Json(name = "pager_current_page")val pagerCurrentPage: String,
                             @Json(name = "pager_total_pages")val pagerTotalPages: String){
}