package xyz.moroku0519.gugen2019.ui

import android.graphics.drawable.Drawable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import xyz.moroku0519.gugen2019.data.entity.GirlStatus

interface PlantStatusViewModel {
    val isDebugMode: MutableLiveData<Boolean>
    val plantStatus: MutableLiveData<GirlStatus>
    val debugPlantStatus: LiveData<GirlStatus>
    val girlImage: LiveData<Drawable>
    val isButtonVisible: LiveData<Boolean>
    val loveMeterParameter: LiveData<Int>
    val message: LiveData<String>
    val buttonLabel: LiveData<String>
    val debugGirlStatusList: List<String>
    val debugGirlStatusId: MutableLiveData<Int>
    fun onButtonClick(v: View)
    fun onDebugButtonClick(v: View) : Boolean
}