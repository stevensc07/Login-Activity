package com.LoginActivity.Stevensc.Repositorios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.LoginActivity.Stevensc.util.PreferenceProvider

object LoginInfo {
    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    init {
        stateLogged = PreferenceProvider.getValue()!!
        logged.value =
            stateLogged;
    }

    fun getLogged() = logged as LiveData<Boolean>

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value =
            stateLogged;
        PreferenceProvider.setValue(state)
    }
}