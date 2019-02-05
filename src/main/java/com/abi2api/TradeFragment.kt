package com.abi2api


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*


class TradeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)

        return inflater.inflate(com.abi2api.R.layout.fragment_trade, container, false)
    }




/*
    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_status, menu)
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.action_status) {
            Toast.makeText(activity, "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show()
        }
        return true
    }*/
}
