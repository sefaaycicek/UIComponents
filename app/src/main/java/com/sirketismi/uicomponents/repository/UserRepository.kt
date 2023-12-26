package com.sirketismi.uicomponents.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.sirketismi.uicomponents.dao.UserDao
import com.sirketismi.uicomponents.model.User

class UserRepository(private val userDao : UserDao) {
    suspend fun insert(user : User) {
        userDao.insert(user)
    }
    fun getAll() : LiveData<List<User>> {
        return userDao.getAll()
    }
}