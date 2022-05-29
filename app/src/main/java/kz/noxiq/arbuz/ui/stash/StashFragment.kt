package kz.noxiq.arbuz.ui.stash

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.FragmentStashBinding
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonCountUpdate
import kz.noxiq.arbuz.ui.stash.adapter.WatermelonStashAdapter
import kz.noxiq.arbuz.ui.watermelon_selection.SharedViewModel
import kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelon_adapter.KEY_WATERMELON_COUNT
import kz.noxiq.arbuz.ui_common.observeEvent
import javax.inject.Inject

class StashFragment : DaggerFragment(R.layout.fragment_stash) {

    private lateinit var binding: FragmentStashBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SharedViewModel by activityViewModels {
        viewModelFactory
    }

    private val watermelonStashAdapter: WatermelonStashAdapter by lazy {
        WatermelonStashAdapter(
            viewModel::onAddWatermelonClicked,
            viewModel::onRemoveWatermelonClicked
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStashBinding.bind(view)
        binding.rvSelectedWatermelons.adapter = watermelonStashAdapter
        observeViewModel()
        setupListeners()
    }

    private fun observeViewModel() {
        viewModel.getSelectedWatermelonsLiveData()
            .observe(viewLifecycleOwner, ::handleSelectedWatermelons)
        viewModel.getSelectedWatermelonPositionCountPairLiveData()
            .observe(viewLifecycleOwner, ::handleSelectedWatermelonPositionCountPair)
        viewModel.getTotalPriceLiveData().observeEvent(viewLifecycleOwner,::handleTotalPrice)
    }

    private fun handleSelectedWatermelonPositionCountPair(selectedWatermelonPositionCountPair: Pair<Int, Int>) {
        watermelonStashAdapter.notifyItemChanged(
            selectedWatermelonPositionCountPair.first,
            bundleOf(
                KEY_WATERMELON_COUNT to selectedWatermelonPositionCountPair.second
            )
        )
    }

    private fun handleTotalPrice(totalPrice: Int) {
        findNavController().navigate(
            StashFragmentDirections.actionStashFragmentToSubmitOrderFragment(totalPrice)
        )
    }

    private fun setupListeners() {
        binding.btnPay.setOnClickListener {
            viewModel.onSubmitClicked()
        }
    }

    private fun handleSelectedWatermelons(watermelons: List<Watermelon>) {
        if (watermelons.isEmpty()) {
            return
        }
        binding.clContent.visibility = View.VISIBLE
        binding.layoutEmpty.root.visibility = View.GONE
        watermelonStashAdapter.submitList(watermelons)
    }
}