package com.example.bliss.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bliss.R
import com.example.bliss.core.openFragment
import com.example.bliss.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(this, MainFragment())
    }
}