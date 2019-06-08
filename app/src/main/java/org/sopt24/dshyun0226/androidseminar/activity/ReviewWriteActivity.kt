package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.opengl.ETC1.isValid
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_review_write.*
import kotlinx.android.synthetic.main.toolbar_reviewwrite.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.networkStatsManager
import org.jetbrains.anko.toast
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.Post.PostCommentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class ReviewWriteActivity : AppCompatActivity() {

//    lateinit var selectedPicUri: Uri
//    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
//
//    val networkService: NetworkService by lazy {
//        ApplicationController.instance.networkService //NetworkService Interface 객체 불러오기
//    }
//
//    var product_id=-1
//    var episode_id=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_write)

     //   configureToolbar()

    }

//    private fun configureToolbar() {
////        product_id=intent.getIntExtra("idx",-1)
////        episode_id=intent.getIntExtra("episode_id",-1)
////        if(product_id==-1 || episode_id == -1) finish()
//
//        txt_toolbar_write_comment_cancel.setOnClickListener {
//            finish()
//        }
//
//        txt_toolbar_write_comment_submit.setOnClickListener {
//
//            postCommentResponse()
//        }
//
//        img_bottom_wirte_commnet_camera.setOnClickListener {
//            //카메라 롤을 여는 로직
//        val intent = Intent(Intent.ACTION_PICK)
//            intent.type=android.provider.MediaStore.Images.Media.CONTENT_TYPE
//            intent.data=android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            startActivityForResult(intent,REQUEST_CODE_SELECT_IMAGE)
//        }
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==REQUEST_CODE_SELECT_IMAGE) {
//            if(resultCode== Activity.RESULT_OK){
//                data?.let{
//                    selectedPicUri=it.data
//                    Glide.with(this).load(selectedPicUri)
//                        .thumbnail(0.1f).into(img_comment_write_roll)
//                }
//            }
//        }
//    }
//    private fun postCommentResponse() {
//        val token = SharedPreferenceController.getUserToken(this)
//        val title = edt_comment_wirte_title.text.toString()
//        val comment = edt_comment_write_comment.text.toString()
//
//            val title_rb= RequestBody.create(MediaType.parse("text/plain"),title)
//            val comment_rb= RequestBody.create(MediaType.parse("text/plain"),comment)
//
//        val options = BitmapFactory.Options()
//        val inputStream: InputStream= contentResolver.openInputStream(selectedPicUri)
//        val bitmap= BitmapFactory.decodeStream(inputStream, null, options)
//        val byteArraOutputStream=ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.JPEG,20,byteArraOutputStream)
//        val photoBody= RequestBody.create(MediaType.parse("image/jpg"),byteArraOutputStream.toByteArray())
//
//       val picture_rb= MultipartBody.Part.createFormData("cmtImg", File(selectedPicUri.toString()).name,photoBody)
//
//        val postCommentResponse = networkService.postCommentResponse(token, episode_id,comment_rb,picture_rb)
//
//        postCommentResponse.enqueue(object: Callback<PostCommentResponse> {
//            override fun onFailure(call: Call<PostCommentResponse>, t: Throwable) {
//                Log.e("write comment failed",t.toString())
//            }
//
//            override fun onResponse(call: Call<PostCommentResponse>, response: Response<PostCommentResponse>) {
//                if(response.isSuccessful) {
//                    toast(response.body()!!.message)
//                    if(response.body()!!.status==200)finish()
//                }
//            }
//
//        })
//
//
//
//
//
//       }
   }




