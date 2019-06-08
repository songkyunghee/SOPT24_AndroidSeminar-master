package org.sopt24.dshyun0226.androidseminar.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.fragment_all_product_main.*
import kotlinx.android.synthetic.main.toolbar_product.*
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ProductListRecyclerViewAdpater
import org.sopt24.dshyun0226.androidseminar.adapter.ProductOverviewRecyclerViewAdpater
import org.sopt24.dshyun0226.androidseminar.data.ProductListData
import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.data.WebtoonOverviewData
import org.sopt24.dshyun0226.androidseminar.network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.Post.GetEpisodeListResponse
import org.sopt24.dshyun0226.androidseminar.network.Post.GetEpisodeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity() {

    lateinit var productListRecyclerViewAdpater: ProductListRecyclerViewAdpater

    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var title = intent.getStringExtra("title")
        txt_toolbar_product_title.text= title




        btn_toolbar_product_like.setOnClickListener{
            btn_toolbar_product_like.isSelected = !btn_toolbar_product_like.isSelected
        }

        btn_toolbar_product_back.setOnClickListener {
            finish()
        }

        var dataList: ArrayList<ProductListData> = ArrayList()
//        dataList.add(
//            ProductListData(
//
//                0,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","1화.문어지지 말자!","조회수13만회","19.03.25")
//        )
//        dataList.add(
//            ProductListData(
//
//                1,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","2화.문어지지 말자 우리!","조회수13만회","19.03.26")
//        )
//
//        dataList.add(
//            ProductListData(
//
//                2,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","3화.타코야끼를 먹다.","조회수13만회","19.03.27")
//        )
//
//        dataList.add(
//            ProductListData(
//
//                3,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","4화.문어숙회를 먹다.","조회수13만회","19.03.28")
//        )
//
//        dataList.add(
//            ProductListData(
//
//                4,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","5화.문어빵을 먹다.","조회수13만회","19.03.29")
//        )
//
//        dataList.add(
//            ProductListData(
//
//                5,"http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","6화.배부른 문어","조회수13만회","19.03.30")
//        )


        productListRecyclerViewAdpater= ProductListRecyclerViewAdpater(this!!,dataList)
        rv_.adapter=productListRecyclerViewAdpater
        rv_.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        getEpisodeListResponse()

    }


    private fun getEpisodeListResponse() {

        var webtoonIdx=intent.getIntExtra("idx",0)
     val getEpisodeListResponse = networkService.getEpisodeListResponse(
         "application/json",webtoonIdx)

        getEpisodeListResponse.enqueue(object: retrofit2.Callback<GetEpisodeListResponse>{
            override fun onFailure(call: Call<GetEpisodeListResponse>, t: Throwable) {
                Log.e("WebtoonList Failed",t.toString())
            }

            override fun onResponse(
                call: Call<GetEpisodeListResponse>,
                response: Response<GetEpisodeListResponse>) {
                if(response.isSuccessful){
                    if(response.body()!!.status==200) {
                        val tmp:ArrayList<ProductListData> = response.body()!!.data!!
                        productListRecyclerViewAdpater.dataList=tmp
                        productListRecyclerViewAdpater.notifyDataSetChanged()
                    }
                }
            }

        })
    }
}
