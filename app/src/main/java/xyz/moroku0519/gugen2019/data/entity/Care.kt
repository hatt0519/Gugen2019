package xyz.moroku0519.gugen2019.data.entity

import java.time.LocalDateTime

sealed class Care(
    val id: Int,
    val name: String,
    val isEnabled: Boolean
) {
    val timestamp: String = LocalDateTime.now().toString()
    fun toMap(): Map<String, Any> =
        mapOf(
            "id" to id,
            "name" to name,
            "isEnabled" to isEnabled,
            "timestamp" to timestamp
        )

    class WaterCare(isEnabled: Boolean) : Care(id = 1, name = "water", isEnabled = isEnabled)
    class SunlightCare(isEnabled: Boolean) : Care(id = 2, name = "sunlight", isEnabled = isEnabled)
}