package xyz.moroku0519.gugen2019.data

import com.google.firebase.database.FirebaseDatabase

class CommandRepositoryImpl : CommandRepository {
    // TODO: applicationでひとつだけもたせるようにしたい
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun sendWater() {
        firebaseDatabase.getReference("isWaterNeed").setValue(true)
    }

    override fun sendSunLight() {
        firebaseDatabase.getReference("isSunlightNeed").setValue(true)
    }
}