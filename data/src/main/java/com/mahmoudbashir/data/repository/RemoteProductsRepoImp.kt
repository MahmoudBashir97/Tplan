package com.mahmoudbashir.data.repository

import com.mahmoudbashir.data.mapper.toDomain
import com.mahmoudbashir.data.remote.ApiServer
import com.mahmoudbashir.domain.model.ProductsModelItem
import com.mahmoudbashir.domain.repository.GetProductsRepoImpl
import javax.inject.Inject

class RemoteProductsRepoImp @Inject constructor(private val api:ApiServer):GetProductsRepoImpl {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrlFromNative(): String
    override suspend fun getProducts(): MutableList<ProductsModelItem>? {
        return  api.getProductsResponse().body()?.map { product->product.toDomain()}?.toMutableList()
    }
}