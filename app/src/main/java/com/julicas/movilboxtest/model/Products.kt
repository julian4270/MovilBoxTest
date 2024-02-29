package com.julicas.movilboxtest.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val id: String,
    val title: String,
    val description: String,
    val discountPercentage: String,
    val rating: String,
    val stock: String,
    val brand: String,
    val category: String,
    @SerialName(value = "thumbnail")
    val thumbnail: String,
    @SerialName(value = "images")
    val images: String
)