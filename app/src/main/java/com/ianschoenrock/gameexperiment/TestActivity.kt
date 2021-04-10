package com.ianschoenrock.gameexperiment

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class TestActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")

//Just try animating a background image and go from there
    private var started = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val backgroundOne = findViewById<View>(R.id.background_one) as ImageView
        val backgroundTwo = findViewById<View>(R.id.background_two) as ImageView
        val goButton = findViewById<Button>(R.id.go_btn)

        val animator = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 1000L
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Float
            val width = backgroundOne.width.toFloat()
            val translationX = width * -progress
            backgroundOne.translationX = translationX
            backgroundTwo.translationX = translationX + width
        }

        goButton.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    if(!started){
                        started = true
                        animator.start()
                    } else{
                        animator.resume()
                    }
                    true
                }MotionEvent.ACTION_UP ->{
                animator.pause()
                    true
                }
                else ->{
                    false
                }
            }
        }


    }
}

