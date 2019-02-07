package com.windrg.mpl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.windrg.mpl.PagerAdapter.MainActiviyTabPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser==null){
            startActivity(Intent(this,Login_Activity::class.java))
            finish()
    }



        val tooalbar =findViewById<Toolbar>(R.id.main_app_bar_layout)
        setSupportActionBar(tooalbar)
        supportActionBar?.title=""

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.logo_icon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val pageradapter= MainActiviyTabPagerAdapter(supportFragmentManager, 3)
        val viewpager= findViewById<ViewPager>(R.id.main_activity_view_pager)
        viewpager.adapter=pageradapter
        viewpager.offscreenPageLimit=2
        findViewById<TabLayout>(R.id.main_activity_tabbar).setupWithViewPager(viewpager)





       mDrawerLayout = this.findViewById(R.id.main_activity_drawerlayout)

        val navigationView: NavigationView = findViewById(R.id.main_activity_navigationbar)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            when(menuItem.itemId){
                R.id.main_activity_side_nav_profile->{
                    startActivity(Intent(this,Profile_Activity::class.java))

                }
                R.id.main_activity_side_nav_organize_match->{
                    startActivity(Intent(this,organize_match::class.java))

                }
                R.id.main_activity_side_nav_about->{
                        var intent=Intent(this,ScoreBordAddActivity::class.java)
                    intent.putExtra("pushkey","sdsweffwefwewf")
                                    startActivity(intent)



                                }

                R.id.main_activity_side_nav_log_out->{
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this,Login_Activity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }

                else->{
                    Toast.makeText(this,"nothing set anything behind this",Toast.LENGTH_SHORT).show()
                }
            }

            true
        }
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_activity_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         super.onOptionsItemSelected(item)
        return when(item?.itemId){
       /*     R.id.main_activity_menu_profile ->{
                startActivity(Intent(this,Profile_Activity::class.java))
                true
            }*/
            android.R.id.home->{
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            R.id.main_activity_menu_notification->{
                startActivity(Intent(this,NotificationActivity::class.java))
                true
            }


            else-> false

        }
    }



    }





