package org.sopt24.dshyun0226.androidseminar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.data.ProductReveiwData

class ProductReviewRecyclerViewAdapter (val ctx: Context,val dataList: ArrayList<ProductReveiwData> ): RecyclerView.Adapter<ProductReviewRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view : View=LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_review,p0,false)
        return Holder(view)
    }

    override fun getItemCount(): Int =dataList.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        Glide.with(ctx)
            .load(dataList[p1].img_url)
            .into(p0.img_url)

        p0.title.text=dataList[p1].title
        p0.date.text=dataList[p1].date
        p0.content.text=dataList[p1].content
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var img_url=itemView.findViewById(R.id.rv_img_product_review) as ImageView
        var title=itemView.findViewById(R.id.rv_txt_title_review) as TextView
        var date=itemView.findViewById(R.id.rv_txt_date_review) as TextView
        var content=itemView.findViewById(R.id.rv_txt_content_review) as TextView
    }

}