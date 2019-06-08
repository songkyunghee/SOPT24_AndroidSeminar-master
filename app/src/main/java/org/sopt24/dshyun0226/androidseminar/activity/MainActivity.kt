package org.sopt24.dshyun0226.androidseminar.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.adapter.ProductMainPagerAdapter
import org.sopt24.dshyun0226.androidseminar.adapter.SliderMainPagerAdpater

// import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureTitleBar()
        configureMainTab()

       img_toolbar_main_action.setOnClickListener {
           if(SharedPreferenceController.getUserToken(this).isEmpty()) {
               val intent: Intent=Intent(this, LoginActivity::class.java)
               startActivity(intent)
           }
           else{
               SharedPreferenceController.clearUserToken(this)
               configureTitleBar()

           }
       }
    }

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar() {
        if(SharedPreferenceController.getUserToken(this).isEmpty()) {
            img_toolbar_main_action.isSelected=false
        }
        else {
            img_toolbar_main_action.isSelected=true
        }

    }

    private fun configureMainTab() {
        vp_main_product.adapter=ProductMainPagerAdapter(supportFragmentManager,3)
        vp_main_product.offscreenPageLimit=2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main,null,false)

        tl_main_category.getTabAt(0)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView=navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout


        vp_main_slider.adapter= SliderMainPagerAdpater(supportFragmentManager,3)
        vp_main_product.offscreenPageLimit=2
        tl_main_indicator.setupWithViewPager(vp_main_slider)

        val navIndicatorMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_indicator_main,null,false)

        tl_main_indicator.getTabAt(0)!!.customView=navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_1) as ImageView
        tl_main_indicator.getTabAt(1)!!.customView=navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_2) as ImageView
        tl_main_indicator.getTabAt(2)!!.customView=navIndicatorMainLayout.findViewById(R.id.img_nav_indicator_main_3) as ImageView

        tl_main_indicator.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

                p0!!.customView!!.setBackgroundColor(resources.getColor(R.color.colorGray))
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {

                p0!!.customView!!.setBackgroundColor(resources.getColor(R.color.colorPrimaryDarkYellow))
            }


        })
    }
}

