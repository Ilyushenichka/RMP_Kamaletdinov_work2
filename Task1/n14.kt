import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun formatDateWithLocale(date: LocalDate, locale: Locale): String {
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", locale) // Форматируем в день месяц год
    return date.format(formatter)
}

fun main() {
    val date = LocalDate.of(2025, 1, 27)

    // Пример для русской локали
    val formattedDateRu = formatDateWithLocale(date, Locale("ru"))
    println("Дата на русском: $formattedDateRu")

    // Пример для английской локали
    val formattedDateEn = formatDateWithLocale(date, Locale("en"))
    println("Date in English: $formattedDateEn")
}
