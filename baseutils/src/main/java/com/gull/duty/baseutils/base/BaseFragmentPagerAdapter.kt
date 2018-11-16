package com.gull.duty.baseutils.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup

open class BaseFragmentPagerAdapter<T:Fragment> :FragmentPagerAdapter{

    var listFragments:ArrayList<T> = ArrayList()

     var currentFragment:T? = null

    constructor(appCompatActivity: AppCompatActivity):super(appCompatActivity.supportFragmentManager)
    constructor(fragment: Fragment):super(fragment.childFragmentManager)

    public fun initFragments(dataFragment:ArrayList<T>):BaseFragmentPagerAdapter<T>{
        listFragments.clear()
        listFragments.addAll(dataFragment)
        return this
    }

    override fun getCount(): Int {
        return listFragments.size
    }

    override fun getItem(p0: Int): T? {
        return if (p0<listFragments.size) listFragments[p0] else null
    }


    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        if (currentFragment!=`object`){
            currentFragment = `object` as T
        }
        super.setPrimaryItem(container, position, `object`)
    }

}