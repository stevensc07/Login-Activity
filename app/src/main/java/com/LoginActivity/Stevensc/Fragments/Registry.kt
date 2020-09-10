package com.LoginActivity.Stevensc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.LoginActivity.Stevensc.Data.User
import com.LoginActivity.Stevensc.R
import com.LoginActivity.Stevensc.viewmodel.UsersInfoViewModel
import kotlinx.android.synthetic.main.fragment_registro.*

class Registry : Fragment(){
    lateinit var navController: NavController
    val myViewModel : UsersInfoViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button2).setOnClickListener(){
            if (editTextTextPassword.text.toString().equals(editTextTextPassword2.text.toString()) && editTextTextEmailAddress.text.toString()!=""){
                myViewModel.addUser(User(editTextTextEmailAddress.text.toString(),editTextTextPassword.text.toString()))
                editTextTextPassword.setText("")
                editTextTextPassword2.setText("")
                editTextTextEmailAddress.setText("")
                navController!!.navigate(R.id.action_registroFragment_to_login)

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Registry().apply {
            }
    }
}