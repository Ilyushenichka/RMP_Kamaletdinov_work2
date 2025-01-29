import java.time.ZonedDateTime
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun convertTimeToZone(utcDateTime: String, targetZone: String): String {
    // Форматтер для парсинга даты и времени
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    // Парсим дату и время в формате UTC
    val utcTime = ZonedDateTime.of(
        LocalDateTime.parse(utcDateTime, formatter),
        ZoneId.of("UTC")
    )

    // Конвертируем время в указанный часовой пояс
    val targetTime = utcTime.withZoneSameInstant(ZoneId.of(targetZone))

    // Возвращаем результат в формате yyyy-MM-dd HH:mm:ss
    return targetTime.format(formatter)
}

fun main() {
    val utcDateTime = "2025-01-27 12:00:00" // Входные дата и время в UTC
    val targetZone = "Europe/Moscow" // Часовой пояс назначения

    val convertedTime = convertTimeToZone(utcDateTime, targetZone)
    println("Время в UTC: $utcDateTime")
    println("Время в $targetZone: $convertedTime")
}
