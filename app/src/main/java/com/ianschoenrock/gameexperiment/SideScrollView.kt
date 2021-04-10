package com.ianschoenrock.gameexperiment

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView


class SideScrollView(context: Context, attr: AttributeSet): AppCompatImageView(context, attr){


    init {
        println(drawable)
    }

    override fun onDraw(canvas: Canvas) {

        val bitmap = (drawable as BitmapDrawable).bitmap
        canvas.drawBitmap(bitmap, 10f, 10f, null)
        val animator = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 1000L
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Float
            val width = this.width.toFloat()
            val translationX = width * -progress
            this.translationX = translationX
            this.translationX = translationX + width
        }
        animator.start()
    }



}