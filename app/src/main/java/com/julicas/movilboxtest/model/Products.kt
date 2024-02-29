package com.julicas.movilboxtest.model

import kotlinx.serialization.Serializable

/**
 * Data class Products
 */
@Serializable
data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)