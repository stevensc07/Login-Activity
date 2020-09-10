package com.LoginActivity.Stevensc.viewmodel

import androidx.lifecycle.ViewModel
import com.LoginActivity.Stevensc.Data.User
import com.LoginActivity.Stevensc.Repositorios.UsersInfo

class UsersInfoViewModel : ViewModel(){
    private val myRepository = UsersInfo
    fun getUsers() = UsersInfo.getUsers()
    fun addUser(user: User) =
        UsersInfo.addUser(user)
}