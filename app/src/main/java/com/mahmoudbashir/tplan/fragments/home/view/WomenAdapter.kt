package com.mahmoudbashir.tplan.fragments.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tplan.R
import com.example.tplan.databinding.ViewItemCardBinding
import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.tplan.utils.textToCurrency
import com.squareup.picasso.Picasso

class WomenAdapter(val listener:ClickedItemListener): RecyclerView.Adapter<WomenAdapter.VH>() {

    private  var proList:List<ProductsResponseItem> = ArrayList()
    fun setList(list:List<ProductsResponseItem>){
        this.proList = list
        notifyDataSetChanged()
    }

    inner class VH(private val binding:ViewItemCardBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: ProductsResponseItem){
            binding.apply {
                Picasso.get().load(item.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.proImg)
                txtProTitle.text = item.title
                txtProPrice.text = "".textToCurrency(item.price.toString(),"$")
                txtProRating.text = item.rating.rate.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
       return VH(ViewItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(proList[position])
        holder.itemView.setOnClickListener{
            listener.onItemClicked(position,proList[position])
        }
    }

    override fun getItemCount(): Int = proList.size
}