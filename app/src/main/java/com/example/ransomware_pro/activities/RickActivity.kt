package com.example.ransomware_pro.activities

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.ransomware_pro.databinding.ActivityRickBinding
import com.example.ransomware_pro.controller.PermCont

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class RickActivity : AppCompatActivity() {
//    companion object {
//        init {
//            System.loadLibrary("ransomware_pro")
//        }
//    }
    val perm:PermCont
    init {
        perm= PermCont(this)
    }
    private lateinit var binding: ActivityRickBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.killBtn.setOnClickListener {
            killApp();
        }

        askPermission()

//        val arr = Array<String>(1){perm}
//        ActivityCompat.requestPermissions(context as Activity,arr,1001);
    }
    fun askPermission(){
        //storage
        val camPerm=android.Manifest.permission.CAMERA
        val res=perm.checkPerm(camPerm)
        if(!res){
            perm.askPermission(camPerm,this)
        }
    }
    external fun killApp()
}