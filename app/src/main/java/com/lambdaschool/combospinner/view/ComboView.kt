package com.lambdaschool.combospinner.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.lambdaschool.combospinner.R

class ComboView: LinearLayout {

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)


    init {
        /*val text = TextView(context)
        addView(text)*/

        val textView = LayoutInflater.from(context).inflate(R.layout.comboview_layout, this, false) as TextView
        textView.text = "Sample Text"

        val previousImageView = ImageView(context)
        previousImageView.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_previous))

        val nextImageView = ImageView(context)
        nextImageView.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_next))

        orientation = HORIZONTAL
        addView(previousImageView)
        addView(nextImageView)
        addView(textView)
    }
}