package com.sirketismi.uicomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.sirketismi.uicomponents.databinding.FragmentProductDetailBinding

class ProductDetail : Fragment() {

    lateinit var binding : FragmentProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater)
        binding.btn.setOnClickListener {
            val bundle = bundleOf("prm1" to 10, "prm2" to "Sefa", "prm3" to 10.2)

            setFragmentResult(resultKey, bundle)
            findNavController().popBackStack()
        }
        return binding.root
    }

    companion object {
        val resultKey = "RESULT"
    }
}