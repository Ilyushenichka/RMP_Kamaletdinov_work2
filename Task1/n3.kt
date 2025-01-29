import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun daysUntilNewYear(): Long {
    val today = LocalDate.now() // Текущая дата
    val newYear = LocalDate.of(today.year + 1, 1, 1) // Следующий Новый год
    return ChronoUnit.DAYS.between(today, newYear) // Количество дней
}

fun main() {
    // Вывод количества дней до Нового года
    println("До Нового года осталось ${daysUntilNewYear()} дней!")
}
