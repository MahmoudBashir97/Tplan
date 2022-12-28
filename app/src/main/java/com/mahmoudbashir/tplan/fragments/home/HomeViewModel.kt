package com.mahmoudbashir.tplan.fragments.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import com.mahmoudbashir.data.mapper.toLocal
import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(app:Application,private val getProductsUc: GetProductsUseCase)
    :AndroidViewModel(app){
    private val proList: MutableLiveData<List<ProductsResponseItem>?> = MutableLiveData()

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch{
        val data =  getProductsUc.invoke().data?.map { p->p.toLocal() }
        proList.postValue(data)
    }

    fun watchOnProductList()= proList
}