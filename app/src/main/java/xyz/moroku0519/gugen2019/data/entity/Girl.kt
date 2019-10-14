package xyz.moroku0519.gugen2019.data.entity

import com.google.gson.annotations.SerializedName

class Girl(
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    private val status: Int,
    @SerializedName("love_parameter")
    val loveParameter: Int
) {

    val girlStatus: GirlStatus
        get() = GirlStatus.fromId(status)
}