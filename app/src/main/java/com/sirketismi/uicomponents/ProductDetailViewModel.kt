package com.sirketismi.uicomponents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductDetailViewModel : ViewModel() {
    var productList = mutableListOf<Product>()

    var updateListener = MutableLiveData<Boolean>()

    fun appendProductList(item : Product) {
        SessionHelper.cachedProductList.add(item)
        productList.addAll(SessionHelper.cachedProductList)
        updateListener.postValue(true)
    }
}