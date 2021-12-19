package com.example.mytest

import android.annotation.SuppressLint
import android.content.Context



import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.example.mytest.Activities.MainActivity2

import kotlinx.android.synthetic.main.item_employee.view.*


class MyAdapter(context: Context, list: ArrayList<Model>) :

    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var context: Context
    var list: ArrayList<Model>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_employee, parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, @SuppressLint("RecyclerView") position: Int) {


        val model = list[position]

        holder.itemView.textView.text=(model.getText().toString())
        holder.itemView.checkbox.isChecked = model.isSelected

        holder.itemView.checkbox.setOnClickListener(View.OnClickListener {
            val checkBoxStatus = !model.isSelected
            list[position].isSelected = checkBoxStatus
            MainActivity2.recyclerViewList.get(position).setSelected(checkBoxStatus)
            var selectedText = ""
            for (i in MainActivity2.originalList.indices) {
                val model1: Model = MainActivity2.originalList.get(i)
                if (model1.getText().equals(model.getText())) {
                    MainActivity2.originalList.get(i).setSelected(checkBoxStatus)
                }
                if (model1.isSelected) {
                    selectedText += model1.getText().toString() + ", "
                }
            }
//            MainActivity2.textView.text=model.setSelected(true)
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    init {
        this.context = context
        this.list = list
    }


}