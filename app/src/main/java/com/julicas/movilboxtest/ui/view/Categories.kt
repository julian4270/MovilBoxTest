package com.julicas.movilboxtest.ui.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julicas.movilboxtest.service.ProductsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import com.julicas.movilboxtest.model.Categories

/**
 * CategoriesUiState
 */
sealed interface CategoriesUiState {
    data class CategorySuccess(val categories: String) : CategoriesUiState
    object Error : CategoriesUiState
    object Loading : CategoriesUiState
}

class Categories : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var categoriesUiState: CategoriesUiState by mutableStateOf(CategoriesUiState.Loading)
        private set

    init {
        getCategories()
    }

    /**
     * Gets Categories information from the Categories API Retrofit service and updates the
     * [Categories] [List] [MutableList].
     */
    private fun getCategories() {
        viewModelScope.launch {
            categoriesUiState = CategoriesUiState.Loading
            categoriesUiState = try {val listCategories = ProductsApi.CategoriesApi.retrofitService.getCategories()
                CategoriesUiState.CategorySuccess(
                    "Success: ${listCategories.size} Categories retrieved"
                )
            } catch (e: IOException) {
                CategoriesUiState.Error
            } catch (e: HttpException) {
                CategoriesUiState.Error
            }
        }
    }
}