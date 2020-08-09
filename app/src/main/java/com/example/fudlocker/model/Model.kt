package com.example.fudlocker.model

import com.squareup.moshi.Json

data class Product(
    val id: Int,
    @Json(name = "image") val image: String,
    @Json(name = "name") val productName: String,
    @Json(name = "description") val description: String,
    @Json(name = "category_id") val catergoryId: Int,
    @Json(name = "slug") val model: String,
    @Json(name = "first_inventory_price") val price: Long
)

data class Category(
    val id: Int,
    val image: String,
    val name: String,
    @Json(name = "slug") val model: String
)

data class Location(
    val id: Int,
    val name: String,
    val time: String,
    val price: String,
    @Json(name = "parent_id")val parentid: String,
    @Json(name = "created_at")val createdAt: String,
    @Json(name = "updated_at")val updatedAt: String,
    val active: String,
    val vat: String
)


data class User(
    val name: String,
    val email: String,
    val phone: String,
    val country: String,
    val password: String
)

data class ProductsResponse(
    @Json(name = "sort_key") val sortKey: String,
    @Json(name = "products") val products: List<Product>,
    @Json(name = "total_products") val totalProducts: String,
    @Json(name = "pager_current_page") val pagerCurrentPage: String,
    @Json(name = "pager_total_pages") val pagerTotalPages: String
)

data class CategoriesResponse(@Json(name = "categories") val categories: List<Category>)

data class LocationResponse(@Json(name = "locations") val locations: List<Location>)