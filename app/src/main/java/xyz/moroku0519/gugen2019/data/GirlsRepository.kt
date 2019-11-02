package xyz.moroku0519.gugen2019.data

import xyz.moroku0519.gugen2019.data.dto.GirlRequest
import xyz.moroku0519.gugen2019.data.dto.GirlResponse

interface GirlsRepository {
    fun loadGirl(onSuccess: (girl: GirlResponse) -> Unit, onError: (e: Exception?) -> Unit)
    fun updateGirl(girl: GirlRequest, onSuccess: () -> Unit, onError: (e: Exception?) -> Unit)
}