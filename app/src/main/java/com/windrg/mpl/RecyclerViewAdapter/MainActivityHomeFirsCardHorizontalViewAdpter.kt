package com.windrg.mpl.RecyclerViewAdapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.windrg.mpl.R


class MainActivityHomeFirsCardHorizontalViewAdpter(private var image_list: Array<String>, private var context: Context?): RecyclerView.Adapter<MainActivityHomeFirsCardHorizontalViewAdpter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_image_view_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(image_list[position]).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return image_list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        public var imageView=itemView.findViewById<ImageView>(R.id.single_image_view_layout_image_view)

    }


}

