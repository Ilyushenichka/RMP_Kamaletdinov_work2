fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun main() {
    // Пример использования метода
    val year = 2024 // Замените на любой год для проверки
    if (isLeapYear(year)) {
        println("$year год является високосным.")
    } else {
        println("$year год не является високосным.")
    }
}
