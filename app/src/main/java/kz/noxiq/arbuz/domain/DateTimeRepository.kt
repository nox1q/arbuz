package kz.noxiq.arbuz.domain

interface DateTimeRepository {
    fun getTime() : List<SubmitTime>
    fun getDate() : List<SubmitDate>
}