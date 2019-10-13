package xyz.moroku0519.gugen2019.data

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CommandRepositoryImpl : CommandRepository {
    // TODO: applicationでひとつだけもたせるようにしたい
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val ref: DatabaseReference = firebaseDatabase.getReference("isWaterNeed")
    override fun sendWater() {
        ref.setValue(true)
    }

    override fun sendSunLight() {
    }
}