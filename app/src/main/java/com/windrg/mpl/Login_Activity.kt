package com.windrg.mpl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_.*
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.windrg.mpl.gtestrclasses.UserDataClass


class Login_Activity : AppCompatActivity() {
    private  var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)

        mAuth=FirebaseAuth.getInstance()

        go_to_sign_up_page.setOnClickListener {
            startActivity(Intent(this,Signup_Ativity::class.java))
        }

        login_login_button.setOnClickListener{
            Snackbar.make(findViewById(R.id.lofin_layout), "Wait...........", Snackbar.LENGTH_INDEFINITE).show()
            var email=findViewById<EditText>(R.id.login_email).editableText.toString()
            var password=findViewById<EditText>(R.id.login_password).editableText.toString()

            login(email,password)
        }

        login_forgot_password.setOnClickListener {
            startActivity(Intent(this,ForgotPassword::class.java))
        }

    }

    private fun login(email: String, password: String) {
        if (email.length in 1..50 && password.length in 6..16){
            Snackbar.make(findViewById(R.id.lofin_layout), "wait..", Snackbar.LENGTH_INDEFINITE).show()
            mAuth?.signInWithEmailAndPassword(email, password)
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val uid = mAuth?.getCurrentUser()?.uid.toString()
                            updateUI(uid)
                        } else {
                            // If sign in fails, display a message to the user.
                            Snackbar.make(findViewById(R.id.lofin_layout), "{"+task.exception?.message+"}", Snackbar.LENGTH_LONG).show()
                            updateUI(null)
                        }

                        // ...
                    }

        }
        else{
            Snackbar.make(findViewById(R.id.lofin_layout), "email password can't be empty", Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun updateUI(uid:String?) {

        if (uid==null){

        }
        else{

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("Users").child(uid).ref

              var valueEventListener= object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
              //  TODO(\"not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot) {
                val post = p0.getValue(UserDataClass::class.java)
                /*Snackbar.make(findViewById(R.id.lofin_layout), post?.email!!, Snackbar.LENGTH_LONG).show()*/
                val sharePref = SharedPreferenceDataClass.getInstance(applicationContext)
                if (post?.email==null){
                    mAuth?.signOut()
                    Snackbar.make(findViewById(R.id.lofin_layout),"thre is technical issue please connect to our technician", Snackbar.LENGTH_LONG).show()
                }
                else{
                    sharePref.setValue("email", post.email)
                    sharePref.setValue("name", post.name)
                    sharePref.setValue("img_url", post.img_url)
                    sharePref.setValue("username", post.username)
                    sharePref.setValue("bio", post.bio)
                   gotoProfilepage()
                }


            }
        }
            myRef.addValueEventListener(valueEventListener)



        }

    }

    private fun gotoProfilepage() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
