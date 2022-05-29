package kz.noxiq.arbuz.domain

import java.net.Inet4Address

data class SubmitForm(
    val address: String,
    val name: String,
    val phone: String
)
