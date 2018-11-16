package com.gull.duty.gulldutyfreeshop.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.BarUtils

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.setStatusBarAlpha(this,255)
        BarUtils.setStatusBarLightMode(window,true)

    }
}
