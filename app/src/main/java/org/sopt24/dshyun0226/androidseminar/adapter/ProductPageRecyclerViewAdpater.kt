package org.sopt24.dshyun0226.androidseminar.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.activity.PageActivity
import org.sopt24.dshyun0226.androidseminar.data.ProductListData
import org.sopt24.dshyun0226.androidseminar.data.ProductPageData

class ProductPageRecyclerViewAdpater (val ctx: Context, var dataList:ArrayList<ProductPageData>) : RecyclerView.Adapter<ProductPageRecyclerViewAdpater.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View= LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_page, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int=dataList.size

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.talk.text=dataList[p1].talk


    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var container = itemView.findViewById(R.id.rv_container_page) as LinearLayout
        var talk=itemView.findViewById(R.id.rv_txt_product_page) as TextView

    }
}