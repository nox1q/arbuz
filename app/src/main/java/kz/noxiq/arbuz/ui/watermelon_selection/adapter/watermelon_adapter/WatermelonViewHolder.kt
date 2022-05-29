package kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelon_adapter

import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.noxiq.arbuz.R
import kz.noxiq.arbuz.databinding.VhWatermelonBinding
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.ui_common.setVisibility

class WatermelonViewHolder(
    private val binding: VhWatermelonBinding,
    private val onWatermelonClicked: (watermelon: Watermelon) -> Unit,
    private val onAddWatermelonClicked: (Watermelon) -> Unit,
    private val onRemoveWatermelonClicked: (Watermelon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Watermelon) {
        with(binding) {
            val statusIconResId: Int = R.drawable.ripe
            val statusTextResId: Int = getStatusTextResId(data.status)

            tvPrice.text = "${data.price} $"
            tvStatus.text = root.context.getString(statusTextResId)
            tvWeight.text = "${data.weight} kg"

            Glide.with(root).load(statusIconResId).into(ivArbuz)
            bindCount(data.count)

            ivArbuz.setOnClickListener {
                onWatermelonClicked(data)
            }

            tvAdd.setOnClickListener {
                onAddWatermelonClicked(data)
            }
            tvRemove.setOnClickListener {
                onRemoveWatermelonClicked(data)
            }
        }
    }

    fun bindCount(count: Int) {
        val isCountHigherThanZero: Boolean = count > 0

        with(binding) {
            tvCount.setVisibility(isCountHigherThanZero)
            tvRemove.setVisibility(isCountHigherThanZero)
            tvPrice.setVisibility(!isCountHigherThanZero)
            tvCount.text = count.toString()
        }
    }

    @StringRes
    private fun getStatusTextResId(status: Watermelon.Status): Int = when (status) {
        Watermelon.Status.RIPE -> R.string.ripe
        Watermelon.Status.UNRIPE -> R.string.unripe
        Watermelon.Status.RIPPED -> R.string.ripped
    }
}