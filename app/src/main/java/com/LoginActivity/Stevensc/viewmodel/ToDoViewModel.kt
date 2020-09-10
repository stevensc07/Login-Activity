package com.LoginActivity.Stevensc.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.LoginActivity.Stevensc.Repositorios.ToDotInfo
import com.LoginActivity.Stevensc.Repositorios.api.DataAPi.ToDo
import kotlinx.coroutines.launch

class ToDoViewModel: ViewModel() {

    private val repository = ToDotInfo()
    val todos = mutableListOf<ToDo>()
    val postsLiveData = MutableLiveData<List<ToDo>>()

    init {
        getToDo()
    }

    fun getToDo() {
        viewModelScope.launch {
            println("si entra x2")
            val post = repository.getToDo(todos.size+1)

            todos.add(post)

            postsLiveData.postValue(todos)

        }
    }

}