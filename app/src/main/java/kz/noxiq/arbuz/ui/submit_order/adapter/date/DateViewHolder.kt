package kz.noxiq.arbuz.ui.submit_order.adapter.date

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.VhDateTimeBinding
import kz.noxiq.arbuz.domain.SubmitDate
import kz.noxiq.arbuz.domain.SubmitTime

class DateViewHolder(
    private val binding: VhDateTimeBinding,
    private val onSubmitDateClicked: (SubmitDate) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: SubmitDate) {
        with(binding) {
            tvTime.text = "${data.day},${data.month}"
            bindBackground(data.isSelected)
            root.setOnClickListener {
                onSubmitDateClicked(data)
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