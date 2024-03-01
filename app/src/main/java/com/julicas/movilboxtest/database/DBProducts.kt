package com.julicas.movilboxtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.julicas.movilboxtest.DaoProducts
import com.julicas.movilboxtest.entities.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class DBProducts: RoomDatabase() {
    abstract fun daoProducts(): DaoProducts
}