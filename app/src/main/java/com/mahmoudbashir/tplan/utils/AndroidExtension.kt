package com.mahmoudbashir.tplan.utils

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mahmoudbashir.data.models.ProductsResponseItem

fun String.textToCurrency(price:String,currency:String):String{
    return "$price $currency"
}


fun List<ProductsResponseItem>.mensProducts():List<ProductsResponseItem>{
    return filter { it.category == "men's clothing" }
}

fun List<ProductsResponseItem>.womenProducts():List<ProductsResponseItem>{
    return filter { it.category == "women's clothing" }
}
fun List<ProductsResponseItem>.otherProducts():List<ProductsResponseItem>{
    return filter { it.category != "women's clothing" && it.category != "men's clothing" }
}

fun RecyclerView.setupRecyclerView(recAdapter:Adapter<*>){
        setHasFixedSize(true)
        scheduleLayoutAnimation()
        adapter = recAdapter

}