package xyz.moroku0519.gugen2019.data

import androidx.annotation.DrawableRes
import xyz.moroku0519.gugen2019.R

interface StatusRepository {
    fun loadGirlStatus(): GirlStatus
    fun loadGirlLoveMeter(): Int

    enum class GirlStatus(@DrawableRes val drawableId: Int) {
        GOOD(R.drawable.good),
        BAD(R.drawable.bad),
        NORMAL(R.drawable.normal)
    }
}