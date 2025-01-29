import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    // Исходная строка даты
    val inputDate = "27-01-2025"

    // Форматтер для парсинга строки в LocalDate
    val inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    // Преобразование строки в LocalDate
    val date = LocalDate.parse(inputDate, inputFormatter)

    // Добавляем 10 дней
    val newDate = date.plusDays(10)

    // Выводим результат в новом формате
    println("Исходная дата: $inputDate")
    println("Дата через 10 дней: ${newDate.format(outputFormatter)}")
}
