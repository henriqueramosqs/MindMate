package com.example.mindmate.adapters

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmate.Msg


class MessageAdapter(private val context: Context, private val msg_list:MutableList<Msg>):
RecyclerView.Adapter<MessageAdapter.MessageViewHolder>(){

    inner class MessageViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(com.example.mindmate.R.id.txtView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(com.example.mindmate.R.layout.message_sent, parent, false)

        return MessageViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = msg_list.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = msg_list[position]
        if(item.type==2){
            holder.textView.setBackgroundResource(com.example.mindmate.R.drawable.bg_received_message)

            val params = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            holder.textView.layoutParams = params
        }
        holder.textView.text =  item.txt
    }
}