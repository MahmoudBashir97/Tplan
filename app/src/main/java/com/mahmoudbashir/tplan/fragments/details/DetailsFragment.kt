package com.mahmoudbashir.tplan.fragments.details

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tplan.R
import com.example.tplan.databinding.DescriptionLayoutBinding
import com.example.tplan.databinding.FragmentDetailsBinding
import com.example.tplan.databinding.TitleDetailsLayoutBinding
import com.example.tplan.databinding.ToolbarLayoutBinding
import com.mahmoudbashir.tplan.utils.textToCurrency
import com.squareup.picasso.Picasso


@RequiresApi(Build.VERSION_CODES.M)
class DetailsFragment : Fragment(R.layout.fragment_details) {
    lateinit var binding:FragmentDetailsBinding
    lateinit var toolbarBinding:ToolbarLayoutBinding
    lateinit var descBinding:DescriptionLayoutBinding
    lateinit var titleBinding:TitleDetailsLayoutBinding

    val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        toolbarBinding = binding.incToolbar
        descBinding = binding.incDescription
        titleBinding = binding.incTitle

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpToolbar() {
        activity?.actionBar?.title = ""
        activity?.actionBar?.customView = toolbarBinding.toolbar
        toolbarBinding.toolbar.title = resources.getString(R.string.details)
        toolbarBinding.toolbar.setTitleTextColor(resources.getColor(R.color.main_color,resources.newTheme()))
        toolbarBinding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back)
        toolbarBinding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setUpViews(){
        setUpToolbar()
        binding.apply {
            titleBinding.txtTitle.text = args.product.title
            titleBinding.txtPrice.text = "".textToCurrency(args.product.price.toString(),"$")
            titleBinding.txtRate.text = args.product.rating.rate.toString()
            titleBinding.txtRateCount.text = args.product.rating.count.toString()
            descBinding.txtDescDetails.text = args.product.description

            Picasso.get()
                .load(args.product.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgProduct)
        }
    }

}