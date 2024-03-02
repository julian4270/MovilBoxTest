package com.julicas.movilboxtest.adapter

import com.julicas.movilboxtest.entities.Product
/*
* AdapterProducts
* */
interface AdapterProducts {
    fun onEditItemClick(product: Product)
    fun onDeleteItemClick(product: Product)
}