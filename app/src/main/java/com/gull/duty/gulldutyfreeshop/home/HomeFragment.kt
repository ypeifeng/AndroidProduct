package com.gull.duty.gulldutyfreeshop.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.gull.duty.gulldutyfreeshop.R
import com.gull.duty.gulldutyfreeshop.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}


class HomeAdapter(layoutId:Int,dataList:ArrayList<Bean>) : BaseQuickAdapter<Bean, BaseViewHolder>(layoutId,dataList) {

    override fun convert(helper: BaseViewHolder?, item: Bean?) {

    }

}


data class Bean(var name:String,var age:Int)
