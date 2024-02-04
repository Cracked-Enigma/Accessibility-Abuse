package com.example.ransomware_pro.controller

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class PermCont(ctx: Context) {

    val context:Context
    init {
        this.context=ctx
    }
    fun checkPerm(perm:String):Boolean{
        return context.checkSelfPermission(perm)==PackageManager.PERMISSION_GRANTED;
    }
    fun askPermission(perm: String,activity: Activity){
        val arr = Array<String>(1){perm}
        ActivityCompat.requestPermissions(activity,arr,1001);
    }

}