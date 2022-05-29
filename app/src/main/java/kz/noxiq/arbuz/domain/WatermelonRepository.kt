package kz.noxiq.arbuz.domain

interface WatermelonRepository {

    fun getWatermelons(): List<WatermelonRow>
}