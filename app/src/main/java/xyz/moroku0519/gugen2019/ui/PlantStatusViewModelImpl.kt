package xyz.moroku0519.gugen2019.ui

import android.app.Application
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Transformations
import androidx.navigation.findNavController
import xyz.moroku0519.gugen2019.GugenApplication
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.data.CommandRepository
import xyz.moroku0519.gugen2019.data.CommandRepositoryImpl
import xyz.moroku0519.gugen2019.data.GirlsRepository
import xyz.moroku0519.gugen2019.data.GirlsRepositoryImpl
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

class PlantStatusViewModelImpl(application: Application) : PlantStatusViewModel,
    AndroidViewModel(application), LifecycleObserver {
    private val commandRepository: CommandRepository = CommandRepositoryImpl()
    private val girlsRepository: GirlsRepository = GirlsRepositoryImpl()
    override val plantStatus: MutableLiveData<GirlStatus> = MutableLiveData()
    override val girlImage: LiveData<Drawable> = Transformations.map(plantStatus) {
        ContextCompat.getDrawable(getApplication<GugenApplication>(), it.drawableId)
    }
    override val isWaterButtonVisible: LiveData<Boolean> = MutableLiveData(true)
    override val isSunlightButtonVisible: LiveData<Boolean> = MutableLiveData(false)
    override val loveMeterParameter: LiveData<Float> = MutableLiveData(4.0f)
    override val message: LiveData<String> = Transformations.map(plantStatus) {
        it.message
    }

    override fun onWaterButtonClick(v: View) {
        v.findNavController().navigate(R.id.action_plant_status_to_water)
        commandRepository.sendWater()
    }

    override fun onSunlightButtonClick(v: View) {
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    fun loadGirl() {
        // TODO:本当は一発でLiveData変換したい...
        girlsRepository.loadGirl(
            { girl -> plantStatus.postValue(girl.girlStatus) },
            { e -> Log.e("error", e?.message) }
        )
    }
}