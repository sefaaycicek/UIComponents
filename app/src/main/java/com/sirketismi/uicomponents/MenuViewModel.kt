package com.sirketismi.uicomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sirketismi.uicomponents.model.User
import com.sirketismi.uicomponents.repository.ProductRepository
import com.sirketismi.uicomponents.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor (var userRepository: UserRepository,
                                         var productRepository: ProductRepository) : ViewModel() {
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

/*
class MenuViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            return MenuViewModel(repository) as T
        }

        throw IllegalArgumentException("unknown viewmodel class")
    }
}*/