package com.mahmoudbashir.data.mapper

import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.data.models.Rating
import com.mahmoudbashir.domain.model.ProductsModelItem


fun ProductsModelItem.toLocal():ProductsResponseItem{
    return ProductsResponseItem(
        category,
        description,
        id,
        image,
        price,
        Rating(
            count = rating.count,
            rate = rating.rate
        ),
        title
    )
}

fun ProductsResponseItem.toDomain():ProductsModelItem{
    return ProductsModelItem(
        category,
        description,
        id,
        image,
        price,
        com.mahmoudbashir.domain.model.Rating(
            count = rating.count,
            rate = rating.rate
        ),
        title
    )
}