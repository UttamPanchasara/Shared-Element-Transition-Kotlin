package com.uttampanchasara.sharedelementtransition.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.uttampanchasara.sharedelementtransition.R
import com.uttampanchasara.sharedelementtransition.extensions.isNetworkAvailable
import com.uttampanchasara.sharedelementtransition.extensions.toast
import com.uttampanchasara.sharedelementtransition.pageradapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        if (!isNetworkAvailable()) {
            toast(getString(R.string.connection_error), Toast.LENGTH_SHORT)
        }
    }
}