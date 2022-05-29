package kz.noxiq.arbuz.data

import kz.noxiq.arbuz.domain.SubmitTime

class TimeDataSource {
    fun getTimeDataSource(): List<SubmitTime> =
        listOf(
            SubmitTime(11,30,12,30,true),
            SubmitTime(12,30,13,30),
            SubmitTime(13,30,14,30),
            SubmitTime(14,30,15,30),
            SubmitTime(15,30,16,30),
            SubmitTime(16,30,17,30),
        )
}