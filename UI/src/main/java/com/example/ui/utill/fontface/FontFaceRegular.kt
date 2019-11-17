package com.example.ui.utill.fontface

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.ui.R

class FontFaceRegular: TextView {


    constructor(context: Context,attrs:AttributeSet):super(context,attrs){
        createView(context)
    }

    fun createView( context: Context){
        gravity = Gravity.CENTER
        val typeFaca = ResourcesCompat.getFont(context , R.font.fontawesomeregular)
        setTypeface(typeFaca)
    }
}