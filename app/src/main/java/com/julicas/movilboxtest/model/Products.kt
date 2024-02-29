package com.julicas.movilboxtest.model
/**
 * Data class Products
 */
data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)