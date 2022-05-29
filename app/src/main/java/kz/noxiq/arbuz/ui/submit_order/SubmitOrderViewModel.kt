package kz.noxiq.arbuz.ui.submit_order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.noxiq.arbuz.domain.DateTimeRepository
import kz.noxiq.arbuz.domain.SubmitDate
import kz.noxiq.arbuz.domain.SubmitTime
import javax.inject.Inject

class SubmitOrderViewModel
@Inject constructor(
    dateTimeRepository: DateTimeRepository
): ViewModel(){

    private val submitTimeLiveData = MutableLiveData<List<SubmitTime>>()
    private val submitDateLiveData = MutableLiveData<List<SubmitDate>>()
    private val submitTimePositionsPairLiveData = MutableLiveData<Pair<Int, Int>>()
    private val submitDatePositionsPairLiveData = MutableLiveData<Pair<Int, Int>>()

    private var currentSelectedSubmitTimePosition: Int = 0
    private var currentSelectedSubmitDatePosition: Int = 0

    fun getSubmitTimeLiveData(): LiveData<List<SubmitTime>> = submitTimeLiveData
    fun getSubmitDateLiveData(): LiveData<List<SubmitDate>> = submitDateLiveData
    fun getSubmitTimePositionsPairLiveData(): LiveData<Pair<Int, Int>> = submitTimePositionsPairLiveData
    fun getSubmitDatePositionsPairLiveData(): LiveData<Pair<Int, Int>> = submitDatePositionsPairLiveData

    init {
        submitDateLiveData.value = dateTimeRepository.getDate()
        submitTimeLiveData.value = dateTimeRepository.getTime()
    }

    fun onSubmitTimeClicked(submitTime: SubmitTime) {
        val submitTimesList: List<SubmitTime> = submitTimeLiveData.value ?: return
        val clickedSubmitTimePosition: Int = submitTimesList.indexOf(submitTime)

        if (clickedSubmitTimePosition == -1 || clickedSubmitTimePosition == currentSelectedSubmitTimePosition) {
            return
        }

        submitTime.isSelected = true
        submitTimesList[clickedSubmitTimePosition].isSelected = false

        submitTimePositionsPairLiveData.value = Pair(
            first = currentSelectedSubmitTimePosition,
            second = clickedSubmitTimePosition
        )
        currentSelectedSubmitTimePosition = clickedSubmitTimePosition
    }

    fun onSubmitDateClicked(submitDate: SubmitDate) {
        val submitDatesList: List<SubmitDate> = submitDateLiveData.value ?: return
        val clickedSubmitDatePosition: Int = submitDatesList.indexOf(submitDate)

        if (clickedSubmitDatePosition == -1 || clickedSubmitDatePosition == currentSelectedSubmitDatePosition) {
            return
        }

        submitDate.isSelected = true
        submitDatesList[clickedSubmitDatePosition].isSelected = false

        submitDatePositionsPairLiveData.value = Pair(
            first = currentSelectedSubmitDatePosition,
            second = clickedSubmitDatePosition
        )
        currentSelectedSubmitDatePosition = clickedSubmitDatePosition
    }
}