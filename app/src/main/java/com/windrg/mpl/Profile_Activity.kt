package com.windrg.mpl

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_profile_.*

class Profile_Activity : AppCompatActivity() {

    private lateinit var editname:EditText
    private lateinit var editusername:EditText
    private lateinit var editbio:EditText
    private var a:Int=0

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_)

        val tooalbar =findViewById<Toolbar>(R.id.profile_activity_app_bar_layout)
        setSupportActionBar(tooalbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)


        val sharePrf=SharedPreferenceDataClass.getInstance(this)

        Picasso.get().load(sharePrf.getStringValue("img_url","http://www.piachievers.com/img/users-male-2.png")).into(findViewById<CircleImageView>(R.id.profile_activity_profile_icon))
        findViewById<TextView>(R.id.profile_activity_name).text=sharePrf.getStringValue("name","")
        findViewById<TextView>(R.id.profile_activity_bio).text=sharePrf.getStringValue("bio","")
        supportActionBar?.title=sharePrf.getStringValue("username","")



        editname=findViewById(R.id.profile_editprofile_name)
        editusername=findViewById(R.id.profile_editprofile_usename)
        editbio=findViewById(R.id.profile_editprofile_bio)



        profile_editprofile_btn.setOnClickListener {
            editProfile()
        }
    }



    private fun editProfile() {
      if (a != 0){
          findViewById<TextView>(R.id.profile_editprofile_btn).text="Edit"
          findViewById<Button>(R.id.profile_editprofile_submit).visibility=View.GONE
          editname.visibility=View.GONE
          editusername.visibility=View.GONE
          editbio.visibility=View.GONE
          a=0
      }
        else{
          findViewById<TextView>(R.id.profile_editprofile_btn).text="cancel"
          findViewById<Button>(R.id.profile_editprofile_submit).visibility=View.VISIBLE
          editname.visibility=View.VISIBLE
          editusername.visibility=View.VISIBLE
          editbio.visibility=View.VISIBLE
          a=1
      }



    }
}
