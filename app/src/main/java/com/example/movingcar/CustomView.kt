package com.example.movingcar

import android.content.Context
import android.graphics.*
import android.view.View

class CustomView(context: Context) : View(context) {

    private val paint: Paint = Paint()
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_car_small)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            style = Paint.Style.FILL_AND_STROKE
            color = Color.WHITE
        }
        canvas?.drawPaint(paint)
        canvas?.drawBitmap(bitmap, 20.toFloat(), 1050.toFloat(), paint)
    }
}