import java.time.LocalDateTime
import java.time.DayOfWeek
import java.time.Duration

fun calculateWorkingHours(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Long {
    var totalWorkingHours = 0L

    var currentDateTime = startDateTime

    while (currentDateTime.isBefore(endDateTime)) {
        // Проверяем, является ли текущий день рабочим (с понедельника по пятницу)
        if (currentDateTime.dayOfWeek != DayOfWeek.SATURDAY && currentDateTime.dayOfWeek != DayOfWeek.SUNDAY) {
            // Если это рабочий день, увеличиваем количество рабочих часов
            val nextHour = currentDateTime.plusHours(1)
            if (nextHour.isBefore(endDateTime)) {
                totalWorkingHours++
            } else {
                // Если время превышает конец рабочего дня, добавляем оставшиеся часы
                totalWorkingHours += Duration.between(currentDateTime, endDateTime).toHours()
                break
            }
        }
        // Переходим к следующему часу
        currentDateTime = currentDateTime.plusHours(1)
    }

    return totalWorkingHours
}

fun main() {
    val startDateTime = LocalDateTime.of(2025, 1, 27, 9, 0, 0, 0) // 27 января, 9:00
    val endDateTime = LocalDateTime.of(2025, 1, 29, 18, 0, 0, 0) // 29 января, 18:00

    val workingHours = calculateWorkingHours(startDateTime, endDateTime)
    println("Количество рабочих часов: $workingHours")
}
