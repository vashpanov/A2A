package com.abi2api


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.EditText





const val EXTRA_MESSAGE = "com.example.abi2api.MESSAGE"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.abi2api.R.layout.activity_main)

    }



    fun sendMessage(view: View) {

        val editText = findViewById<EditText>(com.abi2api.R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, TokenContract::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }






}

