package com.example.mytest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytest.R
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment(),View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addListener()

    }

    private fun addListener() {

        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.btnLogin -> {

                val someFragment: Fragment = OtpFragment()
                val transaction =
                    fragmentManager!!.beginTransaction()
                transaction.replace(
                    R.id.container,
                    someFragment
                ) // give your fragment container id in first parameter

                transaction.addToBackStack(null) // if written, this transaction will be added to backstack

                transaction.commit()
            }
        }
    }
}