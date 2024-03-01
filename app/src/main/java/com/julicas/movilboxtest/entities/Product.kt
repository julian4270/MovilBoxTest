package com.julicas.movilboxtest.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "product")var product: String,
    @ColumnInfo(name = "categorie") var categorie: String,
    @ColumnInfo(name = "brand")var brand: String,
    @ColumnInfo(name = "category")var category: String,
    @ColumnInfo(name = "description")var description: String,
    @ColumnInfo(name = "discountPercentage")var discountPercentage: Double,
    @ColumnInfo(name = "images")var images: List<String>,//BD No relational
    @ColumnInfo(name = "price")var price: Int,
    @ColumnInfo(name = "rating")var rating: Double,
    @ColumnInfo(name = "stock")var stock: Int,
    @ColumnInfo(name = "thumbnail")var thumbnail: String,
    @ColumnInfo(name = "title")var title: String
)