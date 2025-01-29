import java.time.LocalDate

fun compareDates(date1: LocalDate, date2: LocalDate): String {
    return when {
        date1.isAfter(date2) -> "Первая дата больше второй."
        date1.isBefore(date2) -> "Первая дата меньше второй."
        else -> "Обе даты равны."
    }
}

fun main() {
    // Пример использования метода
    val date1 = LocalDate.of(2025, 1, 1) // Первая дата
    val date2 = LocalDate.of(2024, 12, 31) // Вторая дата

    // Сравниваем даты и выводим результат
    println(compareDates(date1, date2))
}
