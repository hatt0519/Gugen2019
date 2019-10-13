package xyz.moroku0519.gugen2019.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.data.CommandRepository
import xyz.moroku0519.gugen2019.data.CommandRepositoryImpl
import xyz.moroku0519.gugen2019.data.StatusRepository

class PlantStatusViewModelImpl : PlantStatusViewModel {
    private val commandRepository: CommandRepository = CommandRepositoryImpl()
    override val plantStatus: LiveData<StatusRepository.GirlStatus> =
        MutableLiveData(StatusRepository.GirlStatus.NORMAL)
    override val isWaterButtonVisible: LiveData<Boolean> = MutableLiveData(true)
    override val isSunlightButtonVisible: LiveData<Boolean> = MutableLiveData(false)
    override val loveMeterParameter: LiveData<Float> = MutableLiveData(4.0f)
    override val message: LiveData<String> = MutableLiveData("お水が欲しいよ〜")

    override fun onWaterButtonClick(v: View) {
        v.findNavController().navigate(R.id.action_plant_status_to_water)
        commandRepository.sendWater()
    }

    override fun onSunlightButtonClick(v: View) {
    }
}