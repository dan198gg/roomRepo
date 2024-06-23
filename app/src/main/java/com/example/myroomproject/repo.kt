package com.example.myroomproject

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepo(val userDAO: UserDAO) {
        private val COROUTINESCOPE = CoroutineScope(Dispatchers.Main)
        val userList:LiveData<List<User>> = userDAO.getUsers()
    fun addUser(user: User){
        COROUTINESCOPE.launch {
            userDAO.addUser(user)
        }
    }
    fun delUSer(id:Int){
        COROUTINESCOPE.launch {
            userDAO.delUser(id)
        }
    }
}