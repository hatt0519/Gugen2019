package xyz.moroku0519.gugen2019

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_plant_status.view.*

class PlantStatusFragment : Fragment() {
    private val args : PlantStatusFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_plant_status, container, false).apply {
            this.send.setOnClickListener {
                it.findNavController().navigate(R.id.action_plant_status_to_water)
            }
            args.message?.let {
                this.message.text = it
            }
        }
}


