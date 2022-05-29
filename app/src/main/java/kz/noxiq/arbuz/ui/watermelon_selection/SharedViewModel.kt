package kz.noxiq.arbuz.ui.watermelon_selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.noxiq.arbuz.domain.Watermelon
import kz.noxiq.arbuz.domain.WatermelonCountUpdate
import kz.noxiq.arbuz.domain.WatermelonRepository
import kz.noxiq.arbuz.domain.WatermelonRow
import kz.noxiq.arbuz.ui.watermelon_selection.adapter.watermelons_adapter.WatermelonsAdapter
import kz.noxiq.arbuz.ui_common.Event
import javax.inject.Inject

private const val MAX_SELECTED_WATERMELON_COUNT = 3
private const val MIN_SELECTED_WATERMELON_COUNT = 0

class SharedViewModel
@Inject constructor(
    private val watermelonRepository: WatermelonRepository
) : ViewModel() {

    private val clickedWatermelonLiveData = MutableLiveData<Event<Watermelon>>()
    private val selectedWatermelonsLiveData = MutableLiveData<MutableList<Watermelon>>()
    private val watermelonRowsLiveData = MutableLiveData<List<WatermelonRow>>()
    private val watermelonCountUpdateLiveData = MutableLiveData<Event<WatermelonCountUpdate>>()
    private val selectedWatermelonPositionCountPairLiveData = MutableLiveData<Pair<Int, Int>>()
    private val totalPriceLiveData = MutableLiveData<Event<Int>>()

    init {
        val watermelonRows: List<WatermelonRow> = watermelonRepository.getWatermelons()
        watermelonRowsLiveData.value = watermelonRows
        selectedWatermelonsLiveData.value = mutableListOf()
    }

    fun getClickedWatermelonLiveData(): LiveData<Event<Watermelon>> = clickedWatermelonLiveData
    fun getWatermelonRowsLiveData(): LiveData<List<WatermelonRow>> = watermelonRowsLiveData
    fun getWatermelonCountUpdateLiveData(): LiveData<Event<WatermelonCountUpdate>> = watermelonCountUpdateLiveData
    fun getSelectedWatermelonsLiveData(): LiveData<MutableList<Watermelon>> = selectedWatermelonsLiveData
    fun getSelectedWatermelonPositionCountPairLiveData(): LiveData<Pair<Int, Int>> = selectedWatermelonPositionCountPairLiveData
    fun getTotalPriceLiveData(): LiveData<Event<Int>> = totalPriceLiveData

    fun onWatermelonClicked(watermelon: Watermelon) {
        clickedWatermelonLiveData.value = Event(watermelon)
    }

    fun onAddWatermelonClicked(watermelon: Watermelon) {
        if (watermelon.count == MAX_SELECTED_WATERMELON_COUNT) return
        if (watermelon.count++ == MIN_SELECTED_WATERMELON_COUNT) {
            val selectedWatermelons: MutableList<Watermelon> = selectedWatermelonsLiveData.value ?: return
            selectedWatermelons.add(watermelon)
        }
        setWatermelonCountUpdate(watermelon)
        setSelectedWatermelonPositionCountPair(watermelon)
    }

    fun onRemoveWatermelonClicked(watermelon: Watermelon) {
        if (watermelon.count == MIN_SELECTED_WATERMELON_COUNT) return
        if (--watermelon.count == MIN_SELECTED_WATERMELON_COUNT) {
            val selectedWatermelons: MutableList<Watermelon> = selectedWatermelonsLiveData.value ?: return
            val selectedWatermelonsCopy: MutableList<Watermelon> = ArrayList(selectedWatermelons)
            selectedWatermelonsCopy.remove(watermelon)
            selectedWatermelonsLiveData.value = selectedWatermelonsCopy
        }
        setWatermelonCountUpdate(watermelon)
        setSelectedWatermelonPositionCountPair(watermelon)
    }

    private fun setWatermelonCountUpdate(watermelon: Watermelon) {
        val watermelonRows: List<WatermelonRow> = watermelonRowsLiveData.value ?: return

        watermelonRows.forEachIndexed { watermelonRowIndex, watermelonRow ->
            val watermelonPosition: Int = watermelonRow.watermelons.indexOf(watermelon)

            if (watermelonPosition != -1) {
                val watermelonCountUpdate = WatermelonCountUpdate(
                    watermelonRowPosition = watermelonRowIndex,
                    watermelonPosition = watermelonPosition,
                    count = watermelon.count
                )
                watermelonCountUpdateLiveData.value = Event(watermelonCountUpdate)
            }
        }
    }

    private fun setSelectedWatermelonPositionCountPair(selectedWatermelon: Watermelon) {
        val selectedWatermelons: List<Watermelon> = selectedWatermelonsLiveData.value ?: return
        val selectedWatermelonPosition: Int = selectedWatermelons.indexOf(selectedWatermelon)

        if (selectedWatermelonPosition != -1) {
            selectedWatermelonPositionCountPairLiveData.value = Pair(
                first = selectedWatermelonPosition,
                second = selectedWatermelon.count
            )
        }
    }

    fun onSubmitClicked() {
        val selectedWatermelons: List<Watermelon> = selectedWatermelonsLiveData.value ?: return
        var totalPrice = 0

        for(selectedWatermelon in selectedWatermelons) {
            totalPrice += (selectedWatermelon.count * selectedWatermelon.price).toInt()
        }
        totalPriceLiveData.value = Event(totalPrice)
    }
}