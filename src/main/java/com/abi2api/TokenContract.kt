package com.abi2api

import android.content.Intent
import android.os.Build;
import android.os.Bundle;
import android.os.Handler
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;

import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import android.support.v4.view.ViewPager
import android.text.Html



class TokenContract : AppCompatActivity() {


    internal var tabLayout: TabLayout? =null
    internal var viewPager: ViewPager? =null
    internal var pageAdapter: PageAdapter? =null
    internal var tabContract: TabItem? =null
    internal var tabTrade: TabItem? =null
    internal var tabGeneral: TabItem? =null
    var iter1 = 0
    var iter2 = 0
    var iter3 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.abi2api.R.layout.activity_token_contract)


        tabLayout = findViewById(com.abi2api.R.id.tablayout)
        tabContract = findViewById(com.abi2api.R.id.tabContract)
        tabTrade = findViewById(com.abi2api.R.id.tabTrade)
        tabGeneral = findViewById(com.abi2api.R.id.tabGeneral)
        viewPager = findViewById(com.abi2api.R.id.viewPager)
        pageAdapter = PageAdapter(supportFragmentManager, 3)
        viewPager?.adapter = pageAdapter
        selectPage(1)



        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                viewPager?.currentItem = tab.position

                if (tab.position ==0) {

                    tabTrade?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.abi2api.R.color.colorPrimary))
                    iter3=0
                    if (iter1==0) {sendRequestTrade()}
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                com.abi2api.R.color.colorPrimary)
                    }

                } else if (tab.position == 1) {
                    tabContract?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.abi2api.R.color.colorPrimary))
                    if (iter2==0) {sendRequest()}
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                com.abi2api.R.color.colorPrimary)
                    }
                } else if(tab.position == 2){

                    tabGeneral?.setBackgroundColor(ContextCompat.getColor(this@TokenContract,
                            com.abi2api.R.color.colorPrimary))
                    iter1=0
                    if (iter3==0) {sendRequestGeneral()}
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = ContextCompat.getColor(this@TokenContract,
                                com.abi2api.R.color.colorPrimary)
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


        val textView = findViewById<TextView>(com.abi2api.R.id.editText2).apply {
            text = message
        }




    }
    fun selectPage(pageIndex: Int) {
        Handler().postDelayed({
            tabLayout?.setScrollPosition(pageIndex, 0f, true)
            viewPager?.setCurrentItem(pageIndex)

        }, 10)


    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(com.abi2api.R.id.editText2)

        val message = editText.text.toString()
        val intent = Intent(this, TokenContract::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
        sendRequest()

    }
    private fun sendRequest() {

        val editText = findViewById<EditText>(com.abi2api.R.id.editText2)
        val message = editText.text.toString()

        val textView = findViewById<TextView>(com.abi2api.R.id.textView5)

        val queue = Volley.newRequestQueue(this)
        val url = "https://abi2api.jury.online/api/v1/contract/read?address="+message



        val jsonArrayRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    val Jsonobj = response.getJSONArray("result").getJSONObject(0).toString()
                    val pairs = Jsonobj.split(",")
                    var str = ""
                    for ((index, element) in pairs.withIndex()) {

                        str += "<b>"+(pairs[index].split(":")[0].replace("\"", ""))+"</b>" + "<br>" + (pairs[index].split(":")[1].replace("\"", "")) + "<br>" + "<br>"
                    }


                    if(str == "") textView.text = "Empty contract" else textView.text = Html.fromHtml(str)

                },
                Response.ErrorListener { error ->
                    textView.text = "Bad request"
                })
        iter2 = 1
        queue.add(jsonArrayRequest)



    }
    private fun sendRequestTrade() {

        val editText = findViewById<EditText>(com.abi2api.R.id.editText2)
        val message = editText.text.toString()
        var str = ""
        var name =""
        var symbol=""
        var diff =""
        var diff7d =""
        var diff30d =""
        var price =""
        var marketCapUsd =""

        var from =""
        var to = ""
        var value = ""
       // val tab = findViewById<android.support.design.widget.TabItem>(com.example.abi2api.R.id.tabTrade)

        val textView = findViewById<TextView>(com.abi2api.R.id.textView6)

        val queue = Volley.newRequestQueue(this)
        var url = "http://api.ethplorer.io/getAddressInfo/"+message+"?apiKey=freekey"



        val jsonArrayRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    if (response.has("tokenInfo")) {
                        val Jsonobj = response.getJSONObject("tokenInfo").toString()

                        val pairs = Jsonobj.split(",")

                        for ((index, element) in pairs.withIndex()) {
                            if ((pairs[index].split(":")[0]) == "\"name\"") {
                                name = (pairs[index].split(":")[1].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"symbol\"") {
                                symbol = (pairs[index].split(":")[1].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"price\"") {
                                price = (pairs[index].split(":")[2].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"diff\"") {
                                diff = (pairs[index].split(":")[1].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"diff7d\"") {
                                diff7d = (pairs[index].split(":")[1].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"diff30d\"") {
                                diff30d = (pairs[index].split(":")[1].replace("\"", ""))
                            }
                            if ((pairs[index].split(":")[0]) == "\"marketCapUsd\"") {
                                marketCapUsd = (pairs[index].split(":")[1].replace("\"", ""))
                            }

                        }
                        str += "<b>" + "name" + "</b>" + "<br>" + name + "<br>" + "<br>"
                        str += "<b>" + "symbol" + "</b>" + "<br>" + symbol + "<br>" + "<br>"
                        str += "<b>" + "price" + "</b>" + "<br>" + price + "<br>" + "<br>"
                        str += "<b>" + "change(24h)" + "</b>" + "<br>" + diff + "%" + "<br>" + "<br>"
                        str += "<b>" + "change(7d)" + "</b>" + "<br>" + diff7d + "%" + "<br>" + "<br>"
                        str += "<b>" + "change(30d)" + "</b>" + "<br>" + diff30d + "%" + "<br>" + "<br>"
                        str += "<b>" + "marketCap" + "</b>" + "<br>" + marketCapUsd + " usd" + "<br>" + "<br>"


                        if (str == "") textView.text = "Empty contract" else textView.text = Html.fromHtml(str)
                    }
                    else {
                        url = "https://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&59T694B8WWC8KSZQSA4D4PYRIRR9SSII5Y"
                        val jsonArrayRequest = JsonObjectRequest(Request.Method.GET, url, null,
                                Response.Listener { response ->
                                    str += "<b>" + "The last 10 transactions" +"</b>"+ "<br>"+ "<br>"
                                    for(index in 0..9) {
                                        val Jsonobj = response.getJSONArray("result").getJSONObject(index)
                                        from = Jsonobj.getString("from")
                                        to = Jsonobj.getString("to")
                                        value = (Jsonobj.getString("value").substring(0,Jsonobj.getString("value").length - 6).toLong()/1000000000000.0).toString() + " eth"
                                        str += "<b>" + "from: " + "</b>" + from + "<br>" +  "<b>" + "to: " + "</b>" + to + "<br>" + "<b>" + "value: " + "</b>" + value + "<br>" + "<br>"
                                    }
                                    textView.text = Html.fromHtml(str)
                                },



                                    Response.ErrorListener { error ->
                                    textView.text = "Bad request"
                                })
                        queue.add(jsonArrayRequest)

                    }
                },
                Response.ErrorListener { error ->
                    textView.text = "Bad request"
                })
        iter1 = 1
        queue.add(jsonArrayRequest)


    }
    private fun sendRequestGeneral() {

        val editText = findViewById<EditText>(com.abi2api.R.id.editText2)
        val message = editText.text.toString()
        var str = ""
        var name =""
        var symbol=""
        var description =""
        var diff7d =""
        var diff30d =""
        var price =""
        var marketCapUsd =""
        val textView = findViewById<TextView>(com.abi2api.R.id.textView7)

        val queue = Volley.newRequestQueue(this)
        val url = "http://api.ethplorer.io/getAddressTransactions/" + message + "?apiKey=freekey"



        /*val jsonArrayRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->

                    val Jsonobj = response.getJSONObject("tokenInfo").toString()
/*
                    val pairs = Jsonobj.split(",")

                    for ((index, element) in pairs.withIndex()) {
                        if ((pairs[index].split(":")[0])=="\"name\"" ){name =(pairs[index].split(":")[1].replace("\"", ""))     }
                        if ((pairs[index].split(":")[0])=="\"symbol\"" ){symbol =(pairs[index].split(":")[1].replace("\"", "")) }
                        if ((pairs[index].split(":")[0])=="\"description\""){price =(pairs[index].split(":")[2].replace("\"", ""))    }

                        if ((pairs[index].split(":")[0])=="\"diff7d\"" ){diff7d =(pairs[index].split(":")[1].replace("\"", "")) }
                        if ((pairs[index].split(":")[0])=="\"diff30d\"" ){diff30d =(pairs[index].split(":")[1].replace("\"", ""))}
                        if ((pairs[index].split(":")[0])=="\"marketCapUsd\"" ){marketCapUsd =(pairs[index].split(":")[1].replace("\"", ""))  }

                    }
                    str += "<b>"+"name"+"</b>"+"<br>"+name+"<br>"+"<br>"
                    str += "<b>"+"symbol"+"</b>"+"<br>"+symbol+"<br>"+"<br>"
                    str += "<b>"+"price"+"</b>"+"<br>"+price+"<br>"+"<br>"

                    str += "<b>"+"change(7d)"+"</b>"+"<br>"+diff7d+"%"+"<br>"+"<br>"
                    str += "<b>"+"change(30d)"+"</b>"+"<br>"+diff30d+"%"+"<br>"+"<br>"
                    str += "<b>"+"marketCap"+"</b>"+"<br>"+marketCapUsd+" usd"+"<br>"+"<br>"


                    if(str == "") textView.text = "Empty contract" else textView.text = Html.fromHtml(Jsonobj)}
*/
                        textView.text = Jsonobj

                },
                Response.ErrorListener { error ->
                    textView.text = "Bad request"
                })
        iter3 = 1
        queue.add(jsonArrayRequest)
*/

    }


}

