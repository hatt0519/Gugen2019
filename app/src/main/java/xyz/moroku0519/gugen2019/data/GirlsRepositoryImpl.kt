package xyz.moroku0519.gugen2019.data

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import xyz.moroku0519.gugen2019.data.entity.Girl

class GirlsRepositoryImpl : GirlsRepository {
    private val collectionReference: CollectionReference =
        FirebaseFirestore.getInstance().collection("girls")

    override fun loadGirl(onSuccess: (girl: Girl) -> Unit, onError: (e: Exception?) -> Unit) {
        collectionReference
            .document(GIRL_NAME)
            .get()
            .addOnCompleteListener {
                when (it.isSuccessful) {
                    true -> onSuccess(it.toResult())
                    false -> onError(it.exception)
                }
            }

    }

    override fun loadGirlLoveMeter(): Int = 0


    companion object {
        // TODO: 可変にする
        private const val GIRL_NAME = "minako"
    }

    private inline fun <reified R> Task<DocumentSnapshot>.toResult(): R =
        Gson().fromJson(this.result?.data.toString(), R::class.java)
}