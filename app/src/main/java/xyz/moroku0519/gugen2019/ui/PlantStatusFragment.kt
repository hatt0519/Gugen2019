package xyz.moroku0519.gugen2019.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import xyz.moroku0519.gugen2019.databinding.FragmentPlantStatusBinding

class PlantStatusFragment : Fragment() {
    private val args: PlantStatusFragmentArgs by navArgs()
    private var viewModel: PlantStatusViewModel? = null
    private val section: LoveSection = LoveSection()
    private val adapter: GroupAdapter<GroupieViewHolder> = GroupAdapter<GroupieViewHolder>().apply {
        add(section)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(PlantStatusViewModelImpl::class.java).also {
                lifecycle.addObserver(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentPlantStatusBinding.inflate(inflater, container, false).apply {
            viewModel = this@PlantStatusFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            loveParameter.adapter = adapter
        }.root

    override fun onStart() {
        viewModel?.plantStatus?.postValue(args.girlStatus)
        super.onStart()
    }

}
