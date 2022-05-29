package kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelons_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.arbuz.databinding.VhWatermelonsBinding
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonCountUpdate
import kz.noxiq.arbuz.domain.WatermelonRow

class WatermelonsAdapter(
    private val onWatermelonClicked: (Watermelon) -> Unit,
    private val onAddWatermelonClicked: (Watermelon) -> Unit,
    private val onRemoveWatermelonClicked: (Watermelon) -> Unit
) : ListAdapter<WatermelonRow, WatermelonsViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatermelonsViewHolder {
        val binding = VhWatermelonsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WatermelonsViewHolder(binding, onWatermelonClicked, onAddWatermelonClicked, onRemoveWatermelonClicked)
    }

    override fun onBindViewHolder(holder: WatermelonsViewHolder, position: Int) {
        holder.onBind(getItem(position).watermelons)
    }

    override fun onBindViewHolder(
        holder: WatermelonsViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)

            return
        }

        for (payload in payloads) {
            if (payload is WatermelonCountUpdate) {
                holder.bindWatermelonCountUpdate(payload)
            }
        }
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<WatermelonRow>() {
    override fun areItemsTheSame(oldItem: WatermelonRow, newItem: WatermelonRow): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WatermelonRow, newItem: WatermelonRow): Boolean {
        return oldItem == newItem
    }
}