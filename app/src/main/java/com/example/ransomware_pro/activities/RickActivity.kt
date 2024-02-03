package com.example.ransomware_pro.activities

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ransomware_pro.databinding.ActivityRickBinding
import com.example.ransomware_pro.R

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
    private lateinit var binding: ActivityRickBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.killBtn.setOnClickListener {
            killApp();
        }
    }
    external fun killApp()
}