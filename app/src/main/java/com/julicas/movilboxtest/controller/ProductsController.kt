package com.julicas.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.julicas.movilboxtest.R
import com.julicas.movilboxtest.adapter.AdapterProducts
import com.julicas.movilboxtest.entities.Product
/*
* ProductsController got o item_rv_product layaout
* */
class ProductsController(
    val listProducts: MutableList<Product>,
    val listener: AdapterProducts
): RecyclerView.Adapter<ProductsController.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_product, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = listProducts[position]
        holder.tvProduct.text = product.product
        holder.tvCategorie.text = product.categorie

        holder.cvProduct.setOnClickListener {
            listener.onEditItemClick(product)
        }

        holder.btnDelete.setOnClickListener {
            listener.onDeleteItemClick(product)
        }
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val cvProduct = itemView.findViewById<CardView>(R.id.cvProduct)
        val tvProduct = itemView.findViewById<TextView>(R.id.tvProduct)
        val tvCategorie = itemView.findViewById<TextView>(R.id.tvCategorie)
        val btnDelete = itemView.findViewById<Button>(R.id.btnDelete)
    }
}