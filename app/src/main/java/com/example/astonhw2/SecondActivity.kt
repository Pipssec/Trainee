package com.example.astonhw2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    val EXTRA_REPLY = "putSecondActivity"
    lateinit var editTextReply: EditText
    lateinit var buttonReply: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        buttonReply = findViewById(R.id.button_second)
        val intent = intent
        val message = intent.getStringExtra("putMainActivity")
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message.toString()
        buttonReply.setOnClickListener {
            editTextReply = findViewById(R.id.editText_second)
            val reply = editTextReply.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)
            finish()
        }
    }
}