package xyz.moroku0519.gugen2019.ui

import android.app.Application
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
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
import xyz.moroku0519.gugen2019.data.entity.Care
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

class PlantStatusViewModelImpl(application: Application) : PlantStatusViewModel,
        AndroidViewModel(application), LifecycleObserver {
    private val commandRepository: CommandRepository = CommandRepositoryImpl()
    private val girlsRepository: GirlsRepository = GirlsRepositoryImpl()
    override val isDebugMode: MutableLiveData<Boolean> = MutableLiveData(false)
    override val debugGirlStatusList: List<String> = GirlStatus.values().map { it.name }

    override val debugGirlStatusId: MutableLiveData<Int> = MutableLiveData(GirlStatus.NORMAL.ordinal)
    override val plantStatus: MutableLiveData<GirlStatus> = MediatorLiveData<GirlStatus>().also { result ->
        result.addSource(debugGirlStatusId) { id ->
            result.postValue(GirlStatus.fromId(id))
        }
    }
    override val debugPlantStatus: LiveData<GirlStatus> = Transformations.map(debugGirlStatusId) { id ->
        GirlStatus.fromId(id)
    }
    override val girlImage: LiveData<Drawable> = Transformations.map(plantStatus) {
        ContextCompat.getDrawable(getApplication<GugenApplication>().applicationContext, it.drawableId)
    }

    override val isButtonVisible: LiveData<Boolean> = Transformations.map(plantStatus) { status ->
        status == GirlStatus.POOR_SUNLIGHT || status == GirlStatus.POOR_WATER
    }
    override val loveMeterParameter: MutableLiveData<Int> = MutableLiveData()
    override val message: LiveData<String> = Transformations.map(plantStatus) {
        it.message
    }

    override val buttonLabel: LiveData<String> = Transformations.map(plantStatus) { status ->
        when (status) {
            GirlStatus.POOR_WATER -> getApplication<GugenApplication>().applicationContext.getString(R.string.give_water)
            GirlStatus.POOR_SUNLIGHT -> getApplication<GugenApplication>().applicationContext.getString(R.string.give_sunlight)
            else -> ""
        }
    }

    override val isEffect: MutableLiveData<Boolean> = MutableLiveData(false)

    override fun updatePlantStatus(girlStatus: GirlStatus) {
        plantStatus.value = girlStatus
        debugGirlStatusId.postValue(girlStatus.id)
    }

    override fun updateLoveParameter() {
        plantStatus.value?.let { status ->
            when (status) {
                GirlStatus.GOOD -> {
                    loveMeterParameter.postValue(
                        loveMeterParameter.value?.plus(1)
                    )
                    isEffect.value = true
                }
                else -> {
                    // do noting
                }
            }
        }
    }

    override fun onButtonClick(v: View) {
        plantStatus.value?.let { status ->
            when (status) {
                GirlStatus.POOR_SUNLIGHT -> status.navigateTo(v, Care.SunlightCare(true))
                GirlStatus.POOR_WATER -> status.navigateTo(v, Care.WaterCare(true))
                else -> return
            }
        }
    }

    override fun onDebugButtonClick(v: View): Boolean {
        isDebugMode.postValue(!isDebugMode.value!!)
        return true
    }

    private fun GirlStatus.navigateTo(v: View, care: Care) {
        v.findNavController()
                .navigate(
                    PlantStatusFragmentDirections
                            .actionPlantStatusToLoading()
                            .also { actionPlantStatusToLoading ->
                                actionPlantStatusToLoading.girlStatus = this
                            }
                )
        commandRepository.send(care)
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    fun loadGirl() {
        // TODO:本当は一発でLiveData変換したい...
        girlsRepository.loadGirl(
            { girl ->
                plantStatus.postValue(girl.girlStatus)
                loveMeterParameter.postValue(girl.loveParameter)
            },
            { e -> Log.e("error", e?.message) }
        )
    }

    companion object {
        @JvmStatic
        @BindingAdapter("isVisible")
        fun View.isVisible(isVisible: Boolean) {
            visibility = when (isVisible) {
                true -> View.VISIBLE
                false -> View.GONE
            }
        }
    }
}