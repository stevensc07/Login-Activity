package com.LoginActivity.Stevensc.viewmodel

import androidx.lifecycle.ViewModel
import com.LoginActivity.Stevensc.Repositorios.LoginInfo

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginInfo
    fun getLogged() = LoginInfo.getLogged()
    fun setLogged(state: Boolean){
        LoginInfo.setLogged(state)
    }
}