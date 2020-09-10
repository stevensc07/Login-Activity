package com.LoginActivity.Stevensc.Repositorios

import com.LoginActivity.Stevensc.Repositorios.api.ToDosApiService

class ToDotInfo {
    private val apiService = ToDosApiService()

    suspend fun getToDo(index : Int) = apiService.getToDo(index)
}