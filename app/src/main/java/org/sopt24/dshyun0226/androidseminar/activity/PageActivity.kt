package org.sopt24.dshyun0226.androidseminar.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_page.*
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_page.*
import kotlinx.android.synthetic.main.toolbar_product.*
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ProductListRecyclerViewAdpater
import org.sopt24.dshyun0226.androidseminar.adapter.ProductPageRecyclerViewAdpater
import org.sopt24.dshyun0226.androidseminar.data.ProductListData
import org.sopt24.dshyun0226.androidseminar.data.ProductPageData

class PageActivity : AppCompatActivity() {

    lateinit var productPageRecyclerViewAdpater: ProductPageRecyclerViewAdpater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

//        var title   = intent.getStringExtra("title")
//        txt_toolbar_product_title.text= title

        btn_toolbar_page_like.setOnClickListener {
            val intent: Intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        btn_toolbar_page_back.setOnClickListener{
            finish()
        }

        var dataList: ArrayList<ProductPageData> = ArrayList()
        dataList.add(
            ProductPageData(

                "무너야 타코야끼 먹으러 갈까?!")
        )

        dataList.add(
            ProductPageData(

                "뭐... 뭘 먹자구...?!")
        )
        dataList.add(
            ProductPageData(

                "시켜??! 그럼 타코와사비는 ???!")
        )
        dataList.add(
            ProductPageData(

                "너진짜... 무서운 아이구나!!!너도 문어자나!!")
        )
        productPageRecyclerViewAdpater= ProductPageRecyclerViewAdpater(this!!, dataList)
        rv_2.adapter=productPageRecyclerViewAdpater
        rv_2.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
    }
}
