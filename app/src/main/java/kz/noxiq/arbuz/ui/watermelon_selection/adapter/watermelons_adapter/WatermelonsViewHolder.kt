package kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelons_adapter

import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.arbuz.databinding.VhWatermelonsBinding
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonCountUpdate
import kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelon_adapter.KEY_WATERMELON_COUNT
import kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelon_adapter.WatermelonAdapter

class WatermelonsViewHolder(
    private val binding: VhWatermelonsBinding,
    private val onWatermelonClicked: (Watermelon) -> Unit,
    private val onAddWatermelonClicked: (Watermelon) -> Unit,
    private val onRemoveWatermelonClicked: (Watermelon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val watermelonAdapter by lazy {
        WatermelonAdapter(onWatermelonClicked, onAddWatermelonClicked, onRemoveWatermelonClicked)
    }

    fun onBind(watermelons: List<Watermelon>) {
        with(binding) {
            tvRow.text = "${adapterPosition+1} Ряд"
            rvWatermelons.adapter = watermelonAdapter
            watermelonAdapter.submitList(watermelons)
        }
    }

    fun bindWatermelonCountUpdate(watermelonCountUpdate: WatermelonCountUpdate) {
        watermelonAdapter.notifyItemChanged(
            watermelonCountUpdate.watermelonPosition,
            bundleOf(
                KEY_WATERMELON_COUNT to watermelonCountUpdate.count
            )
        )
    }
}