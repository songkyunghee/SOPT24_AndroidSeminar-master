package org.sopt24.dshyun0226.androidseminar.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_review.*
import kotlinx.android.synthetic.main.toolbar_review.*
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ProductReviewRecyclerViewAdapter
import org.sopt24.dshyun0226.androidseminar.data.ProductReveiwData

class ReviewActivity : AppCompatActivity() {

    lateinit var productReviewRecyclerViewAdapter: ProductReviewRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        btn_toolbar_review_back.setOnClickListener{
            finish()
        }

        btn_review_write.setOnClickListener {
            val intent: Intent=Intent(this, ReviewWriteActivity::class.java)
            startActivity(intent)
        }

        
        var dataList: ArrayList<ProductReveiwData> = ArrayList()
        dataList.add(
            ProductReveiwData(
                0,
                //0,0,
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","솝러버","19.03.25 23.21.38","문어에 대한 내용이 아주 유익하네요.\n추천드려요! 다들 꼭 보시길~^^"
            )
        )
        dataList.add(
            ProductReveiwData(
                1,
                //0,0,
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","솝맘","19.03.25 23.21.38","타코야끼가 생각나는 웹툰이에요:)\n타코야끼 먹으면서 읽는거 추천~!"
            )
        )
        dataList.add(
            ProductReveiwData(
                2,
                //0,0,
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","조총무","19.03.25 23.21.38","심심할때 할게 없다면 이 웹툰을\n읽어보세여!!_맑고 깨끗한 조총무"
            )
        )
        dataList.add(
            ProductReveiwData(
                3,
                //0,0,
                "http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png","김스윗","19.03.25 23.21.38","감동적인 이야기 입니다...아주 스윗한\n웹툰이네요ㅠㅋㅋㅋㅋㅋㅋ"
            )
        )

        productReviewRecyclerViewAdapter= ProductReviewRecyclerViewAdapter(this, dataList)
        rv_3.adapter=productReviewRecyclerViewAdapter
        rv_3.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
    }
}
