package com.mahmoudbashir.domain.usecases

import com.mahmoudbashir.domain.model.ProductsModelItem
import com.mahmoudbashir.domain.repository.GetProductsRepoImpl
import com.mahmoudbashir.domain.utils.Resource

class GetProductsUseCase(private val repoImpl: GetProductsRepoImpl) {
    suspend operator fun invoke():Resource<MutableList<ProductsModelItem>?>{
        return try {
            val data = repoImpl.getProducts()
             Resource.Success(data)
        }catch (e:Exception){
            Resource.Error(e.message.toString())
        }
    }
}