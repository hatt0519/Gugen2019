package xyz.moroku0519.gugen2019.data

import androidx.annotation.DrawableRes
import xyz.moroku0519.gugen2019.R

enum class GirlStatus(@DrawableRes val drawableId: Int, val message: String) {
    GOOD(R.drawable.good, "ありがとう！"),
    BAD(R.drawable.bad, "お水が欲しいよ〜"),
    NORMAL(R.drawable.normal, "ご機嫌いかが？")
}