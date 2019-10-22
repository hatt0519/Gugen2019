package xyz.moroku0519.gugen2019.ui

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_loading.view.*
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

class LoadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_loading, container, false).apply {
            water.addAnimatorListener(startEndAnimatorListener)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.water.playAnimation()
    }

    private val View.startEndAnimatorListener: StartEndAnimatorListener
        get() = StartEndAnimatorListener(
            {
                water.startAnimation(
                    AnimationUtils.loadAnimation(
                        requireContext(),
                        R.anim.fade_in
                    )
                )
            },
            {
                water.startAnimation(
                    AnimationUtils.loadAnimation(
                        requireContext(),
                        R.anim.fade_out
                    )
                )
                findNavController().navigate(
                    LoadingFragmentDirections.actionLoadingToPlantStatus().apply {
                        girlStatus = GirlStatus.GOOD
                    })
            }
        )

    private class StartEndAnimatorListener(
        private val onAnimationStart: () -> Unit,
        private val onAnimationEnd: () -> Unit
    ) : Animator.AnimatorListener {
        override fun onAnimationRepeat(p0: Animator?) {
        }

        override fun onAnimationEnd(p0: Animator?) {
            onAnimationEnd()
        }

        override fun onAnimationCancel(p0: Animator?) {
        }

        override fun onAnimationStart(p0: Animator?) {
            onAnimationStart()
        }
    }
}