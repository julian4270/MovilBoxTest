package com.julicas.movilboxtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.room.Room.databaseBuilder
import com.julicas.movilboxtest.adapter.AdapterProducts
import com.julicas.movilboxtest.database.DBProducts
import com.julicas.movilboxtest.entities.Product
import com.julicas.movilboxtest.ui.ProductsApp
import com.julicas.movilboxtest.ui.theme.ProductsPhotosTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    var listproducts: MutableList<Product> = mutableListOf()
    lateinit var adapter: AdapterProducts
    lateinit var room: DBProducts
    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        room = databaseBuilder(this, DBProducts::class.java, "dbProducts").build()
    }
    private fun AddProduct(room: DBProducts, product: Product) {
        lifecycleScope.launch {
        room.daoProducts().AddProduct(product)
        getProducts(room)
        ClearInputs()
        }
    }

    private suspend fun getProducts(room: DBProducts) {
        listproducts = room.daoProducts().getProducts()
        setContent {
            ProductsPhotosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ProductsApp()
                }
            }
        }
    }

    private fun UpdateProduct(room: DBProducts, id: Int, product: String, categorie: String) {
        lifecycleScope.launch {
        room.daoProducts().updateProduct(id,product,categorie)
        getProducts(room)
        ClearInputs()
        }
    }

    private fun DeleteProduct(room: DBProducts, id: Int) {
        lifecycleScope.launch {
            room.daoProducts().deleteProduct(id)
            getProducts(room)
            ClearInputs()
        }
    }
    private fun ClearInputs() {
        product.product = ""
        product.categorie = ""
        product.description = ""
        product.discountPercentage = product.discountPercentage
        product.brand = ""
        product.price = product.price
        product.title = ""
        }
}