package xyz.moroku0519.gugen2019.data.entity

import androidx.annotation.DrawableRes
import xyz.moroku0519.gugen2019.R

enum class GirlStatus(val id: Int, @DrawableRes val drawableId: Int, val message: String) {
    // TODO: セリフはローカルで管理しないほうがいい気がする。ボキャブラリを追加しにくい。
    GOOD(0, R.drawable.good, "ありがとう！"),
    POOR_WATER(1, R.drawable.bad, "お水が欲しいよ〜"),
    POOR_SUNLIGHT(2, R.drawable.bad, "日光浴したい〜"),
    NORMAL(3, R.drawable.normal, "ご機嫌いかが？");

    companion object {
        // TODO: 対応するidがクライアントとサーバでバラバラ管理なのを何とかする
        fun fromId(id: Int): GirlStatus =
                when (id) {
                    0 -> GOOD
                    1 -> POOR_WATER
                    2 -> POOR_SUNLIGHT
                    3 -> NORMAL
                    else -> throw IllegalArgumentException("illegalId")
                }
    }
}