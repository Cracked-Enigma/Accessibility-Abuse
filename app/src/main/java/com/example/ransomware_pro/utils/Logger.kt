package com.example.ransomware_pro.utils

import android.util.Log

class Logger {
    companion object {
        const val LOG_TAG="LEG_RICK"
        val isDebug:Boolean=true;

        fun error(error:String){
            if(!isDebug)
                return
            Log.e(Companion.LOG_TAG,error);
        }

        fun debug(msg:String){
            if(!isDebug)
                return
            Log.d(LOG_TAG,msg);
        }

        fun info(msg: String){
            if(!isDebug)
                return
            Log.i(LOG_TAG,msg);
        }
    }
}