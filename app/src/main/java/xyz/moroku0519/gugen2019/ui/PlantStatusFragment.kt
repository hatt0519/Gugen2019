package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_plant_status.view.*
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.data.CommandRepository
import xyz.moroku0519.gugen2019.data.CommandRepositoryImpl

class PlantStatusFragment : Fragment() {
    private val args: PlantStatusFragmentArgs by navArgs()
    private val commandRepository: CommandRepository = CommandRepositoryImpl()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_plant_status, container, false).apply {
            this.send.setOnClickListener {
                it.findNavController().navigate(R.id.action_plant_status_to_water)
                commandRepository.sendWater()
            }
            args.message?.let {
                this.message.text = it
            }
        }
}


