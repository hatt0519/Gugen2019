package xyz.moroku0519.gugen2019.data

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import xyz.moroku0519.gugen2019.data.entity.Care

class CommandRepositoryImpl : CommandRepository {
    // TODO: applicationでひとつだけもたせるようにしたい
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val reference: DatabaseReference = firebaseDatabase.reference

    override fun sendWater() {
        val water = Care.WaterCare(true)
        reference.child("care").setValue(water.toJson())
    }

    override fun sendSunLight() {
        firebaseDatabase.getReference("isSunlightNeed").setValue(true)
    }
}