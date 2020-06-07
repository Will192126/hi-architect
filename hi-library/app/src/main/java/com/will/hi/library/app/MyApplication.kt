package com.will.hi.library.app

import android.app.Application
import com.alibaba.fastjson.JSON
import com.will.hi.library.hilibrary.log.HiConsolePrinter
import com.will.hi.library.hilibrary.log.HiFilePrinter
import com.will.hi.library.hilibrary.log.HiLogConfig
import com.will.hi.library.hilibrary.log.HiLogManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        HiLogManager.init(object: HiLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> JSON.toJSONString(src) }
            }

            override fun getGlobalTag(): String {
                return "MyApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        },
            HiConsolePrinter(),
        HiFilePrinter.getInstance(getExternalFilesDir(null)!!.canonicalPath + "/hilog", 1000))
    }
}