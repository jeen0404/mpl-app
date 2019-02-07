package com.windrg.mpl
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_after__signup_.*
import com.google.firebase.database.FirebaseDatabase
import android.provider.MediaStore
import java.io.IOException
import kotlin.collections.HashMap


class After_Signup_Activity : AppCompatActivity() {

    private var mAuth:FirebaseAuth?=null
    private var filePath: Uri? = null

    private val PICK_IMAGE_REQUEST = 71

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after__signup_)

        mAuth=FirebaseAuth.getInstance()

        val sharPref=SharedPreferenceDataClass.getInstance(this)
        val email = sharPref.getStringValue("email","")
        val displayname = sharPref.getStringValue("name","")
        val img_url = sharPref.getStringValue("img_url","")

       val username= findViewById<EditText>(R.id.after_signup_username)
       val name= findViewById<EditText>(R.id.after_signup_name)
       val password= findViewById<EditText>(R.id.after_signup_password)
       val r_password= findViewById<EditText>(R.id.after_signup_retype_password)
        val bio =    findViewById<EditText>(R.id.after_signup_bio)


        name.setText(displayname,TextView.BufferType.EDITABLE)
        Picasso.get().load(img_url).into(findViewById<CircleImageView>(R.id.after_signup_profile_image))

        after_signup_start.setOnClickListener {
            Snackbar.make(findViewById(R.id.after_signup_layout), "Wait...........", Snackbar.LENGTH_INDEFINITE).show()
            Cheching_Details(email,displayname,img_url,username,name,password,r_password,bio)
        }



    }








    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.data != null) {
            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                findViewById<CircleImageView>(R.id.after_signup_profile_image).setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }




    private fun Cheching_Details(email: String?, displayname: String?, img_url: String?, username: EditText, name: EditText, password: EditText, r_password: EditText, bio: EditText) {
        if (password.editableText.toString() == r_password.editableText.toString()){
            if (password.editableText.toString().length in 7..15){
                if (username.editableText.toString().length in 7..16){
                    if (username.editableText.toString().contains(" ")){
                        Snackbar.make(findViewById(R.id.after_signup_layout), "username can't contain space.", Snackbar.LENGTH_SHORT).show()
                    }
                    else{
                        if (name.editableText.toString().length in 7..16){
                            if (bio.editableText.toString().length in 20..500){
                                val hashMap:HashMap<String,String> = HashMap()
                                hashMap["email"] = email.toString()
                                hashMap["name"] = name.editableText.toString()
                                hashMap["username"] = username.editableText.toString()
                                hashMap["bio"] = bio.editableText.toString()
                                hashMap["img_url"] = img_url.toString()

                                val sharPref=SharedPreferenceDataClass.getInstance(this)
                                sharPref.setValue("bio", bio.editableText.toString())
                                sharPref.setValue("username", username.editableText.toString())

                                SignIN(email,password,hashMap)


                            }
                            else{
                                Snackbar.make(findViewById(R.id.after_signup_layout), "bio length must be more than 20 ", Snackbar.LENGTH_SHORT).show()
                            }
                        }
                        else{
                            Snackbar.make(findViewById(R.id.after_signup_layout), "name length must be more than 6 and less than 16", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    Snackbar.make(findViewById(R.id.after_signup_layout), "username length must be more than 6 and less than 16", Snackbar.LENGTH_SHORT).show()
                }
            }
            else{
                Snackbar.make(findViewById(R.id.after_signup_layout), "password length must be more then 6 char.. and less than 16", Snackbar.LENGTH_SHORT).show()
            }
        }
        else{

            Snackbar.make(findViewById(R.id.after_signup_layout), "password not matching..", Snackbar.LENGTH_SHORT).show()
        }
    }



    private fun SignIN(email: String?, password: EditText, hashMap: HashMap<String, String>) {
        mAuth?.createUserWithEmailAndPassword(email.toString(), password.editableText.toString())?.addOnCompleteListener{
            task->  if (task.isSuccessful){
            hashMap["uid"]=FirebaseAuth.getInstance().currentUser?.uid.toString()

            UploadData(hashMap)

        }else{
            Snackbar.make(findViewById(R.id.after_signup_layout), task.exception?.message.toString(), Snackbar.LENGTH_SHORT).show()
        }

        }

    }

    private fun UploadData(hashMap: HashMap<String, String>) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Users").child(mAuth?.currentUser?.uid!!).ref
        val myRef2 = database.getReference("Usernamelist").child(hashMap["username"].toString()).ref

        myRef.setValue(hashMap).addOnCompleteListener{
            task2->if(task2.isSuccessful){

            var hsmap=HashMap<String,String>()
            hsmap["username"]=hashMap["username"].toString()
            hsmap["email"]=hashMap["email"].toString()
            hsmap["uid"]=hashMap["uid"].toString()
            myRef2.setValue(hsmap).addOnCompleteListener { task3 ->
                if (task3.isSuccessful){
                    UpdateUI()
                }
                else{
                    myRef.setValue(null)
                    FirebaseAuth.getInstance().currentUser?.delete()
                    Snackbar.make(findViewById(R.id.after_signup_layout), task2.exception?.message.toString(), Snackbar.LENGTH_SHORT).show()
                    val intent = Intent(this,Signup_Ativity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }
        else{
            FirebaseAuth.getInstance().currentUser?.delete()
            Snackbar.make(findViewById(R.id.after_signup_layout), task2.exception?.message.toString(), Snackbar.LENGTH_SHORT).show()
            val intent = Intent(this,Signup_Ativity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        }

    }



    private fun UpdateUI() {
        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }


}
