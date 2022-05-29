package kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelon_adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.arbuz.databinding.VhWatermelonBinding
import kz.noxiq.arbuz.domain.Watermelon

const val KEY_WATERMELON_COUNT = "key_watermelon_count"

class WatermelonAdapter(
    private val onWatermelonClicked: (Watermelon) -> Unit,
    private val onAddWatermelonClicked: (Watermelon) -> Unit,
    private val onRemoveWatermelonClicked: (Watermelon) -> Unit
) : ListAdapter<Watermelon, WatermelonViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatermelonViewHolder {
        val binding = VhWatermelonBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WatermelonViewHolder(binding, onWatermelonClicked, onAddWatermelonClicked, onRemoveWatermelonClicked)
    }

    override fun onBindViewHolder(holder: WatermelonViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: WatermelonViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)

            return
        }

        for (payload in payloads) {
            if (payload is Bundle) {
                val newCount: Int = payload.getInt(KEY_WATERMELON_COUNT)
                holder.bindCount(newCount)
            }
        }
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<Watermelon>() {
    override fun areItemsTheSame(oldItem: Watermelon, newItem: Watermelon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Watermelon, newItem: Watermelon): Boolean {
        return oldItem == newItem
    }
}