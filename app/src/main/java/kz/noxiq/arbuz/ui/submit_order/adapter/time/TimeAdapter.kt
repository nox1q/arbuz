package kz.noxiq.arbuz.ui.submit_order.adapter.time

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.arbuz.databinding.VhDateTimeBinding
import kz.noxiq.arbuz.domain.SubmitTime

const val KEY_IS_SELECTED = "key_is_selected"

class TimeAdapter(
    private val onSubmitTimeClicked: (SubmitTime) -> Unit
) : ListAdapter<SubmitTime, TimeViewHolder>(DiffUtilCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        val binding = VhDateTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TimeViewHolder(binding, onSubmitTimeClicked)
    }

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: TimeViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)

            return
        }
        for (payload in payloads) {
            if (payload is Bundle) {
                val isSelected: Boolean = payload.getBoolean(KEY_IS_SELECTED)
                holder.bindBackground(isSelected)
            }
        }
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<SubmitTime>() {
    override fun areItemsTheSame(oldItem: SubmitTime, newItem: SubmitTime): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SubmitTime, newItem: SubmitTime): Boolean {
        return oldItem == newItem
    }
}