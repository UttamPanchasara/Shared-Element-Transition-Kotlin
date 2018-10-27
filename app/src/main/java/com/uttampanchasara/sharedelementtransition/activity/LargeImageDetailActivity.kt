package com.uttampanchasara.sharedelementtransition.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Transition
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.uttampanchasara.sharedelementtransition.R
import com.uttampanchasara.sharedelementtransition.models.Item
import kotlinx.android.synthetic.main.activity_large_image_detail.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/26/2018
 */
class LargeImageDetailActivity : AppCompatActivity() {
    companion object {
        val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_image_detail)
        setSupportActionBar(toolbar)

        val item = intent.extras.get(DATA) as Item

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        txtName.text = item.name
        Picasso.get().load(item.thumbnailUrl).noFade().into(ivDetail)

        //add transition listener to load full-size image on transition end
        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition?) {
                //load full-size
                Picasso.get().load(item.photoUrl).noFade().noPlaceholder().into(ivDetail)
                transition?.removeListener(this)
            }

            override fun onTransitionResume(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionPause(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionCancel(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionStart(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            //to reverse the scene transition animation
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }
}