package com.example.bliss.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.bliss.R

fun openFragment(context: FragmentActivity, instanceFragment: Fragment){
    val fragmentTransaction = context.supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.replace_fragment, instanceFragment).addToBackStack(null).commit()
}