package com.example.a3gradesmartcontent.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3gradesmartcontent.R
import com.example.yourprojectname.ChatAdapter
import com.example.yourprojectname.Message
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GptFragment : Fragment() {

    val generativeModel = GenerativeModel(
        // Use a model that's applicable for your use case (see "Implement basic use cases" below)
        modelName = "gemini-pro",
        // Access your API key as a Build Configuration variable (see "Set up your API key" above)
        apiKey = "AIzaSyBxNHfbEXyf1bMmUvTChToy3yk4uOCr-XQ"
    )

    private val messages = mutableListOf<Message>()
    private var adapter = ChatAdapter(messages)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_chatgpt, container, false)
        val chat_recycler_view = view.findViewById<RecyclerView>(R.id.chat_recycler_view)

        chat_recycler_view.layoutManager = LinearLayoutManager(container!!.context)
        chat_recycler_view.adapter = adapter

        val send_button = view.findViewById<Button>(R.id.send_button)
        send_button.setOnClickListener {
            val user_input_edit_text = view.findViewById<EditText>(R.id.user_input_edit_text)
            val userInput = user_input_edit_text.text.toString()
            user_input_edit_text.setText(null)
            messages.add(Message(userInput,true))
            adapter.notifyDataSetChanged()

            CoroutineScope(Dispatchers.IO).launch {
                val response = generativeModel.generateContent(userInput)
                print(response.text)
                withContext(Dispatchers.Main){
                    //Toast.makeText(container.context,response.text,Toast.LENGTH_LONG).show()
                    messages.add(Message(response.text!!,false))
                    adapter.notifyDataSetChanged()
                }

            }
        }
        return view
    }


}
