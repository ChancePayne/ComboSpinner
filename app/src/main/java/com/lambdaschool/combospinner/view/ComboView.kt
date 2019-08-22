package com.lambdaschool.combospinner.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.lambdaschool.combospinner.R

class ComboView(context: Context, attrs: AttributeSet?): LinearLayout(context, attrs) {

    constructor(context: Context): this(context, null)

//    constructor(context: Context, attrs: AttributeSet): super(context, attrs)

//    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

//    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)

    val listItems = listOf("Cat", "o'nine", "tails", "topmast", "loot", "Nelsons", "folly", "code", "of", "conduct", "bilge", "scuppers", "barque","spanker", "warp")
    var pointer = 0
    fun incrementPointer() {
        pointer++
        if(pointer >= listItems.size) {
            pointer = 0
        }
    }
    fun decrementPointer() {
        pointer--
        if(pointer < 0) {
            pointer = listItems.size - 1
        }
    }

    init {
        /*val text = TextView(context)
        addView(text)*/
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ComboView)
        val textWeight = typedArray.getFloat(R.styleable.ComboView_layout_weight, 8f)
        val textSize = typedArray.getDimension(R.styleable.ComboView_textSize, 12f)
        typedArray.recycle()

        val textLayoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, textWeight)
        val textView = LayoutInflater.from(context).inflate(R.layout.comboview_layout, this, false) as TextView
        textView.text = listItems[pointer]
        textView.layoutParams = textLayoutParams
        textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        textView.textSize = textSize


        val imageLayoutParams = LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f)
        val previousImageView = ImageView(context)
        previousImageView.layoutParams = imageLayoutParams
        previousImageView.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_previous))
        previousImageView.setOnClickListener {
            decrementPointer()
            textView.text = listItems[pointer]
        }

        val nextImageView = ImageView(context)
        nextImageView.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_media_next))
        nextImageView.layoutParams = imageLayoutParams
        nextImageView.setOnClickListener {
            incrementPointer()
            textView.text = listItems[pointer]
        }

        orientation = HORIZONTAL
        addView(previousImageView)
        addView(textView)
        addView(nextImageView)
    }
}