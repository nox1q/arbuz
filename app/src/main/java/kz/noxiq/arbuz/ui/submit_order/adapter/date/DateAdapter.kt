package kz.noxiq.arbuz.ui.submit_order.adapter.date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.noxiq.arbuz.databinding.VhDateTimeBinding
import kz.noxiq.arbuz.domain.SubmitDate
import kz.noxiq.arbuz.domain.SubmitTime
import kz.noxiq.arbuz.ui.submit_order.adapter.time.KEY_IS_SELECTED
import kz.noxiq.arbuz.ui.submit_order.adapter.time.TimeViewHolder

class DateAdapter(
    private val onSubmitDateClicked: (SubmitDate) -> Unit
) : ListAdapter<SubmitDate, DateViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val binding = VhDateTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DateViewHolder(binding, onSubmitDateClicked)
    }

    override fun onBindViewHolder(
        holder: DateViewHolder,
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

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

private object DiffUtilCallback : DiffUtil.ItemCallback<SubmitDate>() {
    override fun areItemsTheSame(oldItem: SubmitDate, newItem: SubmitDate): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SubmitDate, newItem: SubmitDate): Boolean {
        return oldItem == newItem
    }
}