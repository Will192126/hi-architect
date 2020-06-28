package com.will.hi_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.will.hi_ui.demo.tab.WiTabBottomDemoActivity
import com.will.ui.tab.bottom.HiTabBottom
import com.will.ui.tab.bottom.HiTabBottomInfo

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTabBottomDemo = findViewById<TextView>(R.id.tab_bottom_demo)
        tvTabBottomDemo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tab_bottom_demo -> {
                startActivity(Intent(this, WiTabBottomDemoActivity::class.java))
            }
        }
    }
}
