package com.gull.duty.gulldutyfreeshop.launcher


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gull.duty.gulldutyfreeshop.MainActivity
import com.gull.duty.gulldutyfreeshop.R
import kotlinx.android.synthetic.main.fragment_launcher.*


class LauncherFragment : Fragment() {

     var isLastLauncherImage:Boolean = false

     var imageId:Int? = -1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var inflate = inflater.inflate(R.layout.fragment_launcher, container, false)
        return inflate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageId?.let { imgLauncherPhoto.setImageResource(it) }
        if (isLastLauncherImage) btLauncherGo.visibility = View.VISIBLE else btLauncherGo.visibility = View.GONE

        initEvent()
    }

    private fun initEvent() {
        btLauncherGo.setOnClickListener {
            var intent = Intent()
            intent.setClass(activity,MainActivity::class.java)
            activity?.startActivity(intent)
        }
    }

    fun setImageId(imageId:Int){
        this.imageId = imageId
    }

    fun setIsLastLauncherImage(isLastLauncherImage:Boolean){
        this.isLastLauncherImage = isLastLauncherImage
    }
}
