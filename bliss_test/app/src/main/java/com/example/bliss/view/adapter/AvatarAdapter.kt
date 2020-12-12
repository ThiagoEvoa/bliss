package com.example.bliss.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.bliss.R
import com.example.bliss.model.Repo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class AvatarAdapter(private val items: MutableList<Repo>) :
    RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        Picasso.get().load(item.owner.avatar_url).into(holder.img)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView = view.img_item
    }
}