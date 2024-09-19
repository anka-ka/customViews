package ru.netology.statsview

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.TransitionManager
import ru.netology.statsview.ui.StatsView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val view = findViewById<StatsView>(R.id.startsView)
            view.data = listOf(
            500F,
            500F,
            500F,
            500F,

        )

        val root = findViewById<ViewGroup>(R.id.root)

        val scene = Scene.getSceneForLayout(root, R.layout.end_scene, this)

        findViewById<View>(R.id.goButton).setOnClickListener{
            TransitionManager.go(scene)
        }

        val textView = findViewById<TextView>(R.id.label)

        val viewAnim = AnimationUtils.loadAnimation(this, R.anim.animation).apply {
                setAnimationListener(object: Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {
                        textView.text = "onAnimationStart"
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        textView.text = "onAnimationEnd"
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                        textView.text = "onAnimationRepeat"
                    }

                })
            }

        view.startAnimation(viewAnim)
    }
}