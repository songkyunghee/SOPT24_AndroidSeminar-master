package org.sopt24.dshyun0226.androidseminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import org.sopt24.dshyun0226.androidseminar.fragment.AllProductMainFragment
import org.sopt24.dshyun0226.androidseminar.fragment.EndProductMainFragment
import org.sopt24.dshyun0226.androidseminar.fragment.NewProductMainFragment

class ProductMainPagerAdapter (fm:FragmentManager,private val num_fragment:Int) : FragmentStatePagerAdapter(fm) {
    companion object {
        private var allProductMainFragment: AllProductMainFragment?=null
        private var newProductMainFragment: NewProductMainFragment?=null
        private var endProductMainFragment: EndProductMainFragment?=null

        fun getAllProductMainFragment() : AllProductMainFragment {
        if(allProductMainFragment==null) allProductMainFragment= AllProductMainFragment()
        return allProductMainFragment!!

    }
        fun getNewProductMainFragment() : NewProductMainFragment {
            if(newProductMainFragment==null) newProductMainFragment= NewProductMainFragment()
            return newProductMainFragment!!

        }

        fun getEndProductMainFragment() : EndProductMainFragment {
            if(endProductMainFragment==null) endProductMainFragment= EndProductMainFragment()
            return endProductMainFragment!!

        }

    }



    override fun getItem(p0: Int): Fragment? {
        return when(p0) {
            0-> AllProductMainFragment()
            1->EndProductMainFragment()
            2->NewProductMainFragment()
            else->null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }

}