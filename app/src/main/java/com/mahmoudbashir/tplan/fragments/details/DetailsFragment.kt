package com.mahmoudbashir.tplan.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.tplan.R
import com.example.tplan.databinding.FragmentDetailsBinding
import com.mahmoudbashir.tplan.utils.textToCurrency
import com.squareup.picasso.Picasso


class DetailsFragment : Fragment(R.layout.fragment_details) {
    lateinit var binding:FragmentDetailsBinding
    val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.title = ""
        activity?.actionBar?.customView = binding.toolbar
        binding.toolbar.title = "Details"
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViews()
    }

    private fun setUpViews(){
        binding.apply {
            txtTitle.text = args.product.title
            txtPrice.text = "".textToCurrency(args.product.price.toString(),"$")
            txtRate.text = args.product.rating.rate.toString()
            txtRateCount.text = args.product.rating.count.toString()
            txtDescDetails.text = args.product.description

            Picasso.get()
                .load(args.product.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgProduct)
        }
    }
}