package xyz.moroku0519.gugen2019

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_plant_status.view.*

class PlantStatusFragment : NavHostFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_plant_status, container, false).apply {
            this.rainy.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(p0: Animator?) {
                }

                override fun onAnimationEnd(p0: Animator?) {
                    this@apply.rainy.startAnimation(
                        AnimationUtils.loadAnimation(requireContext(), R.anim.fade_out)
                    )
                    message.text = "ありがとう！！"
                }

                override fun onAnimationCancel(p0: Animator?) {
                }

                override fun onAnimationStart(p0: Animator?) {
                    this@apply.rainy.startAnimation(
                        AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
                    )
                }
            })
            this.send.setOnClickListener {
                this.rainy.playAnimation()
            }
        }
}

