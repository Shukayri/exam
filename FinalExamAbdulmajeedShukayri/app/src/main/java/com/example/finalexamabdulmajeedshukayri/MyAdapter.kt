package com.example.finalexamabdulmajeedshukayri


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.uni_row.view.*

class MyAdapter(private val Fragment: SearchFragment, private var unis: List<UniversityData> ): RecyclerView.Adapter<MyAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MessageViewHolder {
        return MyAdapter.MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.uni_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.MessageViewHolder, position: Int) {
        val uni = unis[position]

        holder.itemView.apply {
            UniversityNameBtn.text = uni.name
            UniversityNameBtn.setOnClickListener {
                Fragment.saveToLocal(uni)
            }
        }
    }

    override fun getItemCount() = unis.size

}