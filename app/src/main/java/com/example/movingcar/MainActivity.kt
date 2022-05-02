package com.example.movingcar

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ArcMotion
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.movingcar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var toRightAnimation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animateCarMovement()
    }

    private fun animateCarMovement() {
        binding.carImageView.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = ANIM_DURATION
            TransitionManager.beginDelayedTransition(binding.container, changeBounds)
            toRightAnimation = !toRightAnimation
            val params = binding.carImageView.layoutParams as FrameLayout.LayoutParams
            params.gravity = if (toRightAnimation) Gravity.END or Gravity.BOTTOM else Gravity.START or Gravity.TOP
            binding.carImageView.layoutParams = params
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val ANIM_DURATION = 10000L
    }
}