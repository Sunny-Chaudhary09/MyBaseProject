package com.example.mytest.Fragments

import android.app.Dialog
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.mytest.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_otp.*


class OtpFragment : Fragment(),View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otp, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spanstring()
        addListner()

    }

    private fun addListner() {
        btnContinue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.btnContinue -> {

                val someFragment: Fragment = HomeFragment()
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

    private fun spanstring() {
        val ss = SpannableString("Login")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {

                val someFragment: Fragment = LoginFragment()
                val transaction =
                    fragmentManager!!.beginTransaction()
                transaction.replace(
                    R.id.container,
                    someFragment
                ) // give your fragment container id in first parameter

                transaction.addToBackStack(null) // if written, this transaction will be added to backstack

                transaction.commit()


            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
            }
        }
        ss.setSpan(clickableSpan, 0, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(requireContext(),
                    R.color.black
                )),
            0, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvAcount.append("")
        tvAcount.append(ss)
        tvAcount.movementMethod = LinkMovementMethod.getInstance();
    }
}

