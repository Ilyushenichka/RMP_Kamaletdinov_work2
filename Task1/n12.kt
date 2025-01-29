import java.time.LocalDateTime
import java.time.Duration

fun calculateTimeRemaining(eventDateTime: LocalDateTime): String {
    val currentDateTime = LocalDateTime.now() // Текущее время
    val duration = Duration.between(currentDateTime, eventDateTime) // Разница во времени

    val hours = duration.toHours() // Количество часов
    val minutes = duration.toMinutes() % 60 // Количество минут (оставшиеся после часов)
    val seconds = duration.seconds % 60 // Количество секунд (оставшиеся после минут)

    return "$hours часов, $minutes минут, $seconds секунд"
}

fun main() {
    // Пример: событие 27 января 2025 года в 12:00
    val eventDateTime = LocalDateTime.of(2025, 1, 27, 12, 0, 0, 0)

    val remainingTime = calculateTimeRemaining(eventDateTime)
    println("Осталось времени: $remainingTime")
}
