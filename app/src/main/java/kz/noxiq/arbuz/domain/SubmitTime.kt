package kz.noxiq.arbuz.domain

data class SubmitTime(
    val startHour: Int,
    val startMinute: Int,
    val endHour: Int,
    val endMinute: Int,
    var isSelected: Boolean = false
)
