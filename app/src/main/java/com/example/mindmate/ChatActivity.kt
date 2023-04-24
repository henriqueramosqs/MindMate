package com.example.mindmate

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmate.adapters.MessageAdapter

class ChatActivity : AppCompatActivity() {

    private val messages = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private  lateinit var messageListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        messageListView = findViewById<RecyclerView>(R.id.messageListView)
        val sendButton:Button = findViewById<Button>(R.id.sendButton)

        messages.add("adasdadasdasdafsadfsdf")
        messages.add("asdaspkjkfljksdfksdljf")
        // Set up the ArrayAdapter for the ListView
        messageListView.adapter = MessageAdapter(this,messages)

        // Set up the click listener for the Send button
        sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        // Get the user's message from the EditText

        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val message = messageEditText.text.toString().trim()

        if (message.isNotEmpty()) {
            messages.add(message)
            messageListView?.adapter?.notifyDataSetChanged()
            messageEditText.text.clear()
        }
    }
}
