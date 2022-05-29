package kz.noxiq.arbuz.data

import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonRepository
import kz.noxiq.arbuz.domain.WatermelonRow

class BaseWatermelonRepository(
    private val watermelonDataSource: WatermelonDataSource
) : WatermelonRepository {

    override fun getWatermelons(): List<WatermelonRow> {
        return watermelonDataSource.getWatermelons()
    }
}