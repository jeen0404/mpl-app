package com.windrg.mpl.PagerAdapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.windrg.mpl.MainActivityHomeFragment
import com.windrg.mpl.MainActivityLiveFragment
import com.windrg.mpl.MainActivityPreviousFragment

class MainActiviyTabPagerAdapter(fm: FragmentManager, private var tabCount: Int) :
        FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return MainActivityHomeFragment()
            1 -> return MainActivityLiveFragment()
            2 -> return MainActivityPreviousFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Home"
            1 -> return "Live"
            2 -> return "Previous"
            else -> return null
        }
    }
}