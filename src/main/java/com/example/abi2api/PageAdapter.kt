package com.example.abi2api

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.R
import android.support.annotation.NonNull
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class PageAdapter internal constructor(fm: FragmentManager, private val numOfTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return TradeFragment()
            1 -> return ContractFragment()
            2 -> return GeneralFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}