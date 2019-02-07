package com.windrg.mpl.RecyclerViewAdapter
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.windrg.mpl.R


class MainActivityHomeRecyclerViewAdapter(private var image_list: Array<String>, private var context:Context?): RecyclerView.Adapter<MainActivityHomeRecyclerViewAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType==1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.main_activity_home_fragment_recycler_view_first_card, parent, false)
            return ViewHolder(view)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.single_news_card, parent, false)
            return ViewHolder(view)
        }

        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position==0) {
            holder.recyclerviewFirsCard.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            holder.recyclerviewFirsCard.adapter=MainActivityHomeFirsCardHorizontalViewAdpter(image_list,context)
            holder.recyclerviewFirsCard.scrollToPosition(image_list.size)

        }

    }

    override fun getItemViewType(position: Int): Int {
       super.getItemViewType(position)
         if (position==0){
         return 1
         }
        else{
             return 2
         }

    }

    override fun getItemCount(): Int {
       return 2
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    public var recyclerviewFirsCard=itemView.findViewById<RecyclerView>(R.id.recyler_view_for_horizontal_ads_list)




    }


}

