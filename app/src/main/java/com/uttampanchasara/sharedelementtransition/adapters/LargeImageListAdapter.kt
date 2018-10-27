package com.uttampanchasara.sharedelementtransition.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.uttampanchasara.sharedelementtransition.R
import com.uttampanchasara.sharedelementtransition.models.Item
import kotlinx.android.synthetic.main.list_large_image.view.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/26/2018
 */
class SampleOneItemListAdapter(val context: Context, val clickListener: SampleOneItemClickListener) :
    RecyclerView.Adapter<ViewHolder>() {

    private lateinit var items: List<Item>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_large_image, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = items.get(p1)
        p0.bindItem(item)
        p0.itemView.setOnClickListener(View.OnClickListener {
            clickListener.onItemClick(item, p0.itemView.ivLargeImage, p0.itemView.txtName)
        })
    }

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(item: Item) {
        itemView.txtName.text = item.name
        Picasso.get().load(item.thumbnailUrl).into(itemView.ivLargeImage)
    }
}

interface SampleOneItemClickListener {
    fun onItemClick(item: Item, imageView: ImageView, textView: TextView)
}