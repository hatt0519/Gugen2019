package xyz.moroku0519.gugen2019.ui

import android.view.View
import androidx.lifecycle.LiveData
import xyz.moroku0519.gugen2019.data.StatusRepository

interface PlantStatusViewModel {
    val plantStatus: LiveData<StatusRepository.GirlStatus>
    val isWaterButtonVisible: LiveData<Boolean>
    val isSunlightButtonVisible: LiveData<Boolean>
    val loveMeterParameter: LiveData<Float>
    fun onWaterButtonClick(v: View)
    fun onSunlightButtonClick(v: View)
}