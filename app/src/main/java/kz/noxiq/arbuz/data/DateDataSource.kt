package kz.noxiq.arbuz.data

import kz.noxiq.arbuz.domain.SubmitDate

class DateDataSource {
    fun getDateDataSource(): List<SubmitDate> =
        listOf(
            SubmitDate(29, "май",true),
            SubmitDate(30, "май"),
            SubmitDate(31, "май"),
            SubmitDate(1, "июнь"),
            SubmitDate(2, "июнь"),
            SubmitDate(3, "июнь"),
        )
}