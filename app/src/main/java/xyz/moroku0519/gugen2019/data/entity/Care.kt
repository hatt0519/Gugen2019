package xyz.moroku0519.gugen2019.data.entity

import com.google.gson.Gson
import java.time.LocalDateTime

sealed class Care(
    val id: Int,
    val name: String,
    val isEnabled: Boolean
) {
    val timestamp: String = LocalDateTime.now().toString()

    fun toJson(): String = Gson().toJson(this)
    class WaterCare(isEnabled: Boolean) : Care(id = 1, name = "water", isEnabled = isEnabled)
    class SunlightCare(isEnabled: Boolean) : Care(id = 2, name = "sunlight", isEnabled = isEnabled)
}