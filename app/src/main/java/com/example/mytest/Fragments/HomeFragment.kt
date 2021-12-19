package com.example.mytest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mytest.Adapters.MainAdapter
import com.example.mytest.R
import com.example.mytest.Viewmodel.MainViewModel
import com.example.mytest.models.TestModelItem
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val mainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private val mMainAdapter by lazy {
        MainAdapter(this)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainViewModel.mainResponse()
        recyclerview.adapter = mMainAdapter
        mainViewModel.onGetResponse().observe(requireActivity(), Observer {userData->
            mMainAdapter.updateData(userData as List<TestModelItem>)

        })


    }


}