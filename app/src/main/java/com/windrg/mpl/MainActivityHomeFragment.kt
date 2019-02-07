package com.windrg.mpl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.windrg.mpl.RecyclerViewAdapter.MainActivityHomeRecyclerViewAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainActivityHomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main_activity_home, container, false)


        var recyclerView:RecyclerView=view.findViewById(R.id.main_activity_home_fragment_recycler_view)
        val mLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        var arrayLis= arrayOf("http://hdwpro.com/wp-content/uploads/2016/01/Beach-Desktop-Wallpaper.jpg","http://hdwpro.com/wp-content/uploads/2016/01/Beach-Desktop-Wallpaper.jpg","http://hdwpro.com/wp-content/uploads/2016/01/Beach-Desktop-Wallpaper.jpg","http://hdwpro.com/wp-content/uploads/2016/01/Beach-Desktop-Wallpaper.jpg","http://hdwpro.com/wp-content/uploads/2016/01/Beach-Desktop-Wallpaper.jpg")

        recyclerView.layoutManager=mLayoutManager
        recyclerView.adapter=MainActivityHomeRecyclerViewAdapter(arrayLis,context)

        return view
    }


}
