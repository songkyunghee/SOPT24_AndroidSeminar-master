package org.sopt24.dshyun0226.androidseminar.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.activity.ProductActivity
import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData

class ProductOverviewRecyclerViewAdpater(val ctx: Context, var dataList: ArrayList<ProductOverviewData>) : RecyclerView.Adapter<ProductOverviewRecyclerViewAdpater.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder { //어떤 layout을 사용할지
        val view: View=LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_overview, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int=dataList.size  //총 item(view)의 수는 몇 개인지?



    override fun onBindViewHolder(p0: Holder, p1: Int) { //어떤 작업을 수행할 것인지?
        Glide.with(ctx)
            .load(dataList[p1].webtoonThumnail)
            .into(p0.img_thumbnail)
        p0.title.text=dataList[p1].webtoonTitle
        p0.num_like.text="♥"+dataList[p1].webtoonLike.toString()
        p0.author.text=dataList[p1].webtoonArtist

        p0.container.setOnClickListener{
            ctx.startActivity<ProductActivity>(
                "idx" to dataList[p1].webtoonIdx,
                "title" to dataList[p1].webtoonTitle

            )

//            val intent: Intent =Intent(ctx, ProductActivity::class.java)
//            intent.putExtra("idx",p1+1)
//            intent.putExtra("title",dataList[p1].webtoonTitle)
//            ctx.startActivity(intent)
        }

    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.ll_rv_item_product_overview_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_overview_thumbnail) as ImageView
        var title=itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var num_like=itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
        var author=itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
    }
}