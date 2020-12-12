package com.example.bliss.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bliss.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class EmojiAdapter(private val fragment: Fragment, private val items: Map<String, String>) :
    RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        for((key, value) in items){
            Picasso.get().load(value).into(holder.img)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView = view.img_item
    }
}