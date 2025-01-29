import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {
    /* Создаем объект LocalDate для текущей даты */
    val currentDate = LocalDate.now()

    // Создаем объект LocalTime для текущего времени
    val currentTime = LocalTime.now()

    // Форматируем дату и время
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    // Выводим дату и время в нужном формате
    println("Текущая дата: ${currentDate.format(dateFormatter)}")
    println("Текущее время: ${currentTime.format(timeFormatter)}")
}
