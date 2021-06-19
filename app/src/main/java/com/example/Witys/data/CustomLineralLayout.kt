package com.example.Witys.data

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class CustomLineralLayout(context: Context, scroll:Boolean): LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {
    val my_scroll = scroll


    override fun canScrollVertically(): Boolean {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return  my_scroll
    }
}