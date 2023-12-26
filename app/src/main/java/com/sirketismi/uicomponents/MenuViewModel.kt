package com.sirketismi.uicomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sirketismi.uicomponents.model.User
import com.sirketismi.uicomponents.repository.UserRepository
import kotlinx.coroutines.launch

class MenuViewModel() : ViewModel() {
    lateinit  var userRepository: UserRepository
    var nameText = MutableLiveData<String>()
    var navigateNextPageEvent = MutableLiveData<Boolean>()

    fun onButtonClick() {
        navigateNextPageEvent.postValue(true)
    }

    fun getAllData(): LiveData<List<User>> {
        return userRepository.getAll()
    }
    fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}