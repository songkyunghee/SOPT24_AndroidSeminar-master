package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.Post.PostSignupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    val networkService:NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)



        val edtOnFocusChangeListener: View.OnFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtSignupName.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupID.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupPW.setOnFocusChangeListener(edtOnFocusChangeListener)

        btnSignupSubmit.setOnClickListener {
            val signup_u_name: String = edtSignupName.text.toString()
            val signup_u_id = edtSignupID.text.toString()
            val signup_u_pw: String = edtSignupPW.text.toString()

            if(signup_u_name == "") edtSignupName.requestFocus()
            else if(signup_u_id == "") edtSignupID.requestFocus()
            else if(signup_u_pw == "") edtSignupPW.requestFocus()
            else{
                postSignupResponse(signup_u_id, signup_u_pw, signup_u_name)
                finish()
            }
        }
    }

    fun postSignupResponse(u_id: String, u_pw: String, u_name: String){

        val jsonObject = JSONObject()
        jsonObject.put("id",u_id)
        jsonObject.put("password",u_pw)
        jsonObject.put("name",u_name)

        val gsonObject=JsonParser().parse(jsonObject.toString()) as JsonObject

        val postSignupResponse: Call<PostSignupResponse> =
            networkService.postSignupResponse("application/json",gsonObject)

        postSignupResponse.enqueue(object: Callback<PostSignupResponse>{
            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                Log.e("Login failed",t.toString())
            }

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                if(response.isSuccessful) {
                    toast(response.body()!!.message)
                if(response.body()!!.status==201) {
                    val simpleDateFormat=SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                    val e_time=simpleDateFormat.format(Date())

                    val intent:Intent= Intent()
                    intent.putExtra("ent_time",e_time)
                    setResult(Activity.RESULT_OK,intent)

                    SharedPreferenceController.getUserToken(applicationContext)
                    // Request Signup
                    finish()
                }
                }
            }

        })


    }
}
