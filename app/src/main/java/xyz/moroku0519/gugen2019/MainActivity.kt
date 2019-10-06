package xyz.moroku0519.gugen2019

import android.animation.Animator
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rainy.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                rainy.startAnimation(
                    AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_out)
                )
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
                rainy.startAnimation(
                    AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade_in)
                )
            }

        }
        )
        send.setOnClickListener {
            rainy.playAnimation()
        }
    }
}
