package com.will.hi_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.will.hi_ui.tab.bottom.HiTabBottom
import com.will.hi_ui.tab.bottom.HiTabBottomInfo

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabBottom = findViewById<HiTabBottom>(R.id.tab_bottom)

        val homeInfo = HiTabBottomInfo(
            "首页",
            "fonts/iconfont.ttf",
            getString(R.string.if_home),
            null,
            "#ff656667",
            "#ffd44949"
        )
        tabBottom.setHiTabInfo(homeInfo)
    }

    override fun onClick(v: View?) {

    }
}
