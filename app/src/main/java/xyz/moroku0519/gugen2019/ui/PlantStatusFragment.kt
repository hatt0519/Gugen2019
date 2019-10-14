package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import xyz.moroku0519.gugen2019.GugenApplication
import xyz.moroku0519.gugen2019.data.GirlsRepository
import xyz.moroku0519.gugen2019.data.GirlsRepositoryImpl
import xyz.moroku0519.gugen2019.databinding.FragmentPlantStatusBinding

class PlantStatusFragment : Fragment() {
    private val args: PlantStatusFragmentArgs by navArgs()
    private val girlsRepository: GirlsRepository = GirlsRepositoryImpl()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentPlantStatusBinding.inflate(inflater, container, false).apply {
            viewModel = PlantStatusViewModelImpl(GugenApplication.application).apply {
                girlsRepository.loadGirl(
                    { girl ->
                        plantStatus.postValue(girl.girlStatus)
                    },
                    {
                        Log.e("error", it?.message)
                    }
                )
//                plantStatus.postValue(args.girlStatus)
            }
            lifecycleOwner = viewLifecycleOwner
        }.root

}
