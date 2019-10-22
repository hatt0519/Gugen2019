package xyz.moroku0519.gugen2019.data.entity

import java.time.LocalDateTime
import java.util.Locale

sealed class Care(
    private val id: Int,
    private val name: String,
    private val isEnabled: Boolean
) {
    private val timestamp: String = LocalDateTime.now().toString()
    val pathName: String
        // sealed classなので、必ず取得可能
        get() = this::class.java.superclass?.simpleName?.toLowerCase(Locale.JAPAN)!!

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