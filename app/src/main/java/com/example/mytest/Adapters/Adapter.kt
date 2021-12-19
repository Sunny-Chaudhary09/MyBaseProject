package com.example.mytest.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytest.Data
import com.example.mytest.Activities.MainActivity
import com.example.mytest.R
import kotlinx.android.synthetic.main.item_view.view.*


class Adapter(
    var list: ArrayList<Data>, var context: MainActivity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        Glide.with(context).load(list[position].profile_image)
                .circleCrop().into(holder.itemView.employe_img)
        holder.itemView.employe_id.text = list.get(position).id.toString()
        holder.itemView.employe_name.text = list.get(position).employee_name.toString()
        holder.itemView.employe_age.text = list.get(position).employee_age.toString()
        holder.itemView.employe_salry.text = list.get(position).employee_salary.toString()




        holder.itemView.setOnClickListener(View.OnClickListener {

//            val intent = Intent(context, DetailActivity::class.java)
//
//            intent.putExtra("id", list[position].id)
//            intent.putExtra("name", list[position].employee_name)
//            intent.putExtra("salry", list[position].employee_name)
//            intent.putExtra("age", list[position].employee_age)
//            intent.putExtra("profile", list[position].profile_image)
//            intent.putExtra("position", position)
//            context.startActivityForResult(intent, 2)
        })


    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {



            }
        }
    }




