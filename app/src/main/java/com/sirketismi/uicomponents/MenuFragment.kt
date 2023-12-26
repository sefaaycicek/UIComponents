package com.sirketismi.uicomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sirketismi.uicomponents.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    lateinit var viewModel: MenuViewModel
    lateinit var binding : FragmentMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding = FragmentMenuBinding.inflate(inflater)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun openProductPage() {
        //val action = MenuFragmentDirections.actionMenuToProducts()
        setFragmentResultListener(ProductDetail.resultKey){ requestKey, bundle ->
            print(bundle)
        }
        viewModel.nameText.value?.let {
            val product = Product("ürün_adi")
            val action = MenuFragmentDirections.actionMenuToProductDetail(it, product)
            findNavController().navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.navigateNextPageEvent.observe(this) {
            if(it) {
                openProductPage()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.navigateNextPageEvent.removeObservers(this)
        viewModel.navigateNextPageEvent.postValue(false)
    }
}