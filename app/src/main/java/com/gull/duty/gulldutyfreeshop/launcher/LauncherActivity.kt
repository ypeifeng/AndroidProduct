package com.gull.duty.gulldutyfreeshop.launcher

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.blankj.utilcode.util.BarUtils
import com.gull.duty.gulldutyfreeshop.R
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {

    private var list: ArrayList<Fragment> = ArrayList()
    private var photoIdList : ArrayList<Int> = ArrayList()
    private lateinit var launchVpAdapter: LaunchVpAdapter

    private var handler: Handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when(msg?.what){
                0x1000000 -> openNavPage()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.setStatusBarVisibility(window,false)
        setContentView(R.layout.activity_launcher)
        init()
        initData()
        initEvent()
    }

    private fun initEvent() {
        handler.sendEmptyMessageDelayed(0x1000000,2000)
    }

    private fun initData() {
        photoIdList.add(R.mipmap.one)
        photoIdList.add(R.mipmap.tow)
        photoIdList.add(R.mipmap.three)
        for (i in this.photoIdList.indices){
            var launcherFragment = LauncherFragment()
            launcherFragment.setImageId(photoIdList[i])
            if (i==this.photoIdList.size-1){
                launcherFragment.setIsLastLauncherImage(true)

            }
            list.add(launcherFragment)
        }
        launchVpAdapter.notifyDataSetChanged()
    }

    private fun init() {
        launchVpAdapter = LaunchVpAdapter(supportFragmentManager, list)
        vpLauncher.adapter = launchVpAdapter
    }

    private fun openNavPage(){
        imgLauncherWelcome.visibility = View.GONE
    }
}


class LaunchVpAdapter(fm : FragmentManager, var list: ArrayList<Fragment>) : FragmentPagerAdapter(fm){

    override fun getItem(p0: Int): Fragment {
        return list[p0]
    }

    override fun getCount(): Int {
        return list.size
    }

}
