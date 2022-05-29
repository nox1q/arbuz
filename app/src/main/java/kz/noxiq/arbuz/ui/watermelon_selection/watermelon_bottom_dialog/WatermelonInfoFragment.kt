package kz.noxiq.arbuz.ui.watermelon_selection.watermelon_bottom_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.ui.watermelon_selection.SharedViewModel
import javax.inject.Inject

class WatermelonInfoFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogFragment

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SharedViewModel by activityViewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.bottom_dialog_watermelon_info, container, false)

}