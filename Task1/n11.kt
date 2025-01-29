import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

fun generateRandomDateInRange(startDate: LocalDate, endDate: LocalDate): LocalDate {
    // Вычисляем количество дней между датами
    val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)

    // Генерируем случайное число от 0 до количества дней в диапазоне
    val randomDays = Random.nextLong(daysBetween + 1)

    // Получаем случайную дату, прибавляя случайное количество дней к начальной дате
    return startDate.plusDays(randomDays)
}

fun main() {
    val startDate = LocalDate.of(2020, 1, 1)
    val endDate = LocalDate.of(2025, 1, 1)

    val randomDate = generateRandomDateInRange(startDate, endDate)
    println("Случайная дата в диапазоне: $randomDate")
}
