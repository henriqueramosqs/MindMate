package com.example.mindmate.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmate.R

class MessageAdapter(private val context: Context, private val msg_list:MutableList<String>):
RecyclerView.Adapter<MessageAdapter.MessageViewHolder>(){

    inner class MessageViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.txtView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_sent, parent, false)

        return MessageViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = msg_list.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = msg_list[position]
        holder.textView.text =  item
    }
}