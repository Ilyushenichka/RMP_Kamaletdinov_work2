import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

fun getDayOfWeekInRussian(date: LocalDate): String {
    // Получаем день недели и выводим его название на русском языке
    return date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru"))
}

fun main() {
    val date = LocalDate.of(2025, 1, 27) // Пример даты: 27 января 2025 года
    val dayOfWeek = getDayOfWeekInRussian(date)
    println("День недели: $dayOfWeek")
}
