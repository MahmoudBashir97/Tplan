package com.mahmoudbashir.tplan.fragments.home.view

import com.mahmoudbashir.data.models.ProductsResponseItem

interface ClickedItemListener {
    fun onItemClicked(position:Int,product:ProductsResponseItem)
}