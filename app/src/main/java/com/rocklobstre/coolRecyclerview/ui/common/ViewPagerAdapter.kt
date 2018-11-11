package com.rocklobstre.coolRecyclerview.ui.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private var fragmentList: ArrayList<Fragment> = ArrayList()

    private var fragmentTitleList: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

}