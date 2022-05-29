package kz.noxiq.arbuz.ui.submit_order

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.FragmentSubmitOrderBinding
import kz.noxiq.arbuz.ui.submit_order.adapter.date.DateAdapter
import kz.noxiq.arbuz.ui.submit_order.adapter.time.KEY_IS_SELECTED
import kz.noxiq.arbuz.ui.submit_order.adapter.time.TimeAdapter
import javax.inject.Inject

class SubmitOrderFragment : DaggerFragment(R.layout.fragment_submit_order) {

    private lateinit var binding: FragmentSubmitOrderBinding
    private val args: SubmitOrderFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SubmitOrderViewModel by viewModels {
        viewModelFactory
    }

    private val timeAdapter by lazy {
        TimeAdapter(viewModel::onSubmitTimeClicked)
    }

    private val dateAdapter by lazy {
        DateAdapter(viewModel::onSubmitDateClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubmitOrderBinding.bind(view)
        observeViewModel()
        binding.rvTime.adapter = timeAdapter
        binding.rvDate.adapter = dateAdapter
        binding.tvTotalPrice.text = "Всего к оплате: ${args.price} $"
    }

    private fun observeViewModel() {
        with(viewModel) {
            getSubmitDateLiveData().observe(viewLifecycleOwner,dateAdapter::submitList)
            getSubmitTimeLiveData().observe(viewLifecycleOwner,timeAdapter::submitList)
            getSubmitTimePositionsPairLiveData().observe(viewLifecycleOwner, ::handleSubmitTimePositionsPair)
            getSubmitDatePositionsPairLiveData().observe(viewLifecycleOwner, ::handleSubmitDatePositionsPair)
        }
    }

    private fun handleSubmitTimePositionsPair(submitTimePositionsPair: Pair<Int, Int>) {
        val currentSelectedPosition: Int = submitTimePositionsPair.first
        val newSelectedPosition: Int = submitTimePositionsPair.second

        timeAdapter.notifyItemChanged(
            currentSelectedPosition,
            bundleOf(
                KEY_IS_SELECTED to false
            )
        )
        timeAdapter.notifyItemChanged(
            newSelectedPosition,
            bundleOf(
                KEY_IS_SELECTED to true
            )
        )
    }

    private fun showSnackbar() {
        binding.btnPay.setOnClickListener {
            //Snackbar.make(view,"Заказ успешно оформлен", Snackbar.LENGTH_LONG)
        }
    }


    private fun handleSubmitDatePositionsPair(submitDatePositionsPair: Pair<Int, Int>) {
        val currentSelectedPosition: Int = submitDatePositionsPair.first
        val newSelectedPosition: Int = submitDatePositionsPair.second

        dateAdapter.notifyItemChanged(
            currentSelectedPosition,
            bundleOf(
                KEY_IS_SELECTED to false
            )
        )
        dateAdapter.notifyItemChanged(
            newSelectedPosition,
            bundleOf(
                KEY_IS_SELECTED to true
            )
        )
    }
}