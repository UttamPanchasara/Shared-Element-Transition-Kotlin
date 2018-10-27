package com.uttampanchasara.sharedelementtransition.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.uttampanchasara.sharedelementtransition.R
import com.uttampanchasara.sharedelementtransition.activity.LargeImageDetailActivity
import com.uttampanchasara.sharedelementtransition.activity.MainActivity
import com.uttampanchasara.sharedelementtransition.adapters.GridImageItemClickListener
import com.uttampanchasara.sharedelementtransition.adapters.GridImageListAdapter
import com.uttampanchasara.sharedelementtransition.models.Item
import kotlinx.android.synthetic.main.fragment_grid_images.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/27/2018
 */
class GridImageFragment : Fragment(), GridImageItemClickListener {

    /**
     * add views to shared elements
     */
    override fun onItemClick(item: Item, imageView: ImageView, textView: TextView) {
        val detailIntent = Intent(mActivity, LargeImageDetailActivity::class.java)
        val imageViewPair = Pair.create<View, String>(imageView, getString(R.string.image_transition_name))
        val textViewPair = Pair.create<View, String>(textView, getString(R.string.text_transition_name))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageViewPair, textViewPair)
        detailIntent.putExtra(LargeImageDetailActivity.DATA, item)
        startActivity(detailIntent, options.toBundle())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_grid_images, container, false)
        return view
    }

    lateinit var mAdapter: GridImageListAdapter
    //activity instance
    lateinit var mActivity: AppCompatActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as MainActivity

        mAdapter = GridImageListAdapter(mActivity, this)
        rvGridImageItems.layoutManager = GridLayoutManager(mActivity, 2)
        rvGridImageItems.adapter = mAdapter

        mAdapter.setItems(Item.ITEMS.toList())
    }
}