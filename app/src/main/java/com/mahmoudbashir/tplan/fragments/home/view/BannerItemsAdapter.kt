package com.mahmoudbashir.tplan.fragments.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tplan.R
import com.example.tplan.databinding.ViewItemViewPagerBinding
import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.tplan.utils.textToCurrency
import com.squareup.picasso.Picasso

class BannerItemsAdapter:
    RecyclerView.Adapter<BannerItemsAdapter.VH>() {

    private var proList:List<ProductsResponseItem> = ArrayList()

    fun setList(list: List<ProductsResponseItem>){
        this.proList = list
        notifyDataSetChanged()
    }

   class VH(private val itemPageBinding: ViewItemViewPagerBinding)
        : RecyclerView.ViewHolder(itemPageBinding.root){
            fun bind(product:ProductsResponseItem){

                itemPageBinding.apply {
                    Picasso.get().load(product.image)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(img)
                    txtTitle.text = product.title
                    txtPrice.text = "".textToCurrency(product.price.toString(),"$")
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding =ViewItemViewPagerBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)

        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(proList[position])
    }

    override fun getItemCount(): Int = proList.size
}