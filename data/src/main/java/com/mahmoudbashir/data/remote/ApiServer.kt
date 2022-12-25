package com.mahmoudbashir.data.remote

import com.mahmoudbashir.data.models.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiServer {

    @GET("products")
    suspend fun getProductsResponse()
    :Response<MutableList<ProductsResponseItem>>
}