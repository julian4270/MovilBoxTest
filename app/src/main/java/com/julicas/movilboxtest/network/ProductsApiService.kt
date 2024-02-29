package com.julicas.movilboxtest.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.julicas.movilboxtest.model.Categories
import com.julicas.movilboxtest.model.Products
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

    private const val BASE_URL =
        "https://dummyjson.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

interface ProductsApiService {
    @GET("products")
    suspend fun getProducts(): List<Products>
}

interface CategoriesApiService {
    @GET("categories")
    suspend fun getCategories(): List<Categories>
}

object ProductsApi {
    val retrofitService: ProductsApiService by lazy {
        retrofit.create(ProductsApiService::class.java)
    }

    object CategoriesApi {
        val retrofitService: CategoriesApiService by lazy {
            retrofit.create(CategoriesApiService::class.java)
        }
    }
}