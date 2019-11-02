package xyz.moroku0519.gugen2019.data.entity

import com.google.gson.annotations.SerializedName

class Girl(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("status")
    private val status: Int = 0,
    @SerializedName("love_parameter")
    val loveParameter: Int = 0
) {

    val girlStatus: GirlStatus
        get() = GirlStatus.fromId(status)

    fun updateGirlFromLoveParameter(loveParameter: Int): Girl = Girl(id, status, loveParameter)
}