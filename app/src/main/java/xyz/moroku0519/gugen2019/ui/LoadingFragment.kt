package xyz.moroku0519.gugen2019.ui

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_loading.view.*
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

class LoadingFragment : Fragment() {

    private val args: LoadingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_loading, container, false).apply {
            loading.addAnimatorListener(startEndAnimatorListener)
            loading.setAnimation(R.raw.water)
            loading.setAnimation(
                when (args.girlStatus) {
                    GirlStatus.POOR_SUNLIGHT -> R.raw.sunlight
                    GirlStatus.POOR_WATER -> R.raw.water
                    else -> throw IllegalArgumentException("IllegalGirlStatus:" + args.girlStatus.toString())
                }
            )
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.loading.playAnimation()
    }

    private val View.startEndAnimatorListener: StartEndAnimatorListener
        get() = StartEndAnimatorListener(
            {
                loading.startAnimation(
                    AnimationUtils.loadAnimation(
                        requireContext(),
                        R.anim.fade_in
                    )
                )
            },
            {
                loading.startAnimation(
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