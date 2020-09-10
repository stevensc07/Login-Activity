package com.LoginActivity.Stevensc.Repositorios.api

import com.LoginActivity.Stevensc.Repositorios.api.DataAPi.ToDo
import retrofit2.http.*

interface ToDosApi {

    @GET("todos/{index}/")
    suspend fun getToDo(@Path("index") index: Int): ToDo

}
