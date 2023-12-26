package com.sirketismi.uicomponents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {
    var nameText = MutableLiveData<String>()
    var navigateNextPageEvent = MutableLiveData<Boolean>()

    fun onButtonClick() {
        navigateNextPageEvent.postValue(true)
    }
}