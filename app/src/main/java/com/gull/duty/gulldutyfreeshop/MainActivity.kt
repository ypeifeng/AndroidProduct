package com.gull.duty.gulldutyfreeshop

import android.os.Bundle
import com.gull.duty.baseutils.base.BaseFragmentPagerAdapter
import com.gull.duty.gulldutyfreeshop.base.BaseActivity
import com.gull.duty.gulldutyfreeshop.base.BaseFragment
import com.gull.duty.gulldutyfreeshop.home.HomeFragment
import com.gull.duty.gulldutyfreeshop.mine.MineFragment
import com.gull.duty.gulldutyfreeshop.order.OrderFragment
import com.gull.duty.gulldutyfreeshop.service.ServiceFragment
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : BaseActivity() {

    lateinit var pagerAdapter:BaseFragmentPagerAdapter<BaseFragment>

    var fragmentList:ArrayList<BaseFragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        initEvent()
    }

    private fun initEvent() {
        rgMine.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                this.rbMainHome.id -> selectFragment(0)
                this.rbMainOrder.id -> selectFragment(1)
                this.rbMainService.id -> selectFragment(2)
                this.rbMainMine.id -> selectFragment(3)
            }
        }
    }

    private fun initView() {

        fragmentList.add(HomeFragment())
        fragmentList.add(OrderFragment())
        fragmentList.add(ServiceFragment())
        fragmentList.add(MineFragment())

        pagerAdapter = BaseFragmentPagerAdapter<BaseFragment>(this).initFragments(fragmentList)
        vpMain.adapter = pagerAdapter
        pagerAdapter.notifyDataSetChanged()

    }

    private fun selectFragment(fragmentIndex:Int){
        vpMain.setCurrentItem(fragmentIndex,false)
    }
}

