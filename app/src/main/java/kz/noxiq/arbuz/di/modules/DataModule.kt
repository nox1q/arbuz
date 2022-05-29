package kz.noxiq.arbuz.di.modules

import dagger.Module
import dagger.Provides
import kz.noxiq.arbuz.data.*
import kz.noxiq.arbuz.domain.DateTimeRepository
import kz.noxiq.arbuz.domain.WatermelonRepository
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    fun providesWatermelonDataSource(): WatermelonDataSource = WatermelonDataSource()

    @Provides
    @Singleton
    fun providesWatermelonRepository(
        watermelonDataSource: WatermelonDataSource
    ): WatermelonRepository = BaseWatermelonRepository(watermelonDataSource)

    @Provides
    @Singleton
    fun providesDateDataSource(): DateDataSource = DateDataSource()

    @Provides
    @Singleton
    fun providesTimeDataSource(): TimeDataSource = TimeDataSource()

    @Provides
    @Singleton
    fun providesDateTimeRepository(
        dateDataSource: DateDataSource,
        timeDataSource: TimeDataSource
    ): DateTimeRepository = BaseDateTimeRepository(dateDataSource, timeDataSource)
}