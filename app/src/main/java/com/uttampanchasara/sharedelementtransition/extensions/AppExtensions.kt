package com.uttampanchasara.sharedelementtransition.extensions

import android.app.Activity
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.widget.Toast

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/23/2018
 */

fun Activity.toast(msg: String, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(this, msg, duration).apply { show() }
}

fun Activity.isNetworkAvailable(): Boolean {
    val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo != null
}