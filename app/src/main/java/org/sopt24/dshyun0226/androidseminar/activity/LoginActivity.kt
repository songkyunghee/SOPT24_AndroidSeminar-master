package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.Post.PostLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY=1000

    val networkService:NetworkService by lazy {
        ApplicationController.instance.networkService //NetworkService Interface 객체 불러오기
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()


            if(isValid(login_u_id, login_u_pw)) postLoginResponse(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener{

            val simpleDateFormat=SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time=simpleDateFormat.format(Date())


            val intent: Intent = Intent(this, SignupActivity::class.java)
            intent.putExtra("time",s_time)

            startActivityForResult(intent,REQUEST_CODE_LOGIN_ACTIVITY)
        }

    }

    fun isValid(u_id: String, u_pw: String): Boolean{
        if(u_id == "") edtLoginID.requestFocus()
        else if(u_pw == "") edtLoginPW.requestFocus()
        else return true
        return false
    }

    fun postLoginResponse(u_id: String, u_pw: String){

        //id,pw를 json객체로 만듬
        var jsonObject= JSONObject()
        jsonObject.put("id",u_id)
        jsonObject.put("password", u_pw)

        val gsonObject= JsonParser().parse(jsonObject.toString()) as JsonObject

        //NetworkService를 통해 실제로 통신을 요청
        val postLoginResponse: Call<PostLoginResponse> =
            networkService.postLoginResponse("application/json",gsonObject) //NetworkService.postLoginResponse(Header/Body)

        postLoginResponse.enqueue(object: Callback<PostLoginResponse>{ //enqueue->동기식:상대방의 상태와 관계없이 일방적으로 동작
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) { //HTTP Response를 받지 못할 때
                Log.e("Login failed", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) { //HTTP Response를 받았을 때
                if(response.isSuccessful) { //Response code가 성공 200~299
                    if(response.body()!!.status==201) { //HTTP Response에 포함된 status가 201
                       // SharedPreferenceController.setUserToken(applicationContext,response.body()!!.data!!)
                        finish()
                    }
                }
            }

        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE_LOGIN_ACTIVITY) {
            if(resultCode== Activity.RESULT_OK) {
                val e_time=data!!.getStringExtra("end_time")
                Toast.makeText(this, "End time:${e_time}",Toast.LENGTH_SHORT).show()

            }
        }
    }
}























