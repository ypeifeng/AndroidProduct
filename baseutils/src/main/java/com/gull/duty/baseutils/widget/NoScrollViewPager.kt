package com.gull.duty.baseutils.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent

/**
 *不支持滚动的viewPager
 * */
class NoScrollViewPager(context: Context) : ViewPager(context) {

    // 不拦截这个事件
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return false
    }

    // 不处理这个事件
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return false
    }
}