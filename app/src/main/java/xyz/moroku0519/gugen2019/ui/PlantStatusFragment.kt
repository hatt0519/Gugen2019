package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import xyz.moroku0519.gugen2019.data.CommandRepository
import xyz.moroku0519.gugen2019.data.CommandRepositoryImpl
import xyz.moroku0519.gugen2019.databinding.FragmentPlantStatusBinding

class PlantStatusFragment : Fragment() {
    private val args: PlantStatusFragmentArgs by navArgs()
    private val commandRepository: CommandRepository = CommandRepositoryImpl()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentPlantStatusBinding.inflate(inflater, container, false).apply {
            viewModel = PlantStatusViewModelImpl()
        }.root

}


