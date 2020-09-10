package com.LoginActivity.Stevensc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.LoginActivity.Stevensc.R
import com.LoginActivity.Stevensc.Repositorios.api.DataAPi.ToDo
import com.LoginActivity.Stevensc.viewmodel.LoginViewModel
import com.LoginActivity.Stevensc.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_logged.view.*

class Logged : Fragment() {
    val loginViewModel: LoginViewModel by activityViewModels()
    val toDoViewModel: ToDoViewModel by activityViewModels()
    private val adapter = ToDosAdapter(ArrayList())
    lateinit var toDos : List<ToDo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logged, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        requireView().posts_recycler.adapter = adapter
        requireView().posts_recycler.layoutManager = LinearLayoutManager(requireContext())

        toDoViewModel.postsLiveData.observe(getViewLifecycleOwner(), Observer {
            adapter.toDos.clear()
            adapter.toDos.addAll(it)
            adapter.notifyDataSetChanged()
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            println("si entra")
            toDoViewModel.getToDo()
        }

        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == false) {
                navController.navigate(R.id.login)
            }
        })
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            loginViewModel.setLogged(false)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Logged().apply {
            }
    }

}