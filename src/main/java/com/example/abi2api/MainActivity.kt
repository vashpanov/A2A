package com.example.abi2api


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.R.attr.colorPrimaryDark
import android.support.v4.content.ContextCompat
import android.os.Build
import android.R.attr.colorPrimary
import android.R.attr.colorAccent
import android.support.design.widget.TabItem
import android.R.attr.colorPrimaryDark
import android.R.attr.colorPrimary
import android.R.attr.colorAccent
import android.R.attr.colorPrimaryDark
import android.R.attr.colorPrimary
import android.R.attr.colorAccent
import android.widget.FrameLayout
import android.R.attr.button
import android.widget.TextView
import android.widget.EditText











const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.abi2api.R.layout.activity_main)

        // Получаем ViewPager и устанавливаем в него адаптер

        //Setting authentication tokens for request - set this code into base activity

        //HashMap<String, String> headerParams = new HashMap<>();
        //headerParams.put("key", "value");
        //ApiService.setHeaders(headerParams);


    }



/*
    override fun <T> onResponse(response: T, tagName: String, responseHeaders: JSONObject) {//responseHeaders is used to catch the network header params like auth key and value
        if (tagName == "GET_ADDRESS") {
            Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onError(error: Any, tagName: String) {
        Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
    }

*/


    fun sendMessage(view: View) {

        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, TokenContract::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }






}






    /*
    @Throws(Exception::class)
    fun doGet(url: String): String {

        val obj = URL(url)
        val connection = obj.openConnection() as HttpURLConnection

        //add reuqest header
        connection.requestMethod = "GET"
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
        connection.setRequestProperty("Content-Type", "application/json")

        val bufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuffer()
        val inputLine = bufferedReader.readLine()
        while ((bufferedReader.readLine()) != null) {
            response.append(inputLine)
        }
        bufferedReader.close()

        //      print result




        return response.toString()
    }
    */


