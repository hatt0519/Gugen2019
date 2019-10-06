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

    private val View.startEndAnimatorListener: StartEndAnimatorListener
        get() = StartEndAnimatorListener(
            {
                this.rainy.startAnimation(
                    AnimationUtils.loadAnimation(requireContext(), R.anim.fade_out)
                )
                message.text = "ありがとう！！"
            },
            {
                this.rainy.startAnimation(
                    AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
                )
            }
        )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_plant_status, container, false).apply {
            this.rainy.addAnimatorListener(startEndAnimatorListener)
            this.send.setOnClickListener {
                this.rainy.playAnimation()
            }
        }

    private class StartEndAnimatorListener(
        private val onAnimationStart: () -> Unit,
        private val onAnimationEnd: () -> Unit
    ) : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            onAnimationStart()
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
            onAnimationEnd()
        }
    }

}

