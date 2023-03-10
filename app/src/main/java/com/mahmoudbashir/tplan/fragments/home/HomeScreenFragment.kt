package com.mahmoudbashir.tplan.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.tplan.databinding.FragmentHomeScreenBinding
import com.mahmoudbashir.data.models.ProductsResponseItem
import com.mahmoudbashir.tplan.fragments.home.view.*
import com.mahmoudbashir.tplan.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreenFragment : Fragment() ,
ClickedItemListener{
    lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeViewModel>()
    lateinit var bannerAdapter: BannerItemsAdapter
    private lateinit var mlist:List<ProductsResponseItem>
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var mensAdapter: MensAdapter
    private lateinit var womenAdapter: WomenAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoading()
        initObserver()
    }

    private fun initLoading(){
        binding.proBar.visibility = View.VISIBLE
        doInitialize()

        binding.viewBanners.apply {
            adapter = bannerAdapter
            offscreenPageLimit = 3
            setPageTransformer(SliderTransformer(3))
        }

        setUpRecyclerViews()
    }

    private fun doInitialize() {
        mlist = ArrayList()
        bannerAdapter = BannerItemsAdapter()
        productsAdapter = ProductsAdapter(this)
        mensAdapter = MensAdapter(this)
        womenAdapter = WomenAdapter(this)
    }

    private fun setUpRecyclerViews(){
        binding.recMen.setupRecyclerView(mensAdapter)
        binding.recWomen.setupRecyclerView(womenAdapter)
        binding.recOther.setupRecyclerView(productsAdapter)
    }

    private fun initObserver(){
        viewModel.watchOnProductList().observe(viewLifecycleOwner){
            productList->

            if (!productList.isNullOrEmpty()){

                manageVisibility()

                mlist = productList
                bannerAdapter.setList(productList)

                lifecycleScope.launchWhenStarted {
                    reverseItSelf()
                }
                mensAdapter.setList(productList.mensProducts())
                womenAdapter.setList(productList.womenProducts())
                productsAdapter.setList(productList.otherProducts())
            }
        }

    }

    private fun manageVisibility() {
        binding.proBar.visibility = View.GONE
        binding.viewBanners.visibility = View.VISIBLE
        binding.menConstraint.visibility = View.VISIBLE
        binding.womenConstrain.visibility = View.VISIBLE
        binding.othersConstrain.visibility = View.VISIBLE
    }

    private suspend fun reverseItSelf():Unit{
    if (reverseCount == 0){
        for (p in mlist.indices){
            binding.viewBanners.setCurrentItem(++reverseCount,true)
            delay(1200)
            if (reverseCount == mlist.size) {
                return reverseItSelf()
            }
        }
    }else{
        for (p in mlist.indices){
            binding.viewBanners.setCurrentItem(reverseCount--,true)
            delay(1200)
            if (reverseCount == 0) {
                return reverseItSelf()
            }
        }
    }

}
    companion object{
        var reverseCount  = 0
    }

    override fun onItemClicked(position: Int, product: ProductsResponseItem) {
        findNavController().navigate(HomeScreenFragmentDirections.
        actionHomeScreenFragmentToDetailsFragment(product)
        )
    }
}