package com.lambdaschool.combospinner.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MovingBox(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val rect = Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var diffX: Float = 0f
    private var diffY: Float = 0f

    init {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_UP-> {
                diffX = event.x - startX
                diffY = event.y - startY
            }
            MotionEvent.ACTION_MOVE -> {

            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
//        int 1
//        float 1f, 1.0f
//        double 1.0
//        long 1L


        rect.left = (width * .1 + diffX).toInt()
        rect.right = (width * .75 + diffX).toInt()
        rect.top = (height * .25 + diffY).toInt()
        rect.bottom = (height * .9 + diffY).toInt()


        paint.color = Color.MAGENTA
//        canvas?.drawRect(rect, paint)

        canvas?.drawCircle(width/2.0f, height/2f, 500f, paint)


        super.onDraw(canvas)
    }
}