package com.example.mytest.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytest.Fragments.HomeFragment
import com.example.mytest.R
import com.example.mytest.models.TestModelItem
import kotlinx.android.synthetic.main.itemview_layout.view.*


class MainAdapter(var mContext: HomeFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mTestList= mutableListOf<TestModelItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyListViewHolder(parent.inflate(R.layout.itemview_layout))
    }

    override fun getItemCount(): Int {
        return mTestList.size

    }

    fun updateData(list :List<TestModelItem>){
        mTestList.clear()
        mTestList.addAll(list)
        notifyDataSetChanged()

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyListViewHolder).bindListView(position)
    }

    inner class MyListViewHolder(itemViewL: View) : RecyclerView.ViewHolder(itemViewL) {
        fun bindListView(position: Int) {


            itemView.name.text=mTestList[adapterPosition].name
            itemView.catogary.text=mTestList[adapterPosition].category
            itemView.desc.text = mTestList[adapterPosition].desc
            Glide.with(itemView.context).load(mTestList[adapterPosition].imageUrl).into(itemView.imageview)
     }

        }
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }






