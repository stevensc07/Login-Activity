package com.LoginActivity.Stevensc.Fragments

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.LoginActivity.Stevensc.R
import com.LoginActivity.Stevensc.Repositorios.api.DataAPi.ToDo
import kotlinx.android.synthetic.main.list_item_todo.view.*

class ToDosAdapter(val toDos: ArrayList<ToDo> ): RecyclerView.Adapter<ToDosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return toDos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(toDos[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(toDo: ToDo) {
            itemView.title.text = toDo.title
            println(toDo.title)
            if (toDo.completed){
                itemView.CartaColor.setBackgroundColor(Color.parseColor("#1b4f8f"))
            }else{
                 itemView.CartaColor.setBackgroundColor(Color.parseColor("#faed27"))

            }

        }
    }
}


