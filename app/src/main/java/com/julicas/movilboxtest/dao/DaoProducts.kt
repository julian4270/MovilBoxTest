package com.julicas.movilboxtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.julicas.movilboxtest.entities.Product

@Dao
interface DaoProducts {

    @Query("SELECT * FROM products")
    suspend fun getProducts(): MutableList<Product>

    @Insert
    suspend fun AddProduct(product: Product)

    @Query("UPDATE products set categorie=:categorie WHERE id=:id")
    suspend fun updateProduct(id: Int, product: String, categorie: String)

    @Query("DELETE FROM products WHERE product=:id")
    suspend fun deleteProduct(id: Int)

}