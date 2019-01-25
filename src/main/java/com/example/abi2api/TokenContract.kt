package com.example.abi2api

import android.content.Intent
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import android.R
import android.R.attr.key
import android.R.attr.fragment
import android.R.attr.key








class TokenContract : AppCompatActivity() {

    internal var toolbar: Toolbar? =null
    internal var tabLayout: TabLayout? =null
    internal var viewPager: ViewPager? =null
    internal var pageAdapter: PageAdapter? =null
    internal var tabContract: TabItem? =null
    internal var tabTrade: TabItem? =null
    internal var tabGeneral: TabItem? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.abi2api.R.layout.activity_token_contract)

        toolbar = findViewById(com.example.abi2api.R.id.toolbar)
        toolbar?.title = resources.getString(com.example.abi2api.R.string.app_name)
        setSupportActionBar(toolbar)

        tabLayout = findViewById(com.example.abi2api.R.id.tablayout)
        tabContract = findViewById(com.example.abi2api.R.id.tabContract)
        tabTrade = findViewById(com.example.abi2api.R.id.tabTrade)
        tabGeneral = findViewById(com.example.abi2api.R.id.tabGeneral)
        viewPager = findViewById(com.example.abi2api.R.id.viewPager)

        pageAdapter = PageAdapter(supportFragmentManager, 3)
        viewPager?.adapter = pageAdapter


        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager?.currentItem = tab.position
                if (tab.position ==0) {
                    toolbar?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.example.abi2api.R.color.colorAccent))
                    tabLayout?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.example.abi2api.R.color.colorAccent))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                com.example.abi2api.R.color.colorAccent)
                    }
                } else if (tab.position == 1) {
                    toolbar?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            android.R.color.darker_gray))
                    tabLayout?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            android.R.color.darker_gray))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                android.R.color.darker_gray)
                    }
                } else if(tab.position == 2){
                    toolbar?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.example.abi2api.R.color.colorPrimary))
                    tabLayout?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.example.abi2api.R.color.colorPrimary))
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                com.example.abi2api.R.color.colorPrimaryDark)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        val message = intent.getStringExtra(EXTRA_MESSAGE)


        val textView = findViewById<TextView>(com.example.abi2api.R.id.editText2).apply {
            text = message
        }


    }


    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(com.example.abi2api.R.id.editText2)
        val message = editText.text.toString()
        val intent = Intent(this, TokenContract::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }

        startActivity(intent)
        sendRequest()

    }
    private fun sendRequest() { // tag is used to identify the API requests - when multiple requests are used.

        val editText = findViewById<EditText>(com.example.abi2api.R.id.editText2)
        val message = editText.text.toString()

        val textView = findViewById<TextView>(com.example.abi2api.R.id.textView5)
        val queue = Volley.newRequestQueue(this)
        val url = "https://abi2api.jury.online/api/v1/contract/read?address="+message

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    textView.text = "%s".format(response.toString())
                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                })
        queue.add(jsonObjectRequest)
    }



}


