package com.windrg.mpl

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.*
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import kotlin.collections.HashMap
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.util.Log
import java.util.*


class organize_match : AppCompatActivity() {


    var hashMap_main_match:HashMap<Any,Any> = HashMap<Any,Any>()
    var hashMap_team_one:HashMap<Any,Any> = HashMap<Any,Any>()
    var hashMap_team_two:HashMap<Any,Any> = HashMap<Any,Any>()
    var hashMap_toss:HashMap<Any,Any> = HashMap<Any,Any>()

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organize_match)

        setSupportActionBar(findViewById(R.id.orgnize_match_app_bar_layout))
        supportActionBar?.title = "New Match- "





        findViewById<Button>(R.id.ot_match_date).setOnClickListener {
            val c = Calendar.getInstance()
           val mYear = c.get(Calendar.YEAR)
           val mMonth = c.get(Calendar.MONTH)
           val mDay = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> findViewById<Button>(R.id.ot_match_date).setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                        hashMap_toss["date"]=dayOfMonth.toString() +"-"+ monthOfYear.toString() +"-"+year.toString()
                    }, mYear, mMonth, mDay)

            datePickerDialog.show()
        }



 ////////////////////////////////////////////////////////////////// toss wins by team/////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////// toss wins by team/////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////// toss wins by team/////////////////////////////////////////////////////////////////
        val spinner: Spinner = findViewById(R.id.ot_batting_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.team_name_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        val spinner2: Spinner = findViewById(R.id.ot_toss_win)
        ArrayAdapter.createFromResource(
                this,
                R.array.team_name_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter

        }














        //////////////////////////////////////////////////////////////for team 1 players/////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////for team 1 players/////////////////////////////////////////////////////////////////////////



        findViewById<EditText>(R.id.ot_team_1_player_1).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,1)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_2).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_2).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,2)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_3).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_3).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,3)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        findViewById<EditText>(R.id.ot_team_1_player_4).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {
                val s = findViewById<EditText>(R.id.ot_team_1_player_4).editableText.toString()
                if (s.contains("@")){
                    SerchnameFirebasee( s.removePrefix("@"),1,4)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_5).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_5).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,5)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_6).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_6).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,6)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_7).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_7).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,7)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_8).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_8).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,8)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_9).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_9).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,9)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_10).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_10).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,10)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_1_player_11).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_1_player_11).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),1,11)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


       //////////////////////////////////////////////////////////////// /// for player of team 2////////////////////////////////////////////////////////////////////
       //////////////////////////////////////////////////////////////// /// for player of team 2////////////////////////////////////////////////////////////////////

        findViewById<EditText>(R.id.ot_team_2_player_1).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,1)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_2).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,2)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_3).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,3)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        findViewById<EditText>(R.id.ot_team_2_player_4).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {
                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){
                    SerchnameFirebasee( s.removePrefix("@"),2,4)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_5).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,5)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_6).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,6)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_7).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,7)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_8).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,8)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_9).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,9)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_10).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,10)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        findViewById<EditText>(R.id.ot_team_2_player_11).addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s1: Editable?) {

                val s = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                if (s.contains("@")){

                    SerchnameFirebasee( s.removePrefix("@"),2,11)
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

    }



////////////////////////////////////////////////////////////////////////serach username on firebase/////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////serach username on firebase/////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////serach username on firebase/////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////serach username on firebase/////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////serach username on firebase/////////////////////////////////////////////////////////////////////

    fun SerchnameFirebasee(s:String,team_no: Int,player_no: Int){
        if (s.matches(Regex("^[a-zA-Z0-9_]+$"))){
            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout),"wait..",Snackbar.LENGTH_INDEFINITE).show()
            val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef = firebaseDatabase.getReference("Usernamelist").child(s).ref

            myRef.addValueEventListener( object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }
                override fun onDataChange(p0: DataSnapshot) {
                    Snackbar.make(findViewById(R.id.orgnize_match_activity_layout),p0.toString(),Snackbar.LENGTH_SHORT).show()
                    if (p0.child("username").value != null){

                        val hash_for_single_player=HashMap<String,String>()
                        hash_for_single_player["username"]=p0.child("username").value.toString()
                        hash_for_single_player["email"]=p0.child("email").value.toString()
                        hash_for_single_player["uid"]=p0.child("uid").value.toString()

                        if (team_no==1){
                            hashMap_team_one[player_no.toString()] = hash_for_single_player
                        }
                        else if (team_no==2){
                            hashMap_team_two[player_no.toString()] = hash_for_single_player
                        }
                        showSnackbar(findViewById(R.id.orgnize_match_activity_layout),p0.child("email").value.toString() ,5000,team_no,player_no,p0.child("uid").value.toString())
                    }
                    else{
                        Snackbar.make(findViewById(R.id.orgnize_match_activity_layout),"username not found",Snackbar.LENGTH_SHORT).show()
                    }
                }
            })
        }
        else{
            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout),"Username In wrong pattern",Snackbar.LENGTH_SHORT).show()
        }
    }

    

