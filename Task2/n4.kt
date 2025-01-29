package Tasks2

// Enum для сезонов года
enum class Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

// Функция для получения названия сезона на русском языке
fun getSeasonName(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}

fun main() {
    // Пример использования функции
    val season = Season.SPRING
    println("Сезон $season на русском: ${getSeasonName(season)}")

    // Проверим остальные сезоны
    println("Сезон WINTER на русском: ${getSeasonName(Season.WINTER)}")
    println("Сезон SUMMER на русском: ${getSeasonName(Season.SUMMER)}")
    println("Сезон AUTUMN на русском: ${getSeasonName(Season.AUTUMN)}")
}
