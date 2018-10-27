package com.uttampanchasara.sharedelementtransition.pageradapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.uttampanchasara.sharedelementtransition.fragments.GridImageFragment
import com.uttampanchasara.sharedelementtransition.fragments.LargeImageFragment
import com.uttampanchasara.sharedelementtransition.fragments.SmallImageFragment

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/27/2018
 */
class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    val titles = arrayOf("Large Image List", "Small Image List", "Grid Image List")

    override fun getItem(position: Int): Fragment {
        lateinit var fragment: Fragment
        when (position) {
            0 -> fragment = LargeImageFragment()
            1 -> fragment = SmallImageFragment()
            2 -> fragment = GridImageFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}