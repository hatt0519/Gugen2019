package xyz.moroku0519.gugen2019.data.entity

import xyz.moroku0519.gugen2019.data.dto.GirlRequest

class Girl(
    val id: Int = 0,
    private val status: Int = 0,
    val loveParameter: Int = 0
) {
    val girlStatus: GirlStatus
        get() = GirlStatus.fromId(status)

    val girlRequest: GirlRequest = GirlRequest(id, status, loveParameter)

    fun updateGirlFromLoveParameter(loveParameter: Int): Girl = Girl(id, status, loveParameter)

}