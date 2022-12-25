package com.mahmoudbashir.domain.mapper

import com.mahmoudbashir.domain.model.ProductsModelItem
import com.mahmoudbashir.domain.model.Rating

fun ProductsModelItem.toLocal():ProductsModelItem{
    return ProductsModelItem(
        "",
        "",
        0,
        "",
        0.0,
        Rating(
            0,
            0.0
        ),
        ""
    )
}