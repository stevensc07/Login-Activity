package com.LoginActivity.Stevensc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.LoginActivity.Stevensc.Data.User
import com.LoginActivity.Stevensc.R
import com.LoginActivity.Stevensc.viewmodel.LoginViewModel
import com.LoginActivity.Stevensc.viewmodel.UsersInfoViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class Login : Fragment() {
    private var userList = mutableListOf<User>()
    lateinit var navController: NavController
    val loginViewModel: LoginViewModel by activityViewModels()
    val myViewModel : UsersInfoViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        loginViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == true){
                navController.navigate(R.id.loggedFragment)
            }
        })
        view.findViewById<Button>(R.id.button).setOnClickListener(){
            myViewModel.getUsers().observe(viewLifecycleOwner, Observer { users->
                run {
                    val some= ""+users.size
                    userList = users as MutableList<User>
                    users.forEach{ user ->
                        //verificar que el usuario exista
                        if (user.correo.equals(editTextTextEmailAddress.text.toString())){
                            if (user.contraseña.equals(editTextTextPassword.text.toString())){
                                //usuario registrado inicio de sesion
                                loginViewModel.setLogged(true)
                            }
                        }
                    }
                }
            })

        }
        view.findViewById<Button>(R.id.button2).setOnClickListener(){
            navController!!.navigate(R.id.action_login_to_registroFragment)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {

            }
    }


}