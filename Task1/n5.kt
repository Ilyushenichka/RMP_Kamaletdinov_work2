import java.time.DayOfWeek
import java.time.LocalDate

fun countWeekends(year: Int, month: Int): Int {
    var weekends = 0
    val daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth() // Количество дней в месяце

    for (day in 1..daysInMonth) {
        val date = LocalDate.of(year, month, day)
        if (date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY) {
            weekends++
        }
    }
    return weekends
}

fun main() {
    // Пример использования
    val year = 2025
    val month = 1 // Январь

    println("Количество выходных в $month/$year: ${countWeekends(year, month)}")
}
