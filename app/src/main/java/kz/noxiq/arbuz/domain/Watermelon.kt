package kz.noxiq.arbuz.domain

data class Watermelon(
    val id: Long,
    val weight: Double,
    val price: Double,
    val status: Status,
    var count: Int = 0
) {
    enum class Status {
        RIPE, UNRIPE, RIPPED
    }
}