//////////////////////////////////////////////show snack of firebase search/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////show snack of firebase search/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////show snack of firebase search/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////show snack of firebase search/////////////////////////////////////////////////////////////////////////////////////////////



    fun showSnackbar(view: View, message: String, duration: Int,team_no:Int,player_no:Int,uid:String) {
        // Create snackbar
        val snackbar = Snackbar.make(view, message, duration)
        // Set an action on it, and a handler
        snackbar.setAction("Ok") {
            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "Wait...$message",Snackbar.LENGTH_INDEFINITE).show()
            val myRef = FirebaseDatabase.getInstance().reference.child("Users").child(uid).child("notification").ref
            val notification=HashMap<String,String>()
            val sharePref = SharedPreferenceDataClass.getInstance(applicationContext)
            val pushkey=myRef.push().key.toString()
            notification["from_name"]=sharePref.getStringValue("name","").toString()
            notification["from_uid"]=FirebaseAuth.getInstance().currentUser?.uid.toString()
            notification["message"]="invite you in team to play match with him "
            notification["from_img_url"]= sharePref.getStringValue("img_url","").toString()
            notification["viewtype"]="1"
            notification["pushkey"]=pushkey
            notification["status"]="Requested"

            myRef.child(pushkey).setValue(notification).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Snackbar.make(findViewById(R.id.orgnize_match_activity_layout)," Notification is send to Player",Snackbar.LENGTH_SHORT).show()
                }
                else{
                    Snackbar.make(findViewById(R.id.orgnize_match_activity_layout),task.exception?.message.toString(),Snackbar.LENGTH_SHORT).show()
                }
            }
            
            if (team_no==1){
                when (player_no) {
                    1 -> findViewById<EditText>(R.id.ot_team_1_player_1).setText(message, TextView.BufferType.EDITABLE)
                    2 -> findViewById<EditText>(R.id.ot_team_1_player_2).setText(message, TextView.BufferType.EDITABLE)
                    3 -> findViewById<EditText>(R.id.ot_team_1_player_3).setText(message, TextView.BufferType.EDITABLE)
                    4 -> findViewById<EditText>(R.id.ot_team_1_player_4).setText(message, TextView.BufferType.EDITABLE)
                    5 -> findViewById<EditText>(R.id.ot_team_1_player_5).setText(message, TextView.BufferType.EDITABLE)
                    6 -> findViewById<EditText>(R.id.ot_team_1_player_6).setText(message, TextView.BufferType.EDITABLE)
                    7 -> findViewById<EditText>(R.id.ot_team_1_player_7).setText(message, TextView.BufferType.EDITABLE)
                    8 -> findViewById<EditText>(R.id.ot_team_1_player_8).setText(message, TextView.BufferType.EDITABLE)
                    9 -> findViewById<EditText>(R.id.ot_team_1_player_9).setText(message, TextView.BufferType.EDITABLE)
                    10 -> findViewById<EditText>(R.id.ot_team_1_player_10).setText(message, TextView.BufferType.EDITABLE)
                    11 -> findViewById<EditText>(R.id.ot_team_1_player_11).setText(message, TextView.BufferType.EDITABLE)
                }
            }


            else if (team_no==2){
                when (player_no) {
                    1 -> findViewById<EditText>(R.id.ot_team_2_player_1).setText(message, TextView.BufferType.EDITABLE)
                    2 -> findViewById<EditText>(R.id.ot_team_2_player_2).setText(message, TextView.BufferType.EDITABLE)
                    3 -> findViewById<EditText>(R.id.ot_team_2_player_3).setText(message, TextView.BufferType.EDITABLE)
                    4 -> findViewById<EditText>(R.id.ot_team_2_player_4).setText(message, TextView.BufferType.EDITABLE)
                    5 -> findViewById<EditText>(R.id.ot_team_2_player_5).setText(message, TextView.BufferType.EDITABLE)
                    6 -> findViewById<EditText>(R.id.ot_team_2_player_6).setText(message, TextView.BufferType.EDITABLE)
                    7 -> findViewById<EditText>(R.id.ot_team_2_player_7).setText(message, TextView.BufferType.EDITABLE)
                    8 -> findViewById<EditText>(R.id.ot_team_2_player_8).setText(message, TextView.BufferType.EDITABLE)
                    9 -> findViewById<EditText>(R.id.ot_team_2_player_9).setText(message, TextView.BufferType.EDITABLE)
                    10 -> findViewById<EditText>(R.id.ot_team_2_player_10).setText(message, TextView.BufferType.EDITABLE)
                    11 -> findViewById<EditText>(R.id.ot_team_2_player_11).setText(message, TextView.BufferType.EDITABLE)
                }
            }
            snackbar.dismiss()
        }
        snackbar.show()
    }





    /* ////////////////////////////////////////// upload details *///////////////////////////////////////////////////////////////////////////////////////////////////
    /* ////////////////////////////////////////// upload details *///////////////////////////////////////////////////////////////////////////////////////////////////
    /* ////////////////////////////////////////// upload details *///////////////////////////////////////////////////////////////////////////////////////////////////
    /* ////////////////////////////////////////// upload details *///////////////////////////////////////////////////////////////////////////////////////////////////
    /* ////////////////////////////////////////// upload details *///////////////////////////////////////////////////////////////////////////////////////////////////
    fun uploadTeamdetails() {
        Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "wait.....", Snackbar.LENGTH_LONG).show()
        val team_1_name = findViewById<EditText>(R.id.ot_team_1_name).editableText.toString()
        val team_2_name = findViewById<EditText>(R.id.ot_team_2_name).editableText.toString()
        hashMap_toss["toss_win"]=findViewById<Spinner>(R.id.ot_toss_win).selectedItem.toString();
        hashMap_toss["batting"]=findViewById<Spinner>(R.id.ot_batting_spinner).selectedItem.toString();

        if (team_1_name.equals("") || team_2_name.equals("")) {
            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "to save details give name of team", Snackbar.LENGTH_LONG).show()
        }
        else{

            if (findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString().equals("") ||
                    findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_2).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_3).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_4).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_5).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_6).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_7).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_8).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_9).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_10).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_1_player_11).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString().equals("") ||
                    findViewById<EditText>(R.id.ot_team_2_player_2).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_3).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_4).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_5).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_6).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_7).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_8).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_9).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_10).editableText.toString().equals("")||
                    findViewById<EditText>(R.id.ot_team_2_player_11).editableText.toString().equals(""))
            {
                Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "Player name cant be empty", Snackbar.LENGTH_LONG).show()
            }
            else{
            for (j in 1..2){
            for (i in 1..11){

                if (j==1) {
                    val k_map:HashMap<String,String>? = hashMap_team_one[i.toString()] as HashMap<String, String>
                    if (k_map == null) {
                        val hash_for_single_player = HashMap<String, String>()
                        hash_for_single_player["email"] = "don't have account"
                        hash_for_single_player["uid"] = "don't have account"
                        when (i) {
                            1 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()
                            2 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_2).editableText.toString()
                            3 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_3).editableText.toString()
                            4 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_4).editableText.toString()
                            5 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_5).editableText.toString()
                            6 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_6).editableText.toString()
                            7 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_7).editableText.toString()
                            8 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_8).editableText.toString()
                            9 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_9).editableText.toString()
                            10 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_10).editableText.toString()
                            11 -> hash_for_single_player["username"] = findViewById<EditText>(R.id.ot_team_1_player_11).editableText.toString()
                        }
                        hashMap_team_one[i.toString()]=hash_for_single_player
                    }
                    else{
                        when(i){
                            1->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()}}
                            2->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_2).editableText.toString()}}
                            3->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_3).editableText.toString()}}
                            4->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_4).editableText.toString()}}
                            5->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_5).editableText.toString()}}
                            6->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_6).editableText.toString()}}
                            7->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_7).editableText.toString()}}
                            8->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_8).editableText.toString()}}
                            9->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_9).editableText.toString()}}
                            10->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_10).editableText.toString()}}
                            11->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_2_player_11).editableText.toString()}}

                        }
                    }
                }
                if (j==2){
                    val k_map:HashMap<String,String>? = hashMap_team_two[i.toString()] as HashMap<String, String>
                    if (hashMap_team_two[i.toString()] == null ){
                        val hash_for_single_player=HashMap<String,String>()
                        hash_for_single_player["email"]="don't have account"
                        hash_for_single_player["uid"]="don't have account"

                        when (i) {
                            1 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_1).editableText.toString()
                            2 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_2).editableText.toString()
                            3 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_3).editableText.toString()
                            4 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_4).editableText.toString()
                            5 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_5).editableText.toString()
                            6 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_6).editableText.toString()
                            7 ->hash_for_single_player["username"]= findViewById<EditText>(R.id.ot_team_2_player_7).editableText.toString()
                            8 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_8).editableText.toString()
                            9 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_9).editableText.toString()
                            10 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_10).editableText.toString()
                            11 -> hash_for_single_player["username"]=findViewById<EditText>(R.id.ot_team_2_player_11).editableText.toString()
                        }
                        hashMap_team_two[i.toString()]=hash_for_single_player
                    }
                    else{
                        when(i){
                            1->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()}}
                            2->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_2).editableText.toString()}}
                            3->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_3).editableText.toString()}}
                            4->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_4).editableText.toString()}}
                            5->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_5).editableText.toString()}}
                            6->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_6).editableText.toString()}}
                            7->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_7).editableText.toString()}}
                            8->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_8).editableText.toString()}}
                            9->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_9).editableText.toString()}}
                            10->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_10).editableText.toString()}}
                            11->{if (k_map!!["username"].toString() != findViewById<EditText>(R.id.ot_team_1_player_1).editableText.toString()){k_map["username"] = findViewById<EditText>(R.id.ot_team_1_player_11).editableText.toString()}}

                        }
                    }
                }


            }

            }
            hashMap_main_match["team_1"] = hashMap_team_one
            hashMap_main_match["team_2"] = hashMap_team_two
            hashMap_main_match["toss"] = hashMap_toss
            hashMap_main_match["over"] =findViewById<EditText>(R.id.ot_total_over).editableText.toString()
            hashMap_main_match["team_one_name"] =findViewById<EditText>(R.id.ot_team_1_name).editableText.toString()
            hashMap_main_match["team_two_name"] =findViewById<EditText>(R.id.ot_team_2_name).editableText.toString()



            for (j in 1..2){
            for (k in 1..11){
                val k_map:HashMap<String,String> = hashMap_team_two[k.toString()] as HashMap<String, String>
            for (i in 1..11){
                if (j==1){
                    if (i == k){
                    }
                    else{
                        var i_map:HashMap<String,String> = hashMap_team_one[i.toString()] as HashMap<String, String>
                        var TAG="team onee"

                        Log.d(TAG, "j=$j    i=$i    k=$k: " + i_map["username"] +"=="+ k_map["username"])

                        if (i_map["username"].toString() ==k_map["username"].toString()){
                            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "one User cant be one or more time in team one ++ i=$i  k=$k " , Snackbar.LENGTH_INDEFINITE).show()
                            break
                        }
                    }
                }
                if (j==2){
                    if (i == k){
                    }
                    else{
                        val i_map:HashMap<String,String> = hashMap_team_two[i.toString()] as HashMap<String, String>
                        var TAG="team twooo"

                        Log.d(TAG, "j=$j    i=$i    k=$k: " + i_map["username"] +"=="+ k_map["username"])
                        if (i_map["username"].toString() ==k_map["username"].toString()){
                            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "one User cant be one or more time in team two  ++ i=$i ++k=$k", Snackbar.LENGTH_LONG).show()
                            break
                        }
                        else if (j==2 || i==11 || k==10){
                        //    CheckUserisRequest()
                        }
                    }
                }

            }
           }

          }



        }
        }
    }

    private fun CheckUserisRequest() {
        val over:String=findViewById<EditText>(R.id.ot_total_over).editableText.toString()
        if (!over.equals("")){
            if (over.toInt() in 5..50){
            }
            else{
                Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "over must be between 5 to 50", Snackbar.LENGTH_LONG).show()
            }
        }
        else{
            Snackbar.make(findViewById(R.id.orgnize_match_activity_layout), "over can't be empty", Snackbar.LENGTH_LONG).show()
        }
    }


    //////////////////////////////////////////////////////////////////////whwn user press back////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////whwn user press back////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////whwn user press back////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////whwn user press back////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////whwn user press back////////////////////////////////////////////////////////////////////
    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("if you press back your added details will be lost")
                .setNegativeButton("cancel", null)
                 .setPositiveButton("it's ok") { dialog, which ->
                startActivity(Intent(this,MainActivity::class.java))
                }
                .create()
                .show()
    }





    //////////////////////////////////////////////////////////////////////menu bar ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////menu bar ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////menu bar ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////menu bar ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////menu bar ////////////////////////////////////////////////////////////////////////

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.organize_match_mein_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         super.onOptionsItemSelected(item)
        return when(item?.itemId){
            R.id.organize_match_save_and_start->{
                AlertDialog.Builder(this)
                        .setTitle("Alert")
                        .setMessage("you can save detail to start later or can start match directly")
                        .setNegativeButton("save it"){dialog, which ->
                            uploadTeamdetails()
                        }
                        .setPositiveButton("start match") { dialog, which ->

                        }
                        .create()
                        .show()
                 true
            }
            else->{false}
        }
    }

}