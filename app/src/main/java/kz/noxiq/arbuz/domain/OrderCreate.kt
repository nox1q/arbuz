package kz.noxiq.arbuz.domain

data class OrderCreate(
    val products: MutableList<Watermelon> = mutableListOf(),
    var totalPrice: Double = 0.0
) {
}