package kz.noxiq.arbuz.ui.submit_order.adapter.time

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.VhDateTimeBinding
import kz.noxiq.arbuz.domain.SubmitTime

class TimeViewHolder(
    private val binding: VhDateTimeBinding,
    private val onSubmitTimeClicked: (SubmitTime) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: SubmitTime) {
        with(binding) {
            tvTime.text = "${data.startHour}:${data.startMinute}-${data.endHour}:${data.endMinute}"
            bindBackground(data.isSelected)
            root.setOnClickListener {
                onSubmitTimeClicked(data)
            }
        }
    }

    fun bindBackground(isSelected: Boolean) {
        with(binding) {
            when (isSelected) {
                true -> {
                    cvTime.background.setTint(ContextCompat.getColor(root.context, R.color.confirm_button_color))
                    tvTime.setTextColor(ContextCompat.getColor(root.context, R.color.white))
                }
                else -> {
                    cvTime.background.setTint(ContextCompat.getColor(root.context, R.color.rv_background_color))
                    tvTime.setTextColor(ContextCompat.getColor(root.context, R.color.rv_text_color))
                }
            }
        }
    }
}