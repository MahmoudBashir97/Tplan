package com.mahmoudbashir.tplan.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.data.mapper.toLocal
import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(app:Application,private val useCase:GetProductsUseCase):AndroidViewModel(app) {
    val proList:MutableLiveData<List<ProductsResponseItem>> = MutableLiveData()

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch{
       val data =  useCase.invoke().data?.map { p->p.toLocal() }
        proList.postValue(data)
    }
}