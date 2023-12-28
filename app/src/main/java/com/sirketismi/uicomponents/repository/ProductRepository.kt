package com.sirketismi.uicomponents.repository

import androidx.lifecycle.LiveData
import com.sirketismi.uicomponents.dao.UserDao
import com.sirketismi.uicomponents.model.User
import javax.inject.Inject

interface ProductRepositoryInterface {

}
class ProductRepository @Inject constructor(private val userDao : UserDao) : ProductRepositoryInterface {
    suspend fun insert(user : User) {
        userDao.insert(user)
    }
    fun getAll() : LiveData<List<User>> {
        return userDao.getAll()
    }
}