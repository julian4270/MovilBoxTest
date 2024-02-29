/*
 * Copyright (C) 2024 The Android Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.julicas.movilboxtest.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julicas.movilboxtest.network.ProductsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface ProductsUiState {
    data class Success(val products: String) : ProductsUiState
    object Error : ProductsUiState
    object Loading : ProductsUiState
}

class ProductsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var productsUiState: ProductsUiState by mutableStateOf(ProductsUiState.Loading)
        private set

    /**
     * Call getProducts() on init so we can display status immediately.
     */
    init {
        getProducts()
    }

    init {
        getCategories()
    }

    /**
     * Gets Products photos information from the Porduct BASE_URL API Retrofit service and updates the
     */

    fun getProducts() {
        viewModelScope.launch {
            productsUiState = ProductsUiState.Loading
            productsUiState = try {
                val listResult = ProductsApi.retrofitService.getProducts()
                ProductsUiState.Success(
                    "Success: ${listResult.size} Products retrieved"
                )
            } catch (e: IOException) {
                ProductsUiState.Error
            } catch (e: HttpException) {
                ProductsUiState.Error
            }
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            productsUiState = ProductsUiState.Loading
            productsUiState = try {
                val listResult = ProductsApi.CategoriesApi.retrofitService.getCategories()
                ProductsUiState.Success(
                    "Success: ${listResult.size} Products retrieved"
                )
            } catch (e: IOException) {
                ProductsUiState.Error
            } catch (e: HttpException) {
                ProductsUiState.Error
            }
        }
    }
}
