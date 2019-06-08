package org.sopt24.dshyun0226.androidseminar.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_all_product_main.*

import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ProductOverviewRecyclerViewAdpater
import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.network.ApplicationController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.Post.GetMainProductListResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class AllProductMainFragment : Fragment() {

    lateinit var productOverviewRecyclerViewAdpater: ProductOverviewRecyclerViewAdpater

    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        var dataList: ArrayList<ProductOverviewData> = ArrayList()
//        dataList.add(ProductOverviewData(
//
//            0,"완결작품 1",120,"완결작가 A"))
//        dataList.add(ProductOverviewData(
//
//            1, "완결작품 2", 100, "완결작가 B"))
//        dataList.add(ProductOverviewData(
//
//            2, "완결작품 3", 99, "완결작가 C"))
//        dataList.add(ProductOverviewData(
//
//            3, "완결작품 4", 10, "완결작가 D"))
//        dataList.add(ProductOverviewData(
//
//            4, "완결작품 5", 1, "완결작가 E"))
//        dataList.add(ProductOverviewData(
//
//            5, "완결작품 6", 1, "완결작가 F"))
//        dataList.add(ProductOverviewData(
//
//            6, "완결작품 7", 1, "완결작가 G"))
//        dataList.add(ProductOverviewData(
//
//            7, "완결작품 8", 1, "완결작가 H"))
//        dataList.add(ProductOverviewData(
//
//            8,"신규작품 1",120,"신규작가 A"))
//        dataList.add(
//            ProductOverviewData(
//
//            9, "신규작품 2", 100, "신규작가 B")
//        )
//        dataList.add(ProductOverviewData(
//
//            10, "신규작품 3", 99, "신규작가 C"))
//        dataList.add(ProductOverviewData(
//
//            11, "신규작품 4", 10, "신규작가 D"))
//        dataList.add(ProductOverviewData(
//
//            12, "신규작품 5", 1, "신규작가 E"))
//        dataList.add(ProductOverviewData(
//
//            13, "신규작품 6", 1, "신규작가 F"))
//        dataList.add(ProductOverviewData(
//
//            14, "신규작품 7", 1, "신규작가 G"))
//        dataList.add(ProductOverviewData(
//
//            15, "신규작품 8", 1, "신규작가 H"))

    productOverviewRecyclerViewAdpater= ProductOverviewRecyclerViewAdpater(context!!,dataList)
        rv_product_overview_all.adapter=productOverviewRecyclerViewAdpater
        rv_product_overview_all.layoutManager=GridLayoutManager(context!!, 3) as RecyclerView.LayoutManager?

        getMainProductListResponse()
    }


    private fun getMainProductListResponse()  {
        val getMainProductListResponse = networkService.getMainProductListResponse(
            "application/json",1)
        //이것은 body에 flag 값 만 넣어주면 된다

        getMainProductListResponse.enqueue(object : retrofit2.Callback<GetMainProductListResponse> {
            override fun onFailure(call: Call<GetMainProductListResponse>, t: Throwable) {
                Log.e("ALLMainProductFail",t.toString())
            }

            override fun onResponse(
                call: Call<GetMainProductListResponse>,
                response: Response<GetMainProductListResponse>
            ) {
                if(response.isSuccessful){
                    if(response.body()!!.status==200) {
                        val tmp:ArrayList<ProductOverviewData> = response.body()!!.data!!
                        productOverviewRecyclerViewAdpater.dataList=tmp
                        productOverviewRecyclerViewAdpater.notifyDataSetChanged()//dapater에 표시할 데이터가 변경된 것을 알림
                    }
                }
            }

        })
    }


}
