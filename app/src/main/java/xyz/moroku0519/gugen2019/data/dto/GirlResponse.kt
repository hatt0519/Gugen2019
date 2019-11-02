package xyz.moroku0519.gugen2019.data.dto

import androidx.annotation.Keep
import xyz.moroku0519.gugen2019.data.entity.Girl

@Keep
class GirlResponse(
    val id: Int,
    val status: Int,
    val loveParameter: Int
) {
    fun toGirl(): Girl = Girl(id, status, loveParameter)
}