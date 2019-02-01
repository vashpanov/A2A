package com.example.abi2api


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View


import android.widget.EditText
import android.support.design.widget.Snackbar
import org.json.JSONException

import org.json.JSONObject
import org.json.JSONArray
import android.R
import android.widget.TextView
import android.support.design.widget.CoordinatorLayout
import android.app.Activity





const val EXTRA_MESSAGE = "com.example.abi2api.MESSAGE"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.abi2api.R.layout.activity_main)

    }



    fun sendMessage(view: View) {

        val editText = findViewById<EditText>(com.example.abi2api.R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, TokenContract::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }






}

