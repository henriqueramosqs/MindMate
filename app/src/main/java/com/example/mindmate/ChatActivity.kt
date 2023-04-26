package com.example.mindmate

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmate.adapters.MessageAdapter
import com.google.gson.JsonObject
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatActivity : AppCompatActivity() {

    private val messages = mutableListOf<Msg>()
    private lateinit var adapter: ArrayAdapter<String>
    private  lateinit var messageListView: RecyclerView
    private val TAG = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        messageListView = findViewById<RecyclerView>(R.id.messageListView)
        val sendButton:Button = findViewById<Button>(R.id.sendButton)

        messages.add(Msg("adasdadasdasdafsadfsdf",1))
        messages.add(Msg("asdaspkjkfljksdfksdljf",2))
        // Set up the ArrayAdapter for the ListView
        messageListView.adapter = MessageAdapter(this,messages)

        // Set up the click listener for the Send button
        sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val message = messageEditText.text.toString().trim()

        if (message.isNotEmpty()) {
            messages.add(Msg(message,1))
            messageListView?.adapter?.notifyDataSetChanged()
            messageEditText.text.clear()
        }

        val baseUrl = "http://127.0.0.1:8000/"
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build().create(APIInterface::class.java)


        val jsonObject = JsonObject().apply {
            addProperty("msg", message)
        }

        Log.v(TAG,jsonObject.toString())

        val retrofitData = retrofitBuilder.getData(jsonObject)
        val altData = retrofitBuilder.gtt()

        Log.v(TAG,retrofitData.toString())

        retrofitData.enqueue(object : Callback<List<BotResponseItem>?>{
            override fun onResponse(
                call: Call<List<BotResponseItem>?>,
                response: Response<List<BotResponseItem>?>
            ) {
                Log.e(TAG,"THE API CALL")
                val responseBody = response.body()!!
                Log.d(TAG,responseBody[0].res)

                val stringBuilder= StringBuilder()
                messages.add(Msg(responseBody[0].res,2))

                messageListView?.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<BotResponseItem>?>, t: Throwable) {
                Log.e(TAG,"API call failled")
            }
        })

        altData.enqueue(object :Callback<List<BotResponseItem>?>{
            override fun onResponse(
                call: Call<List<BotResponseItem>?>,
                response: Response<List<BotResponseItem>?>
            ) {
                val responseBody = response.body()!!
                Log.d(TAG,responseBody[0].res)

            }

            override fun onFailure(call: Call<List<BotResponseItem>?>, t: Throwable) {
                Log.v("Try","It failled")
            }
        })


        val testURL = "https://jsonplaceholder.typicode.com/"
        val retrofitBuilder_test = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(testURL)
            .build().create(API_interface2::class.java)

        val retrofitDataTest = retrofitBuilder_test.get_test()

        retrofitDataTest.enqueue(object: Callback<List<testingItem>?>{
            override fun onResponse(
                call: Call<List<testingItem>?>,
                response: Response<List<testingItem>?>
            ) {
                val responseBody = response.body()!!

                val stringBuilder= StringBuilder()
                stringBuilder.append(responseBody[0].id)

                messages.add(Msg(stringBuilder.toString(),2))
                messageListView?.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<testingItem>?>, t: Throwable) {
                Log.e("Testing_2","Failed")
            }

        })


    }

}

