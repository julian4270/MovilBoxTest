package com.julicas.movilboxtest.adapter

import com.julicas.movilboxtest.entities.Product
interface AdapterProducts {
    fun onEditItemClick(product: Product)
    fun onDeleteItemClick(product: Product)
}