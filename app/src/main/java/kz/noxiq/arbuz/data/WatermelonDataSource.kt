package kz.noxiq.arbuz.data

import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonRow

class WatermelonDataSource {
    fun getWatermelons(): List<WatermelonRow> = listOf(
        WatermelonRow(
            0,
            listOf(
                Watermelon(1, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(2, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(3, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(4, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(32, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(5, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(6, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(7, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(8, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(9, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(10, 11.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
        WatermelonRow(
            1,
            listOf(
                Watermelon(11, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(12, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(13, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(14, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(15, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(16, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(17, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(18, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(19, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(20, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(21, 11.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
        WatermelonRow(
            2,
            listOf(
                Watermelon(1_000_000, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(22, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(23, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(24, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(25, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(26, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(27, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(28, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(29, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(30, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(31, 11.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
        WatermelonRow(
            3,
            listOf(
                Watermelon(41, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(42, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(43, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(44, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(45, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(46, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(47, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(48, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(49, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(40, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(444, 11.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
        WatermelonRow(
            4,
            listOf(
                Watermelon(51, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(52, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(53, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(54, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(55, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(56, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(57, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(58, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(59, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(60, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(61, 1.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
        WatermelonRow(
            5,
            listOf(
                Watermelon(160, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(161, 6.1, 5.0, Watermelon.Status.RIPE),
                Watermelon(162, 12.1, 6.0, Watermelon.Status.UNRIPE),
                Watermelon(163, 8.2, 7.0, Watermelon.Status.RIPE),
                Watermelon(164, 4.7, 8.0, Watermelon.Status.RIPPED),
                Watermelon(165, 6.4, 9.5, Watermelon.Status.RIPPED),
                Watermelon(166, 8.4, 12.5, Watermelon.Status.RIPE),
                Watermelon(167, 7.3, 13.0, Watermelon.Status.RIPE),
                Watermelon(168, 5.5, 12.0, Watermelon.Status.UNRIPE),
                Watermelon(169, 9.8, 7.0, Watermelon.Status.RIPE),
                Watermelon(170, 11.3, 8.0, Watermelon.Status.UNRIPE)
            )
        ),
    )
}