package com.e.farmersdemograph.views.onBoarding.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.e.farmersdata.data.models.LoginDetails

import com.e.farmersdemograph.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    private fun subscribeLoginObserver(email: String, password: String) {

        viewModel.getData.observe(viewLifecycleOwner, Observer {response->
            if (email==response.email && password==response.password){

            }
            else{
                Snackbar.make(login_root, "Invalid Input", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.colorPrimary))
                    .show()

            }


        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewModel.setData.value = getLoginData()
        btn_sign_in.setOnClickListener {
            loginUser()
        }
    }

    private fun getLoginData(): LoginDetails {
        return LoginDetails(
            email = "test@theagromall.com",
            password = "password"
        )

    }

    private fun loginUser() {
        val email = et_email.text.toString()
        val password = et_password.text.toString()

        subscribeLoginObserver(email, password)
    }

}
