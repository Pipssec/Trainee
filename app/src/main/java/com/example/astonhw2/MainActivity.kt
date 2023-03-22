package com.example.astonhw2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val LOG_TAG = "MainActivity"
    val EXTRA_MESSAGE = "putMainActivity"
    val TEXT_REQUEST = 1
    lateinit var mReplyHeadTextView: TextView
    lateinit var mReplyTextView: TextView
    lateinit var mMessageEditText: EditText
    lateinit var buttonSend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
        buttonSend = findViewById(R.id.button_main)
        buttonSend.setOnClickListener {
            Log.d(LOG_TAG, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            val message = mMessageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, TEXT_REQUEST)

        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra("putSecondActivity")
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply.toString()
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }
}