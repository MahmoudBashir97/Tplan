package com.mahmoudbashir.domain.repository

import com.mahmoudbashir.domain.model.ProductsModelItem

interface GetProductsRepoImpl {
    suspend fun getProducts():MutableList<ProductsModelItem>?
}