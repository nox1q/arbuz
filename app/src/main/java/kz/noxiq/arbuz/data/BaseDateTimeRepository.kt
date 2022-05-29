package kz.noxiq.arbuz.data

import kz.noxiq.arbuz.domain.DateTimeRepository
import kz.noxiq.arbuz.domain.SubmitDate
import kz.noxiq.arbuz.domain.SubmitTime

class BaseDateTimeRepository(
    private val dateData: DateDataSource,
    private val timeData: TimeDataSource
) : DateTimeRepository {
    override fun getTime(): List<SubmitTime> {
        return timeData.getTimeDataSource()
    }

    override fun getDate(): List<SubmitDate> {
        return dateData.getDateDataSource()
    }
}