package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import xyz.moroku0519.gugen2019.GugenApplication
import xyz.moroku0519.gugen2019.databinding.FragmentPlantStatusBinding

class PlantStatusFragment : Fragment() {
    private val args: PlantStatusFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentPlantStatusBinding.inflate(inflater, container, false).apply {
            viewModel = ViewModelProviders.of(
                this@PlantStatusFragment,
                PlantStatusViewModelImpl.ViewModelFactory(GugenApplication.application)
            ).get(PlantStatusViewModelImpl::class.java)
                .apply {
                    plantStatus.postValue(args.girlStatus)
                }
            lifecycleOwner = viewLifecycleOwner
        }.root

}
