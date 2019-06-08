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
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.activity.PageActivity
import org.sopt24.dshyun0226.androidseminar.activity.ProductActivity
import org.sopt24.dshyun0226.androidseminar.data.ProductListData

class ProductListRecyclerViewAdpater (val ctx: Context, var dataList:ArrayList<ProductListData>) : RecyclerView.Adapter<ProductListRecyclerViewAdpater.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View= LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_list, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int=dataList.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        Glide.with(ctx)
            .load(dataList[p1].episodeThumnail)
            .into(p0.img_thumbnail)
        p0.title.text= dataList[p1].episodeTitle
        p0.number.text= dataList[p1].episodeView.toString()
        p0.date.text= dataList[p1].episodeDate

        p0.container.setOnClickListener {
            val intent: Intent = Intent(ctx, PageActivity::class.java)
            intent.putExtra("idx",dataList[p1].episodeIdx)
            intent.putExtra("title",dataList[p1].episodeTitle)
            ctx.startActivity(intent)
        }


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var container = itemView.findViewById(R.id.rv_container_product_list) as LinearLayout
        var img_thumbnail=itemView.findViewById(R.id.rv_img_product_list) as ImageView
        var title=itemView.findViewById(R.id.rv_txt_title_list) as TextView
        var number=itemView.findViewById(R.id.rv_txt_number_list) as TextView
        var date=itemView.findViewById(R.id.rv_txt_date_list) as TextView
    }
}