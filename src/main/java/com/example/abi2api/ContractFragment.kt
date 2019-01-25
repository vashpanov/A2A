package com.example.abi2api

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.R
import android.support.v7.app.AppCompatActivity
import android.view.MenuInflater
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class ContractFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(com.example.abi2api.R.layout.fragment_contract, container, false)

    }

/*
    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_chats, menu)
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.action_chat) {
            Toast.makeText(activity, "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show()
        }
        return true
    }
    */
}
