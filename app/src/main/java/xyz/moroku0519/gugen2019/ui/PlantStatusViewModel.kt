package xyz.moroku0519.gugen2019.ui

import android.graphics.drawable.Drawable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

interface PlantStatusViewModel {
    val plantStatus: MutableLiveData<GirlStatus>
    val girlImage: LiveData<Drawable>
    val isWaterButtonVisible: LiveData<Boolean>
    val isSunlightButtonVisible: LiveData<Boolean>
    val loveMeterParameter: LiveData<Float>
    val message: LiveData<String>
    val buttonLabel: LiveData<String>
    fun onWaterButtonClick(v: View)
    fun onSunlightButtonClick(v: View)
}