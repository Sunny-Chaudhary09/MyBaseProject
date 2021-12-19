package com.example.mytest.Fragments

import android.app.Dialog
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.mytest.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(),View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spanablestring()
        addListner()
    }

    private fun addListner() {
        tvForgetPassword.setOnClickListener(this)
    }

    private fun spanablestring() {
        val ss = SpannableString("Sign In")
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {

                val someFragment: Fragment = SignupFragment()
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
            ForegroundColorSpan(ContextCompat.getColor(requireContext(),
                R.color.black
            )),
            0, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvSignin.append("")
        tvSignin.append(ss)
        tvSignin.movementMethod = LinkMovementMethod.getInstance();
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.tvForgetPassword -> {

                val dialog = Dialog(requireContext())
                dialog.setContentView(R.layout.dialog_forgetpassword)

                val width = WindowManager.LayoutParams.MATCH_PARENT
                //intialize height of dialog
                //intialize height of dialog
                val height = WindowManager.LayoutParams.WRAP_CONTENT
                dialog.getWindow()?.setLayout(width, height)
                dialog.show()

                val editText = dialog.findViewById(R.id.dailog_text) as EditText
                val button: Button = dialog.findViewById(R.id.btn_update) as Button

                button.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()

                })
            }

        }
    }

}