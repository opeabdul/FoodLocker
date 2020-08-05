package com.example.fudlocker.model

data class Product(val image: String,
                   val name: String,
                   val model: String,
                   val price: String){

}


data class User(val name: String,
                val email: String,
                val phone: String,
                val country: String,
                val password: String,)