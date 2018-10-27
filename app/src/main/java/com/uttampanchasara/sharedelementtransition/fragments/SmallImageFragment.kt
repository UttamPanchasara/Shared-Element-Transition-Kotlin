package com.uttampanchasara.sharedelementtransition.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.uttampanchasara.sharedelementtransition.R
import com.uttampanchasara.sharedelementtransition.activity.LargeImageDetailActivity
import com.uttampanchasara.sharedelementtransition.activity.MainActivity
import com.uttampanchasara.sharedelementtransition.activity.SmallImageDetailActivity
import com.uttampanchasara.sharedelementtransition.adapters.SmallImageItemClickListener
import com.uttampanchasara.sharedelementtransition.adapters.SmallImageListAdapter
import com.uttampanchasara.sharedelementtransition.models.Item
import kotlinx.android.synthetic.main.fragment_small_image_list.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/27/2018
 */
class SmallImageFragment : Fragment(), SmallImageItemClickListener {

    /**
     * add views to shared elements
     */
    override fun onItemClick(item: Item, imageView: ImageView) {
        val detailIntent = Intent(mActivity, SmallImageDetailActivity::class.java)
        val imageViewPair = Pair.create<View, String>(imageView, getString(R.string.image_transition_name))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageViewPair)
        detailIntent.putExtra(LargeImageDetailActivity.DATA, item)
        startActivity(detailIntent, options.toBundle())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_small_image_list, container, false)
        return view
    }

    lateinit var mAdapter: SmallImageListAdapter
    //activity instance
    lateinit var mActivity: AppCompatActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as MainActivity

        mAdapter = SmallImageListAdapter(mActivity, this)
        rvSmallImageItems.layoutManager = LinearLayoutManager(mActivity)
        rvSmallImageItems.adapter = mAdapter

        mAdapter.setItems(Item.ITEMS.toList())
    }
}