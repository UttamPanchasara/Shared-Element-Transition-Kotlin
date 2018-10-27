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
import kotlinx.android.synthetic.main.list_grid_images.view.*

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 10/26/2018
 */
class GridImageListAdapter(val context: Context, val clickListener: GridImageItemClickListener) :
    RecyclerView.Adapter<GridImageHolder>() {

    private lateinit var items: List<Item>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridImageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_grid_images, p0, false)
        return GridImageHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: GridImageHolder, p1: Int) {
        val item = items.get(p1)
        p0.bindItem(item)
        p0.itemView.setOnClickListener(View.OnClickListener {
            clickListener.onItemClick(item, p0.itemView.ivGridImage, p0.itemView.txtName)
        })
    }

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class GridImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(item: Item) {
        itemView.txtName.text = item.name
        Picasso.get().load(item.thumbnailUrl).into(itemView.ivGridImage)
    }
}

interface GridImageItemClickListener {
    fun onItemClick(item: Item, imageView: ImageView, textView: TextView)
}
