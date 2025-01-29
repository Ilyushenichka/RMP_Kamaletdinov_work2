import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun printMonthCalendar(year: Int, month: Int) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth()) // Последний день месяца

    println("Календарь на $month/$year:")

    var currentDate = firstDayOfMonth
    while (currentDate <= lastDayOfMonth) {
        val dayOfWeek = currentDate.dayOfWeek
        val dayType = if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            "Выходной"
        } else {
            "Рабочий день"
        }
        println("${currentDate.format(formatter)} - $dayType")
        currentDate = currentDate.plusDays(1) // Переход к следующему дню
    }
}

fun main() {
    val year = 2025
    val month = 1 // Январь
    printMonthCalendar(year, month)
}
