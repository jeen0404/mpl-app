package com.windrg.mpl.RecyclerViewAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.squareup.picasso.Picasso
import com.windrg.mpl.R
import com.windrg.mpl.gtestrclasses.NotificationOfAddingInTeamDataClass
import de.hdodenhof.circleimageview.CircleImageView


class NotificationRecyclerViewAdapter(private var notificationdata: ArrayList<NotificationOfAddingInTeamDataClass>, private var context: Context?,private var mRef:DatabaseReference): RecyclerView.Adapter<NotificationRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationRecyclerViewAdapter.ViewHolder {

      if (viewType==1){
          val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_single_team_add_card, parent, false)
          return ViewHolder(view)


      }
        else{
          val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_single_team_add_card, parent, false)
          return ViewHolder(view)
      }
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (notificationdata[position].viewtype.toInt()==1){
            holder.from_name.setText(notificationdata[position].from_name + "-"+ notificationdata[position].message)
        Picasso.get().load(notificationdata[position].from_img_url).into(holder.image)
            if (notificationdata[position].status=="Accepted"){
                holder.cancel.setText("Accepted")
                holder.accept.visibility=View.INVISIBLE
            }


        }

        holder.accept.setOnClickListener {
            holder.cancel.setText("Accepted")
            holder.accept.visibility=View.INVISIBLE
            mRef.child(notificationdata[position].pushkey).child("status").setValue("Accepted")
            mRef.child(notificationdata[position].pushkey).child("status").setValue("Accepted")

        }

        holder.cancel.setOnClickListener {
            if (notificationdata[position].status != "Accepted"){
                mRef.child(notificationdata[position].pushkey).setValue(null)
            }

        }


      //  holder.from_message.setText(notificationdata[position].message)

    }
    override fun getItemCount(): Int {
        return notificationdata.size
    }

    override fun getItemViewType(position: Int): Int {
         super.getItemViewType(position)
        if (notificationdata[position].viewtype.toInt()==1){
            return 1
        }
        else{
            return 2
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var from_name=itemView.findViewById<TextView>(R.id.notifiction_of_team_add_from)
       var accept=itemView.findViewById<TextView>(R.id.notifiction_of_team_add_accept)
       var cancel=itemView.findViewById<TextView>(R.id.notifiction_of_team_add_cancel)
       var image=itemView.findViewById<CircleImageView>(R.id.notifiction_of_team_add_profile_img)
       var layout=itemView.findViewById<RelativeLayout>(R.id.single_user_card_for_recycler_view_relativelayout)

    }


}

