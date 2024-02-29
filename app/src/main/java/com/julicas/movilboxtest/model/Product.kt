package com.julicas.movilboxtest.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
/**
 * Data class Product
 * return Images list
 */
@Serializable
data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    @SerialName(value = "images")
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)