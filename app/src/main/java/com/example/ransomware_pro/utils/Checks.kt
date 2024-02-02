package com.example.ransomware_pro.utils

import android.content.Context
import android.content.Context.BATTERY_SERVICE
import android.os.BatteryManager
import android.provider.Settings


class Checks {
    companion object{

        fun isDeveloperModeOn(context:Context):Boolean{
            return Settings.Secure.getInt(context.contentResolver,Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED)==1;
        }

        fun isUsbDebuggingOn(context: Context):Boolean{
            return Settings.Secure.getInt(context.contentResolver,Settings.Secure.ADB_ENABLED)==1;
        }

        fun getBattery(context: Context):Int{
            val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager
            return bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        }



    }
}