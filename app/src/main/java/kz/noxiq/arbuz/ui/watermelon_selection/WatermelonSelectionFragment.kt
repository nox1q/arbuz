package kz.noxiq.arbuz.ui.watermelon_selection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.FragmentWatermelonSelectionBinding
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonCountUpdate
import kz.noxiq.arbuz.domain.WatermelonRow
import kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelons_adapter.WatermelonsAdapter
import kz.noxiq.arbuz.ui_common.observeEvent
import javax.inject.Inject

class WatermelonSelectionFragment : DaggerFragment(R.layout.fragment_watermelon_selection) {

    private lateinit var binding: FragmentWatermelonSelectionBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SharedViewModel by activityViewModels {
        viewModelFactory
    }

    private val watermelonsAdapter: WatermelonsAdapter by lazy {
        WatermelonsAdapter(
            viewModel::onWatermelonClicked,
            viewModel::onAddWatermelonClicked,
            viewModel::onRemoveWatermelonClicked
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWatermelonSelectionBinding.bind(view)
        binding.rvWatermelons.adapter = watermelonsAdapter
        observeViewModel()
    }

    private fun observeViewModel() {
        with(viewModel) {
            getWatermelonRowsLiveData().observe(viewLifecycleOwner, watermelonsAdapter::submitList)
            getClickedWatermelonLiveData().observeEvent(viewLifecycleOwner) { openWatermelonDialog() }
            getWatermelonCountUpdateLiveData().observeEvent(viewLifecycleOwner, ::handleWatermelonCountUpdate)
        }
    }

    private fun openWatermelonDialog() {
        findNavController().navigate(
            WatermelonSelectionFragmentDirections.actionWatermelonSelectionFragmentToWatermelonInfoFragment()
        )
    }

    private fun handleWatermelonCountUpdate(watermelonCountUpdate: WatermelonCountUpdate) {
        watermelonsAdapter.notifyItemChanged(
            watermelonCountUpdate.watermelonRowPosition,
            watermelonCountUpdate
        )
    }
}