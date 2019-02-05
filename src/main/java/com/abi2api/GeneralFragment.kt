package com.abi2api


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class GeneralFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)

        return inflater.inflate(com.abi2api.R.layout.fragment_general, container, false)
    }

/*
    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_calls, menu)
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.action_call) {
            Toast.makeText(activity, "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show()
        }
        return true
    }
    */
}
