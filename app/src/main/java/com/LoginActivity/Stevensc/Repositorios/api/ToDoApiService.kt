package com.LoginActivity.Stevensc.Repositorios.api
import com.LoginActivity.Stevensc.Repositorios.api.DataAPi.ToDo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ToDosApiService {

    private val ToDoApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ToDosApi::class.java)


    suspend fun getToDo(index : Int): ToDo {
        println("si entra x3")
        return ToDoApi.getToDo(index)
    }


}