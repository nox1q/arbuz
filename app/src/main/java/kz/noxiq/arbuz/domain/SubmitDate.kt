package kz.noxiq.arbuz.domain

data class SubmitDate(
    val day: Int,
    val month: String,
    var isSelected: Boolean = false
)
